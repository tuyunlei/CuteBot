package com.xclz.lhz.cutebot;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xclz.lhz.cutebot.animation.AnimationPlayer;
import com.xclz.lhz.cutebot.scheduled.TaskSchedule;
import android.view.View;

public class MainService extends Service {

	private FloatWindow mWindow;
	private FloatBot mBot;
	private TaskSchedule mSchedule;

	private AnimationPlayer mAnimPlayer;

	private View mView;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mWindow = new FloatWindow(this);
		mBot = new FloatBot(this, mWindow);
		mSchedule = new TaskSchedule(mBot);
		mAnimPlayer = new AnimationPlayer(mBot);
		mView = mBot.getView();
		mWindow.setView(mView);
		mWindow.create();
		mAnimPlayer.start();
		mSchedule.start();
	}
	

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	
}
