package com.nanicole.mywebber.Adapter;

import com.nanicole.mywebber.HomeActivity;
import com.nanicole.mywebber.R;
import com.nanicole.mywebber.Myclass.User;
import com.nanicole.mywebber.Util.BitmapUtil;
import com.nanicole.mywebber.Util.FileUtil;
import com.nanicole.mywebber.ViewHolder.Menu_item;
import com.nanicole.mywebber.ViewHolder.Menu_item_header;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Menu_list_adapter extends RecyclerView.Adapter<ViewHolder>{
	private User user;
	private Context con;

	public Menu_list_adapter(User myaccount, HomeActivity homeActivity) {
		// TODO 自动生成的构造函数存根
		this.user=myaccount;
		this.con=homeActivity;
	}

	@Override
	public int getItemCount() {
		// TODO 自动生成的方法存根
		return 7;
	}

	public void onBindViewHolder(ViewHolder view, int num) {
		// TODO 自动生成的方法存根
		switch (num) {
		case 0:
			Bitmap bmp=BitmapFactory.decodeFile(FileUtil.MyAvatarDir+FileUtil.filename_deal(user.avatar_large()));
			Log.e("avatar", FileUtil.MyAvatarDir+FileUtil.filename_deal(user.avatar_large()));
			bmp=BitmapUtil.RoundBitmap(bmp);
			Log.e("bmp", (bmp==null)?"null":"not");
			((Menu_item_header)view).avatar.setImageBitmap(bmp);
			((Menu_item_header)view).words.setText(user.description());
			((Menu_item_header)view).name.setText(user.name());
//			view.itemView.setBackgroundColor(Color.argb(0, 0, 0, 0));
			
			break;
		case 1:
			((Menu_item)view).item.setText("主页");
			break;
		case 2:
			((Menu_item)view).item.setText("写微博");
			break;
		case 3:
			((Menu_item)view).item.setText("朋友");
			break;
		case 4:
			((Menu_item)view).item.setText("设置");
			break;
		case 5:
			((Menu_item)view).item.setText("退出登录");
			break;
		case 6:
			((Menu_item)view).item.setText("关于");
			break;

		default:
			break;
		}
		
	}
	

	@Override
	public int getItemViewType(int position) {
		// TODO 自动生成的方法存根
		int type;
		if(position==0) type=0;
		else type=1;
		return type;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup view, int type) {
		// TODO 自动生成的方法存根
		View v=null;
		ViewHolder vh=null;
		if(type==0){
			v=LayoutInflater.from(view.getContext()).inflate(R.layout.menu_header, view, false);
			vh=new Menu_item_header(v);
		}
		else{
			v=LayoutInflater.from(view.getContext()).inflate(R.layout.menu_item, view, false);
			vh=new Menu_item(v);
		}
		return vh;
	}

}
