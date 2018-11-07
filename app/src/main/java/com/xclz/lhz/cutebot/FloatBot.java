package com.xclz.lhz.cutebot;

import android.content.Context;
import android.view.View;
import com.xclz.lhz.cutebot.animation.AnimationPlayer;

public class FloatBot {

	private Context mContext;
	private FloatWindow mWindow;
	private FloatBotView mView;
	private AnimationPlayer mPlayer;
	
	public FloatBot(Context context, FloatWindow window) {
		mContext = context;
		mWindow = window;
		
		mView = new FloatBotView(context);
	}
	
	public int getX() {
		//TODO
		return 0;
	}
	
	public int getY() {
		//TODO
		return 0;
	}
	
	public void setX() {
		//TODO
	}
	
	public void setY() {
		//TODO
	}
	
	public View getView() {
		return mView;
	}
	
}
