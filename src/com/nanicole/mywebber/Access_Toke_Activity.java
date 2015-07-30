package com.nanicole.mywebber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.nanicole.mywebber.MyInterface.Access_get_interface;
import com.nanicole.mywebber.Myclass.Access_class;
import com.nanicole.mywebber.Util.API;
import com.nanicole.mywebber.Util.APP_Screct;
import com.nanicole.mywebber.network.Access_get;


/**
 * @author nanicole
 * what will be done in this activity:
 * if users got no access_token or doesn't log in,go to here
 * if got no access_token,try to contect to sina,then re_get the access_token
 * if doesn't log in ,do the same thing.
 * at last ,to write in,access_token and uid
 *
 */
public class Access_Toke_Activity extends ActionBarActivity implements Access_get_interface{
	private WebView web;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.access_token_activity);
		web=(WebView) findViewById(R.id.Access_webView);
		web.getSettings().setJavaScriptEnabled(true);
		web.setFocusable(true);
		web.loadUrl(API.Access_Get);
		web.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO 自动生成的方法存根
				web.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO 自动生成的方法存根
				super.onPageStarted(view, url, favicon);
				if(url.startsWith(API.Redirect_Uri)){
					view.stopLoading();
					view.cancelLongPress();
					Uri uri=Uri.parse(url);
					String code=uri.getQueryParameter("code");
					if(code!=null){
						Access_get task=new Access_get();
						task.set_interface(Access_Toke_Activity.this);
						task.execute(API.Access_ReGet+code);
					}
					else
						Toast.makeText(Access_Toke_Activity.this, "Access_get_fail", Toast.LENGTH_SHORT).show();
				}
				
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO 自动生成的方法存根
				super.onPageFinished(view, url);
			}
			
		});
		
	}

	@Override
	public void Access_get_deal(Access_class ac) {
		// TODO 自动生成的方法存根
		if(ac==null) return;
		SharedPreferences sp=getSharedPreferences("My_data", 0);
		Editor ed=sp.edit();
		ed.putString("Access_token", ac.access_token());
		ed.putString("uid", ac.uid());
		ed.commit();
		APP_Screct.Access_token=ac.access_token();
		APP_Screct.Uid=ac.uid();
		Intent i=new Intent(this,HomeActivity.class);
		startActivity(i);
		finish();
		
	}
	

}
