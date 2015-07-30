package com.nanicole.mywebber.Myclass;

import android.os.Parcel;
import android.os.Parcelable;

public class UserParceable implements Parcelable{
	private User user;


	public User User() {
		return user;
	}

	public void User(User user) {
		this.user = user;
	}

	public UserParceable(User user) {
		super();
		this.user = user;
	}

	@Override
	public int describeContents() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO 自动生成的方法存根
		dest.writeString(user.avatar_large());
		dest.writeString(user.name());
		dest.writeString(user.description());

	}
	private UserParceable(Parcel in) {
		user=new User();
		user.avatar_large(in.readString());
		user.name(in.readString());
		user.description(in.readString());


	}
	public static final Parcelable.Creator<UserParceable> CREATOR
	= new Parcelable.Creator<UserParceable>() {
		public UserParceable createFromParcel(Parcel in) {
			return new UserParceable(in);
		}

		public UserParceable[] newArray(int size) {
			return new UserParceable[size];
		}
	};





}
