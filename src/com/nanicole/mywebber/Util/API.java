package com.nanicole.mywebber.Util;

public class API {
	public static final String Account_get="https://api.weibo.com/2/users/show.json";//need access_token and uid,return type:user;
	public static final String Home_get="https://api.weibo.com/2/statuses/home_timeline.json";//need access_token,return type:weibo;
	public static final String Redirect_Uri="http://www.baidu.com";
	public static final String Access_Get="https://api.weibo.com/oauth2/authorize"
			+"?client_id="+APP_Screct.APP_Key
			+"&redirect_uri="+Redirect_Uri
			+"&response_type=code"
			+"&display=mobile"
			;
	public static final String Access_ReGet="https://api.weibo.com/oauth2/access_token"
			+"?client_id="+APP_Screct.APP_Key
			+"&client_secret="+APP_Screct.APP_Secret
			+"&grant_type="+"authorization_code"
			+"&redirect_uri="+Redirect_Uri
			+"&code=";
}
