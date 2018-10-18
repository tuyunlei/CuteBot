package com.xclz.lhz.cutebot;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class BotController {
	private BotView botView;
	private BotModel botModel;
	private WindowManager mWindowManager;

	private Service mService;

	private WindowManager.LayoutParams mViewParams;
	
	public BotController(Service service) {
		mService = service;
	}
	
	public void create() {
		botModel = new BotModel(mService);
		Bitmap bitmap = botModel.getBitmap(BotAction.ACTIONID_ORIGIN);
		botView = new BotView(mService, bitmap);
		
		mWindowManager = (WindowManager) mService.getSystemService(Context.WINDOW_SERVICE);
		mViewParams = new WindowManager.LayoutParams();
		
		mViewParams.type = mViewParams.TYPE_SYSTEM_ALERT;
		mViewParams.flags = mViewParams.FLAG_NOT_FOCUSABLE;
		
		mViewParams.x = 0;
		mViewParams.y = 0;
		mViewParams.width = bitmap.getWidth();
		mViewParams.height = bitmap.getHeight();
		
		mWindowManager.addView(botView, mViewParams);
	}
	
	public void remove() {
		mWindowManager.removeView(botView);
	}
}
