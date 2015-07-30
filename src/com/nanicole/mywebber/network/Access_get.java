package com.nanicole.mywebber.network;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nanicole.mywebber.HomeActivity;
import com.nanicole.mywebber.MyInterface.Access_get_interface;
import com.nanicole.mywebber.Myclass.Access_class;

public class Access_get extends AsyncTask<String, Process, Access_class>{
	private Access_get_interface ii;

	@Override
	protected Access_class doInBackground(String... params) {
		// TODO 自动生成的方法存根
		Access_class ac=new Access_class();
		String access=null;
		String url=params[0];
		HttpParams hp=new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(hp, 3000);
		HttpConnectionParams.setSoTimeout(hp, 3000);
		HttpClient hc=new DefaultHttpClient(hp);
		HttpPost htp=new HttpPost(url);
		try {
			HttpResponse hr=hc.execute(htp);
			if(hr.getStatusLine().getStatusCode()==200){
				access=EntityUtils.toString(hr.getEntity());
			}
			else access=null;
			Log.e("code", hr.getStatusLine().getStatusCode()+"");
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		ac=new Gson().fromJson(access, Access_class.class);
		
		return ac;
	}

	@Override
	protected void onPostExecute(Access_class result) {
		// TODO 自动生成的方法存根
		super.onPostExecute(result);
		ii.Access_get_deal(result);
	}
	public void set_interface(Access_get_interface ii){
		this.ii=ii;
	}
	

}
