package com.nanicole.mywebber.ViewHolder;

import com.nanicole.mywebber.R;
import com.nanicole.mywebber.Util.MyGridView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main_item_holder extends RecyclerView.ViewHolder{
	public LinearLayout account,users,quote;
	public ImageView users_avatar,account_pic,quote_pic;
	public TextView users_name,account_text,quote_name,quote_text,stair_num;
	public MyGridView account_pics,quote_pics;

	public Main_item_holder(View itemView) {
		super(itemView);
		// TODO 自动生成的构造函数存根
		account=(LinearLayout) itemView.findViewById(R.id.account);
		users=(LinearLayout) itemView.findViewById(R.id.users);
		quote=(LinearLayout) itemView.findViewById(R.id.quote);
		users_avatar=(ImageView) itemView.findViewById(R.id.user_avatar);
		account_pic=(ImageView) itemView.findViewById(R.id.account_pic);
		quote_pic=(ImageView) itemView.findViewById(R.id.quote_pic);
		users_name=(TextView) itemView.findViewById(R.id.users_name);
		account_text=(TextView) itemView.findViewById(R.id.account_text);
		quote_name=(TextView) itemView.findViewById(R.id.quote_name);
		quote_text=(TextView) itemView.findViewById(R.id.quote_text);
		stair_num=(TextView) itemView.findViewById(R.id.user_stair_num);
		account_pics=(MyGridView) itemView.findViewById(R.id.account_pics);
		quote_pics=(MyGridView) itemView.findViewById(R.id.quote_pics);
		
	}

}
