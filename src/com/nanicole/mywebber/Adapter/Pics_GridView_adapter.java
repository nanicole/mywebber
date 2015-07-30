package com.nanicole.mywebber.Adapter;

import java.util.List;

import com.nanicole.mywebber.R;
import com.nanicole.mywebber.MyInterface.Pic_Download_interface;
import com.nanicole.mywebber.Util.Pics_Download_Util;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;

public class Pics_GridView_adapter extends BaseAdapter{
	private List<String> url;

	public Pics_GridView_adapter(List<String> url) {
		super();
		this.url = url;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return url.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_pics_item, parent, false);
		ImageView iv=(ImageView) v.findViewById(R.id.pics_item);
//		android.view.ViewGroup.LayoutParams lp=v.getLayoutParams();
//		int width=v.getLayoutParams().width;
//		lp.height=width;
//		v.setLayoutParams(lp);
		new Pics_Download_Util(iv, url.get(position), 2);
		return v;
	}


}
