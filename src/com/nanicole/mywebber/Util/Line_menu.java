package com.nanicole.mywebber.Util;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

import com.nanicole.mywebber.HomeActivity;
import com.nanicole.mywebber.R;

public class Line_menu extends RecyclerView.ItemDecoration{
	private Drawable line;

	public Line_menu(HomeActivity homeActivity) {
		// TODO 自动生成的构造函数存根
		line=homeActivity.getResources().getDrawable(R.drawable.menu_list_line);
	}

	@Override
	public void onDrawOver(Canvas c, RecyclerView parent, State state) {
		// TODO 自动生成的方法存根
		int left=parent.getPaddingLeft();
		int right=parent.getWidth()-parent.getPaddingRight();
		for (int i = 0; i < parent.getChildCount(); i++) {
			View v=parent.getChildAt(i);
			RecyclerView.LayoutParams pa=(LayoutParams) v.getLayoutParams();
			int top=v.getBottom()+pa.bottomMargin;
			int bottom=top+line.getIntrinsicHeight();
			line.setBounds(left, top, right, bottom);
			line.draw(c);
			
		}
		
		super.onDrawOver(c, parent, state);
	}
	

}
