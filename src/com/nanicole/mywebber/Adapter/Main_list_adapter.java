package com.nanicole.mywebber.Adapter;

import java.util.List;

import com.nanicole.mywebber.R;
import com.nanicole.mywebber.Myclass.Weibo;
import com.nanicole.mywebber.Util.Pics_Download_Util;
import com.nanicole.mywebber.Util.Pics_Girdview_Util;
import com.nanicole.mywebber.ViewHolder.Main_item_holder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Main_list_adapter extends RecyclerView.Adapter<ViewHolder>{
	private List<Weibo> list=null;

	public Main_list_adapter(List<Weibo> list) {
		// TODO 自动生成的构造函数存根
		this.list=list;
	}

	@Override
	public int getItemCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int num) {
		// TODO 自动生成的方法存根
		new Pics_Download_Util(((Main_item_holder)holder).users_avatar, list.get(num).user().avatar_large(), 0);
		((Main_item_holder)holder).account_text.setText(list.get(num).text());
		((Main_item_holder)holder).users_name.setText(list.get(num).user().name());
		((Main_item_holder)holder).stair_num.setText("# "+num);
		switch (getItemViewType(num)) {
		case 0:
			((Main_item_holder)holder).quote.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pic.setVisibility(View.GONE);
			break;
		case 1:
//			holder.itemView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			((Main_item_holder)holder).account_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).quote.setVisibility(View.GONE);
			new Pics_Download_Util(((Main_item_holder)holder).account_pic, list.get(num).bmiddle_pic(), 1);
			((Main_item_holder)holder).account_pic.setLayerType(View.LAYER_TYPE_SOFTWARE, null);// close the hardwareAccelerated
			break;
		case 2:
			((Main_item_holder)holder).quote.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pic.setVisibility(View.GONE);
			new Pics_Girdview_Util(list.get(num).pic_urls(), ((Main_item_holder)holder).account_pics);
			
			break;
		case 3:
			((Main_item_holder)holder).account_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pic.setVisibility(View.GONE);
			((Main_item_holder)holder).quote_pic.setVisibility(View.GONE);
			((Main_item_holder)holder).quote_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).quote_name.setText(list.get(num).retweeted_status().user().name());
			((Main_item_holder)holder).quote_text.setText(list.get(num).retweeted_status().text());
			break;
		case 4:
//			holder.itemView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			((Main_item_holder)holder).account_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pic.setVisibility(View.GONE);
			((Main_item_holder)holder).quote_name.setText(list.get(num).retweeted_status().user().name());
			((Main_item_holder)holder).quote_text.setText(list.get(num).retweeted_status().text());
			((Main_item_holder)holder).quote_pics.setVisibility(View.GONE);
			new Pics_Download_Util(((Main_item_holder)holder).quote_pic, list.get(num).retweeted_status().bmiddle_pic(), 1);
			((Main_item_holder)holder).quote_pic.setLayerType(View.LAYER_TYPE_SOFTWARE, null);// close the hardwareAccelerated
			break;
		case 5:
			((Main_item_holder)holder).account_pics.setVisibility(View.GONE);
			((Main_item_holder)holder).account_pic.setVisibility(View.GONE);
			((Main_item_holder)holder).quote_name.setText(list.get(num).retweeted_status().user().name());
			((Main_item_holder)holder).quote_text.setText(list.get(num).retweeted_status().text());
			((Main_item_holder)holder).quote_pic.setVisibility(View.GONE);
			new Pics_Girdview_Util(list.get(num).retweeted_status().pic_urls(), ((Main_item_holder)holder).quote_pics);
			break;

		default:
			break;
		}
		
	}
	
	@Override
	public int getItemViewType(int position) {
		// TODO 自动生成的方法存根
		int type=6;//here is 6 types:
		Weibo w=list.get(position);
//		0:text
//		1:text and 1 pic
//		2:text and pics
//		3:text and quote with no pics
//		4:text and quote with 1 pic
//		5:text and quote with pics
		if(w.retweeted_status()==null&&w.pic_urls().isEmpty()) type=0;
		if(w.retweeted_status()==null&&w.pic_urls().size()==1) type=1;
		if(w.retweeted_status()==null&&w.pic_urls().size()>1) type=2;
		if(w.retweeted_status()!=null&&w.retweeted_status().pic_urls().size()==0) type=3;
		if(w.retweeted_status()!=null&&w.retweeted_status().pic_urls().size()==1) type=4;
		if(w.retweeted_status()!=null&&w.retweeted_status().pic_urls().size()>1) type=5;
		return type;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup view, int type) {
		// TODO 自动生成的方法存根
		View v=LayoutInflater.from(view.getContext()).inflate(R.layout.main_list_item, view, false);
		return new Main_item_holder(v);
	}
	public void refresh_item(List<Weibo> list){
//		this.list.clear();
		this.list=list;
	}
	public void load_more(List<Weibo> list){
		this.list.addAll(list);
	}
	

}
