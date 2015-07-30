package com.nanicole.mywebber.Util;

/**
 * @author nanicole
 * all the files path
 *
 */
public class FileUtil {
	
	public static String SDdir; 
	public static String MySDHomeDir;
	public static final String MyPhoneDir="data/data/com.nanicole.mywebber";
	public static String HomeDir;
	public static String MyAvatarDir;
	public static String MyPicDir;
	
	public static String filename_deal(String s){
		String ns=s.replaceAll( "http://","");
		ns=ns.replaceAll("/", "_");
		if(!ns.endsWith(".jpg")){
			ns=ns+".jpg";
		}
		return ns;
		
	}
}
