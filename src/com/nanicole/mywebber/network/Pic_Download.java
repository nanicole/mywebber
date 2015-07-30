package com.nanicole.mywebber.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.nanicole.mywebber.MyInterface.Pic_Download_interface;
import com.nanicole.mywebber.Util.BitmapUtil;
import com.nanicole.mywebber.Util.FileUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class Pic_Download extends AsyncTask<String , Process, Bitmap>{
	private int type;//0 is avatar download ,1 is normal pic download
	private Pic_Download_interface ii;

	public Pic_Download(int type, Pic_Download_interface ii2) {
		super();
		this.type = type;
		this.ii=ii2;
	}

	
	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO 自动生成的方法存根
		super.onPostExecute(result);
		ii.pic_download_deal(result);
	}


	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO 自动生成的方法存根
		String url=params[0];
		Bitmap bmp=null;
		URL u;
		try {
			u=new URL(url);
			URLConnection con=u.openConnection();
			con.connect();
			InputStream is=con.getInputStream();
			bmp=BitmapFactory.decodeStream(is);
			is.close();
			
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(bmp==null) return null;
		String name=FileUtil.filename_deal(url);
		File f=null;
		switch (type) {
		case 0://avatar
			f=new File(FileUtil.MyAvatarDir+name);
			Log.e("path", FileUtil.MyAvatarDir+name);
			
			break;
		case 1://pics
			f=new File(FileUtil.MyPicDir+name);
			break;
		case 2:
			f=new File(FileUtil.MyPicDir+name);
		default:
			break;
		}
		try {
			f.createNewFile();
			FileOutputStream fos=new FileOutputStream(f);
			bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return bmp;
	}
	public void  set_interface(Pic_Download_interface ii){
		this.ii=ii;
	}



}
