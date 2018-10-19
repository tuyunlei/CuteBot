package com.xclz.lhz.cutebot;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.text.Format;
import android.graphics.PixelFormat;
import android.view.Gravity;

public class BotController {
	private BotView botView;
	private BotModel botModel;
	private WindowManager mWindowManager;

	private Service mService;

	private WindowManager.LayoutParams mViewParams;
	
	public BotController(Service service) {
		mService = service;
		mWindowManager = (WindowManager) mService.getSystemService(Context.WINDOW_SERVICE);
	}
	
	public void create() {
		botModel = new BotModel(mService);
		Bitmap bitmap = botModel.getBitmap(BotAction.ACTIONID_ORIGIN);
		botView = new BotView(mService, bitmap);
		
		mViewParams = new WindowManager.LayoutParams();
		
		mViewParams.type = mViewParams.TYPE_SYSTEM_ALERT;
		mViewParams.format = PixelFormat.RGBA_8888;
		mViewParams.flags = mViewParams.FLAG_NOT_FOCUSABLE;
		
		mViewParams.gravity = Gravity.LEFT;
		mViewParams.x = 0;
		mViewParams.y = 0;
		mViewParams.width = bitmap.getWidth();
		mViewParams.height = bitmap.getHeight();
		
		mWindowManager.addView(botView, mViewParams);
		
	}
	
	public void remove() {
		if(botView != null) {
			mWindowManager.removeView(botView);
		}
	}
}
