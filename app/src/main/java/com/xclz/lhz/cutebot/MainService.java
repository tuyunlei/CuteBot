package com.xclz.lhz.cutebot;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MainService extends Service {
	private BotController botController;

	@Override
	public void onCreate() {
		super.onCreate();
		
		botController = new BotController(this);
		botController.create();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		botController.remove();
		super.onDestroy();
	}

	
}
