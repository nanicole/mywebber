package com.nanicole.mywebber.ViewHolder;

import com.nanicole.mywebber.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu_item_header extends RecyclerView.ViewHolder{
	public ImageView avatar;
	public TextView words;
	public TextView name;
	

	public Menu_item_header(View itemView) {
		super(itemView);
		// TODO 自动生成的构造函数存根
		avatar=(ImageView) itemView.findViewById(R.id.self_avatar);
		words=(TextView) itemView.findViewById(R.id.self_words);
		name=(TextView) itemView.findViewById(R.id.self_name);
	}

}
