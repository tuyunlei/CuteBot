package com.xclz.lhz.cutebot;

import android.content.Context;
import com.xclz.lhz.cutebot.animation.AnimationPlayer;

public class FloatBot {

	private Context mContext;
	private FloatWindow mWindow;
	private FloatBotView mView;
	private AnimationPlayer mPlayer;
	
	public FloatBot(Context context) {
		mContext = context;
	}
	
	public void create() {
		mView = new FloatBotView(mContext);
		mPlayer = new AnimationPlayer(mView);
		mWindow = new FloatWindow(mContext, mView);
		mWindow.present();
		
		mPlayer.start();
	}
	
	
}
