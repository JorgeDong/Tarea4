package com.iteso.calis.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String password;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;}

    public boolean isLogged() {
        return isLogged;
    }
    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user);
        dest.writeString(this.password);
        dest.writeByte(this.isLogged ? (byte) 1 : (byte) 0);
    }

    protected User(Parcel in){
        this.user = in.readString();
        this.password = in.readString();
        this.isLogged = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
