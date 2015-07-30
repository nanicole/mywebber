package com.nanicole.mywebber.network;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.nanicole.mywebber.MyInterface.Account_get_interface;
import com.nanicole.mywebber.Myclass.User;

public class Account_get extends AsyncTask<String, Process, User>{
	private Account_get_interface ii;

	

	@Override
	protected void onPostExecute(User result) {
		// TODO 自动生成的方法存根
		super.onPostExecute(result);
		ii.account_get_deal(result);
	}

	@Override
	protected User doInBackground(String... params) {
		// TODO 自动生成的方法存根
		JSONObject j=new JSONObject();
		User u=new User();
		String url=params[0];
		HttpParams hp=new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(hp, 3000);
		HttpConnectionParams.setSoTimeout(hp, 3000);
		HttpClient hc=new DefaultHttpClient(hp);
		HttpGet hg=new HttpGet(url);
		try {
			HttpResponse hr=hc.execute(hg);
			switch (hr.getStatusLine().getStatusCode()) {
			case 200:
				j=new JSONObject(EntityUtils.toString(hr.getEntity()));
				break;

			default:
				j=null;
				break;
			}
			
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			if(j==null) u=null;
			else
				u=new Gson().fromJson(j.toString(), User.class);
			
		}
		
		return u;
	}
	public void setInterface(Account_get_interface ii){
		this.ii=ii;
	}
	

}
