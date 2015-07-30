package com.nanicole.mywebber.ViewHolder;

import com.nanicole.mywebber.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Menu_item extends RecyclerView.ViewHolder{
	public TextView item;

	public Menu_item(View itemView) {
		super(itemView);
		// TODO 自动生成的构造函数存根
		item=(TextView) itemView.findViewById(R.id.menu_item);
	}

}
