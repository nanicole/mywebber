package com.nanicole.mywebber.Myclass;

import java.util.List;

public class Weibo {
	private String created_at;
	public void created_at(String s){
		this.created_at=s;
	}
	public String created_at(){
		return created_at;
	}
	
//	private long id;
//	public void id(long s){
//		this.id=s;
//	}
//	public long id(){
//		return id;
//	}
	private String mid;
	public void mid(String s){
		this.mid=s;
	}
	public String mid(){
		return mid;
	}
	private String idstr;
	public void idstr(String s){
		this.idstr=s;
	}
	public String idstr(){
		return idstr;
	}
	private String text;
	public void text(String s){
		this.text=s;
	}
	public String text(){
		return text;
	}
	private int source_allowclick;
	public void source_allowclick(int s){
		this.source_allowclick=s;
	}
	public int source_allowclick(){
		return source_allowclick;
	}
	private int source_type;
	public void source_type(int s){
		this.source_type=s;
	}
	public int source_type(){
		return source_type;
	}
	private String source;
	public void source(String s){
		this.source=s;
	}
	public String source(){
		return source;
	}
	private boolean favorited;
	public void favorited(boolean s){
		this.favorited=s;
	}
	public boolean favorited(){
		return favorited;
	}
	private boolean truncated;
	public void truncated(boolean s){
		this.truncated=s;
	}
	public boolean truncated(){
		return truncated;
	}
	private String in_reply_to_status_id;
	public void in_reply_to_status_id(String s){
		this.in_reply_to_status_id=s;
	}
	public String in_reply_to_status_id(){
		return in_reply_to_status_id;
	}
	private String in_reply_to_user_id;
	public void in_reply_to_user_id(String s){
		this.in_reply_to_user_id=s;
	}
	public String in_reply_to_user_id(){
		return in_reply_to_user_id;
	}
	private String in_reply_to_screen_name;
	public void in_reply_to_screen_name(String s){
		this.in_reply_to_screen_name=s;
	}
	public String in_reply_to_screen_name(){
		return in_reply_to_screen_name;
	}
	private List<Pic_urls> pic_urls;
	public void pic_urls(List<Pic_urls> s){
		this.pic_urls=s;
	}
	public List<Pic_urls> pic_urls(){
		return pic_urls;
	}
	private String thumbnail_pic;
	public void thumbnail_pic(String s){
		this.thumbnail_pic=s;
	}
	public String thumbnail_pic(){
		return thumbnail_pic;
	}
	
	private String bmiddle_pic;
	public void bmiddle_pic(String s){
		this.bmiddle_pic=s;
	}
	public String bmiddle_pic(){
		return bmiddle_pic;
	}
	private String original_pic;
	public void original_pic(String s){
		this.original_pic=s;
	}
	public String original_pic(){
		return original_pic;
	}
//	private String geo;//unknow;
//	public void geo(String s){
//		this.geo=s;
//	}
//	public String geo(){
//		return geo;
//	}
	private User user;
	public void user(User s){
		this.user=s;
	}
	public User user(){
		return user;
	}
	
//	private int pid;
//	public void pid(int s){
//		this.pid=s;
//	}
//	public int pid(){
//		return pid;
//	}
	private Weibo retweeted_status;
	public void retweeted_status(Weibo s){
		this.retweeted_status=s;
	}
	public Weibo retweeted_status(){
		return retweeted_status;
	}
//	private Annotations annotations;
//	public void annotations(Annotations s){
//		this.annotations=s;
//	}
//	public Annotations annotations(){
//		return annotations;
//	}
	private String filterID;
	public void filterID(String s){
		this.filterID=s;
	}
	public String filterID(){
		return filterID;
	}
	
	private int reposts_count;
	public void reposts_count(int s){
		this.reposts_count=s;
	}
	public int reposts_count(){
		return reposts_count;
	}
	private int comments_count;
	public void comments_count(int s){
		this.comments_count=s;
	}
	public int comments_count(){
		return comments_count;
	}
	private int attitudes_count;
	public void attitudes_count(int s){
		this.attitudes_count=s;
	}
	public int attitudes_count(){
		return attitudes_count;
	}
	private int mlevel;
	public void mlevel(int s){
		this.mlevel=s;
	}
	public int mlevel(){
		return mlevel;
	}
	private Visible visible;
	public void visible(Visible s){
		this.visible=s;
	}
	public Visible visible(){
		return visible;
	}
	
//	private List<String> darwin_tags;
//	public void darwin_tags(List<String> s){
//		this.darwin_tags=s;
//	}
//	public List<String> darwin_tags(){
//		return darwin_tags;
//	}
//	private String rid;
//	public void rid(String s){
//		this.rid=s;
//	}
//	public String rid(){
//		return rid;
//	}
	

}
