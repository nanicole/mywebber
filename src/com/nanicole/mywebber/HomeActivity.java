package com.nanicole.mywebber;

import com.nanicole.mywebber.Adapter.Menu_list_adapter;
import com.nanicole.mywebber.Fragment.Main_Fragment;
import com.nanicole.mywebber.Myclass.User;
import com.nanicole.mywebber.Myclass.UserParceable;
import com.nanicole.mywebber.Myclass.UserSerializable;
import com.nanicole.mywebber.Util.Line_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;


/**
 * @author nanicole
 * what will be done here:
 * the home activity ,including toolbar,drawer,main list,maybe will add other button
 *
 */
public class HomeActivity extends ActionBarActivity{
	private Toolbar toolbar;
	private Main_Fragment main_frag;
	private DrawerLayout drawer;
	private RecyclerView menu_list;
	private User myaccount;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		Intent i=getIntent();
//		myaccount=((UserSerializable)i.getSerializableExtra("myaccount")).get_user();
		myaccount=((UserParceable)i.getParcelableExtra("myaccent")).User();
		Init_toolbar();
		Init_drawer();
		Init_menu_list(myaccount);
		Init_main_frag();
		
		
		
	}
	public void Init_toolbar(){
		toolbar=(Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("我的微博");
		setSupportActionBar(toolbar);
		toolbar.setLogo(R.drawable.weibo_64x64);
		
	}
	public void Init_drawer(){
		drawer=(DrawerLayout) findViewById(R.id.drawer);
		ActionBarDrawerToggle ad=new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_closed);
		ad.syncState();
		drawer.setDrawerListener(ad);
	}
	public void Init_main_frag(){
		main_frag=new Main_Fragment();
		FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
		ft.add(R.id.mian_frag, main_frag, "home");
		ft.commit();
		
	}
	public void Init_menu_list(User myaccount){
		menu_list=(RecyclerView) findViewById(R.id.menu_list);
		Menu_list_adapter ma=new Menu_list_adapter(myaccount,HomeActivity.this);
		menu_list.setAdapter(ma);
		menu_list.setLayoutManager(new LinearLayoutManager(this));
		menu_list.addItemDecoration(new Line_menu(this));
	}
	

}
