package com.xclz.lhz.cutebot;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class FloatWindow {
	public final static int NORMAL_WIDTH = 100;
	public final static int NORMAL_HEIGHT = 100;

	private View mView;
	private Context mContext;
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams mParams;
	

	public FloatWindow(Context context, View view) {
		mView = view;
		mContext = context;
	}
	
	public WindowManager.LayoutParams getParam() {
		if(mParams == null) {
			mParams = new WindowManager.LayoutParams();
			mParams.type = mParams.TYPE_SYSTEM_ALERT;
			mParams.flags = mParams.FLAG_NOT_FOCUSABLE | mParams.FLAG_SHOW_WHEN_LOCKED;
			mParams.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
			mParams.width = NORMAL_WIDTH;
			mParams.height = NORMAL_HEIGHT;
			mParams.format = PixelFormat.RGBA_8888;
		}
		return mParams;
	}
	
	public void present() {
		this.present(getParam());
	}
	
	public void present(WindowManager.LayoutParams param) {
		mParams = param;
		mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		mWindowManager.addView(mView, param);
	}
	
	public void close() {
		mWindowManager.removeView(mView);
	}
}
