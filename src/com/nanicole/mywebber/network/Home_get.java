package com.nanicole.mywebber.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.nanicole.mywebber.MyInterface.Home_get_interface;
import com.nanicole.mywebber.Myclass.Weibo;

public class Home_get extends AsyncTask<String, Process, List<Weibo>>{
	private Home_get_interface ii;

	@Override
	protected List<Weibo> doInBackground(String... params) {
		// TODO 自动生成的方法存根
		
		String u=params[0];
		String enitity=null;
		List<Weibo> list=new ArrayList<Weibo>();
		HttpParams hp=new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(hp, 3000);
		HttpConnectionParams.setSoTimeout(hp, 3000);
		HttpClient hc=new DefaultHttpClient(hp);
		HttpGet hg=new HttpGet(u);
		try {
			HttpResponse hr=hc.execute(hg);
			if(hr.getStatusLine().getStatusCode()==200){
				enitity=EntityUtils.toString(hr.getEntity());
			}
			else enitity=null;
			
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(enitity==null) return null;
		try {
			JSONObject jo=new JSONObject(enitity);
			JSONArray ja=jo.getJSONArray("statuses");
			for (int i = 0; i < ja.length(); i++) {
				Gson g=new Gson();
				Weibo w=g.fromJson(ja.get(i).toString(), Weibo.class);
				list.add(w);
				
			}
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	protected void onPostExecute(List<Weibo> result) {
		// TODO 自动生成的方法存根
		super.onPostExecute(result);
		ii.Home_get_deal(result);
		
	}
	public void set_interface(Home_get_interface ii){
		this.ii=ii;
	}
	

}
