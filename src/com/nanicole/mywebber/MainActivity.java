package com.nanicole.mywebber;

import java.io.File;

import com.nanicole.mywebber.MyInterface.Account_get_interface;
import com.nanicole.mywebber.MyInterface.Pic_Download_interface;
import com.nanicole.mywebber.Myclass.User;
import com.nanicole.mywebber.Myclass.UserParceable;
import com.nanicole.mywebber.Myclass.UserSerializable;
import com.nanicole.mywebber.Util.API;
import com.nanicole.mywebber.Util.APP_Screct;
import com.nanicole.mywebber.Util.FileUtil;
import com.nanicole.mywebber.network.Account_get;
import com.nanicole.mywebber.network.Pic_Download;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author nanicole
 * in this activity what will be did:
 * Create file folders for pics(in sdcard,if has none,in data/data),include avatar and pics two file folders.
 * check the internet(not yet)
 * check the Access_token,if has one,try get user's information,if fail or has none,goto Access_Token_Activity
 * sleep for 1 second
 *
 */
public class MainActivity extends ActionBarActivity implements Account_get_interface{
	
	private MyHandler handler;
	private DelayThread t;
	private User myAccount;
	private Handler thandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handler=new MyHandler();
		t=new DelayThread();
		t.start();
		SetHomeDir();
		Log.e("home", FileUtil.HomeDir);
		SetAvatarPath();
		Log.e("avatar", FileUtil.MyAvatarDir);
		SetPicsPath();
		Log.e("pic", FileUtil.MyPicDir);
		if(!Check_Access_Token()){
			thandler.sendEmptyMessage(0);
		}
		else
		{
			Account_get task=new Account_get();
			task.setInterface(this);
			task.execute(API.Account_get+"?access_token="+APP_Screct.Access_token
			+"&uid="+APP_Screct.Uid);
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO 自动生成的方法存根
			super.handleMessage(msg);
			switch (msg.what) {
			case 0://has no access_token,need to goto Access_token_activity 
				Intent i=new Intent(MainActivity.this,Access_Toke_Activity.class);
				startActivity(i);
				finish();
				break;

			default:
				break;
			}
		}
		
		
	}
//	check the SDcaed
	public String SDdirPath(){
		File SDdir=null;
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			SDdir=Environment.getExternalStorageDirectory();
		}
		Log.e("sddir", SDdir.toString());
		return SDdir.toString();
	}
//	setHome file folder path
	public void SetHomeDir(){
		FileUtil.SDdir=SDdirPath();
		if(FileUtil.SDdir==null){
			FileUtil.HomeDir=FileUtil.MyPhoneDir;
		}
		else{
			FileUtil.HomeDir=FileUtil.SDdir+"/com.nanicole.mywebber";
		}
		FileUtil.MyAvatarDir=FileUtil.HomeDir+"/Avatar/";
		FileUtil.MyPicDir=FileUtil.HomeDir+"/Pics/";
	}
//	setAvatarpath
	public void SetAvatarPath(){
		File avatar=new File(FileUtil.MyAvatarDir);
		if(!avatar.exists())
			avatar.mkdirs();
		
	}
//	setPicsPath
	public void SetPicsPath(){
		File Pics=new File(FileUtil.MyPicDir);
		if(!Pics.exists())
			Pics.mkdirs();
	}
//	check the Access Token
	public boolean Check_Access_Token(){
		SharedPreferences sp=getSharedPreferences("My_data", 0);
		
		String s=sp.getString("Access_token", null);
		String uid=sp.getString("uid", null);
		if(s!=null&&uid!=null){
			APP_Screct.Access_token=s;
			APP_Screct.Uid=uid;
			return true;
		}
		else{
//			Intent i=new Intent(MainActivity.this,Access_Toke_Activity.class);
//			startActivity(i);
			return false;
		}
		
		
	}
//	DelayThread
	class DelayThread extends Thread{
		private boolean prepare;

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			super.run();
			Looper.prepare();
			
			thandler=new Handler(){

				@Override
				public void handleMessage(Message msg) {
					// TODO 自动生成的方法存根
					super.handleMessage(msg);
					switch (msg.what) {
					case 0:
						handler.sendEmptyMessageDelayed(0, 2000);
						break;
					case 1:
						handler.sendEmptyMessage(1);
						break;

					default:
						break;
					}
				}
				
			};
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			Looper.loop();
			
			
		}
		
	}
	//interface for user
	@Override
	public void account_get_deal(User u) {//改进：从用户体验上来讲，应该在此处把微博一起获取，不过现在还没有什么好方法
		// TODO 自动生成的方法存根
		myAccount=u;
		if(myAccount==null){
			Toast.makeText(MainActivity.this, "无法得到个人信息，请尝试登录", Toast.LENGTH_SHORT).show();
			thandler.sendEmptyMessage(0);
			return;
		}
		thandler.sendEmptyMessage(1);
		String url=myAccount.avatar_large();
		String path=FileUtil.filename_deal(url);
		Bitmap bmp=BitmapFactory.decodeFile(FileUtil.MyAvatarDir+path);
		if(bmp==null){
			Pic_Download_interface ii=new Pic_Download_interface() {
				
				@Override
				public void pic_download_deal(Bitmap bmp) {
					// TODO 自动生成的方法存根
					send_intent();
				}
			};
			Pic_Download task=new Pic_Download(0,ii);
			task.execute(url);
		}
		else send_intent();
		
		
		
	}
	public void send_intent(){
//		UserSerializable us=new UserSerializable(myAccount);
		UserParceable up=new UserParceable(myAccount);		
		Intent i=new Intent(MainActivity.this,HomeActivity.class);
//		i.putExtra("myaccent", us);
		i.putExtra("myaccent", up);
		startActivity(i);
		finish();
	}
	
}

