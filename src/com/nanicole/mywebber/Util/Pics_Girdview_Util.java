package com.nanicole.mywebber.Util;

import java.util.ArrayList;
import java.util.List;

import android.widget.GridView;

import com.nanicole.mywebber.Adapter.Pics_GridView_adapter;
import com.nanicole.mywebber.Myclass.Pic_urls;

public class Pics_Girdview_Util {
	private List<Pic_urls> list_pics;
	private MyGridView gv;
	public Pics_Girdview_Util(List<Pic_urls> list_pics, MyGridView gv) {
		super();
		this.list_pics = list_pics;
		this.gv = gv;
		List<String > list_url=Url_list_get(list_pics);
		Pics_GridView_adapter pa=new Pics_GridView_adapter(list_url);
		gv.setAdapter(pa);
		
	}
	public List<String > Url_list_get(List<Pic_urls> list_p){
		List<String> list_s=new ArrayList<String>();
		for (int i = 0; i < list_p.size(); i++) {
			String url=list_p.get(i).thumbnail_pic();
			list_s.add(url);
		}
		return list_s;
		
	}
	

}
