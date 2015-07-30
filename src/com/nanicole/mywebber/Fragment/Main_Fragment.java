package com.nanicole.mywebber.Fragment;

import java.util.List;

import com.nanicole.mywebber.R;
import com.nanicole.mywebber.Adapter.Main_list_adapter;
import com.nanicole.mywebber.MyInterface.Home_get_interface;
import com.nanicole.mywebber.Myclass.Weibo;
import com.nanicole.mywebber.Util.API;
import com.nanicole.mywebber.Util.APP_Screct;
import com.nanicole.mywebber.network.Home_get;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class Main_Fragment extends Fragment{
	private RecyclerView main_list;
	private SwipeRefreshLayout swipe;
	private Main_list_adapter main_adapter;
	private List<Weibo> list=null;
	private ProgressBar probar;
	private boolean isrefreshing=false,isloading=false;
	private LinearLayoutManager layoutManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View v=inflater.inflate(R.layout.main_frag, container, false);
		swipe=(SwipeRefreshLayout) v.findViewById(R.id.main_swipe);
		main_list=(RecyclerView) v.findViewById(R.id.main_list);
		layoutManager=new LinearLayoutManager(getActivity());
		probar=(ProgressBar) v.findViewById(R.id.main_bar);
//		main_adapter=new Main_list_adapter(list);
		new Clean_Item();
		main_list.setLayoutManager(layoutManager);
//		main_list.setAdapter(main_adapter);
		swipe.setOnRefreshListener(new Refresh_listener());
//		View v=inflater.inflate(R.layout.textpage, container, false);
		main_list.setOnScrollListener(new List_scroll_listener());
		
		return v;
	}
	class Clean_Item implements Home_get_interface{
		

		public Clean_Item() {
			// TODO 自动生成的构造函数存根
			if(isrefreshing||isloading) return;
			else isrefreshing=true;
			Home_get task=new Home_get();
			Log.e("task", "task");
			task.set_interface(this);
			task.execute(API.Home_get+"?access_token="+APP_Screct.Access_token);
//			swipe.setRefreshing(true);
		}

		@Override
		public void Home_get_deal(List<Weibo> list) {
			// TODO 自动生成的方法存根
//			main_adapter.refresh_item(list);
//			main_adapter.notifyDataSetChanged();
			main_adapter=new Main_list_adapter(list);
			main_list.setAdapter(main_adapter);
			probar.setVisibility(View.GONE);
			isrefreshing=false;
//			swipe.setRefreshing(false);
		}
		
	}
	class Refresh_listener implements OnRefreshListener,Home_get_interface{

		@Override
		public void onRefresh() {
			// TODO 自动生成的方法存根
			if(isrefreshing||isloading) return;
			else isrefreshing=true;
			Home_get task=new Home_get();
			task.set_interface(this);
			task.execute(API.Home_get+"?access_token="+APP_Screct.Access_token);
		}

		@Override
		public void Home_get_deal(List<Weibo> list) {
			// TODO 自动生成的方法存根
			main_adapter.refresh_item(list);
			main_adapter.notifyDataSetChanged();
			swipe.setRefreshing(false);
			isrefreshing=false;
			
		}
		
		
	}
	class List_scroll_listener extends OnScrollListener implements Home_get_interface{

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			// TODO 自动生成的方法存根
			super.onScrollStateChanged(recyclerView, newState);
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			// TODO 自动生成的方法存根
			super.onScrolled(recyclerView, dx, dy);
			if(isloading||isrefreshing) return;
			int total_num=layoutManager.getItemCount();
			int last_item=layoutManager.findLastCompletelyVisibleItemPosition();
			int first_item=layoutManager.findFirstCompletelyVisibleItemPosition();
			if(last_item>=total_num-4){
				isloading=true;
				int page=total_num/20+1;
				Home_get task=new Home_get();
				task.set_interface(this);
				task.execute(API.Home_get+"?access_token="+APP_Screct.Access_token+"&page="+page);
				
						
			}
			
		}

		@Override
		public void Home_get_deal(List<Weibo> list) {
			// TODO 自动生成的方法存根
			main_adapter.load_more(list);
			main_adapter.notifyDataSetChanged();
			isloading=false;
		}
		
		
	}
	

}
