package com.xclz.lhz.cutebot;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

public class FloatWindow {
	public final static int NORMAL_WIDTH = 100;
	public final static int NORMAL_HEIGHT = 100;

	private View mView;
	private Context mContext;
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams mParams;
	

	public FloatWindow(Context context) {
		mContext = context;
	}
	
	public void create() {
		//TODO
	}
	
	public void setView(View view) {
		setView(view, mParams);
	}
	
	public void setView(View view, WindowManager.LayoutParams params) {
		if(mView != null)
			mWindowManager.removeView(mView);
		mWindowManager.addView(view, params);
		mView = view;
	}
	
	public void setX(float x) {
		mParams.x = (int) x;
	}
	
	public void setY(float y) {
		mParams.y = (int) y;
	}
	
	public float getX() {
		return mParams.x;
	}
	
	public float getY() {
		return mParams.y;
	}
	
	public void updateLayout() {
		mWindowManager.updateViewLayout(mView, mParams);
	}
	
/*	
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
	*/
}
