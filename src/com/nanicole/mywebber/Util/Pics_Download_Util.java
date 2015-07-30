package com.nanicole.mywebber.Util;

import com.nanicole.mywebber.MyInterface.Pic_Download_interface;
import com.nanicole.mywebber.network.Pic_Download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

public class Pics_Download_Util implements Pic_Download_interface{
	private ImageView iv;
	private int type;
	public Pics_Download_Util(ImageView iv, String url,int type) {
		super();
		this.iv=iv;
		this.type=type;
		String path=null;
		if(type==0)//avatar
			path=FileUtil.MyAvatarDir+FileUtil.filename_deal(url);
		if(type>=1)
			path=FileUtil.MyPicDir+FileUtil.filename_deal(url);
		Bitmap bmp=BitmapFactory.decodeFile(path);
		if(bmp!=null) {
			if(type==0) bmp=BitmapUtil.RoundBitmap(bmp);//avatar pics
			if(type==2) bmp=BitmapUtil.SquareBitmap(bmp);//square pics
			iv.setImageBitmap(bmp);
		}
		else{
			Pic_Download task=new Pic_Download(type, null);
			task.set_interface(this);
			task.execute(url);
			
		}
	}
	
	@Override
	public void pic_download_deal(Bitmap bmp) {
		// TODO 自动生成的方法存根
		bmp=BitmapUtil.Check_Bitmap(bmp);
		if(type==0) bmp=BitmapUtil.RoundBitmap(bmp);
		if(type==2) bmp=BitmapUtil.SquareBitmap(bmp);
		iv.setImageBitmap(bmp);
	}
	

}
