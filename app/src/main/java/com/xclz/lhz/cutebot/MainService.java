package com.xclz.lhz.cutebot;
import android.view.*;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.xclz.lhz.cutebot.MainService;

public class MainService extends Service {
	//要引用的布局文件.
    LinearLayout toucherLayout;
    //布局参数.
    WindowManager.LayoutParams mParams;
    //实例化的WindowManager.
    WindowManager mWindowManager;

	View mCanvas;

	@Override
	public void onCreate() {
		super.onCreate();
		createToucher();
	}

	private void createToucher() {
		mParams = new WindowManager.LayoutParams();
		mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		mParams.type = mParams.TYPE_SYSTEM_ALERT;
		mParams.format = PixelFormat.RGBA_8888;
		mParams.flags = mParams.FLAG_NOT_FOCUSABLE | mParams.FLAG_WATCH_OUTSIDE_TOUCH;

		mParams.gravity = Gravity.LEFT|Gravity.CENTER_VERTICAL;
		mParams.x = 100;
		mParams.y = 300;
		mParams.width = 200;
		mParams.width = 200;

		LayoutInflater inflater = LayoutInflater.from(getApplication());
		toucherLayout = (LinearLayout) inflater.inflate(R.layout.main, null);
		mWindowManager.addView(toucherLayout, mParams);

		toucherLayout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

		//用于检测状态栏高度.
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resourceId>0) {
            //statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
		mCanvas = toucherLayout.findViewById(R.id.canvas);
		mCanvas.setOnClickListener(new OnClickListener(){
				long[] hints = new long[2];
				@Override
				public void onClick(View v) {
					System.arraycopy(hints, 1, hints, 0, hints.length-1);
					hints[hints.length-1] = SystemClock.uptimeMillis();
					if(SystemClock.uptimeMillis()-hints[0]>=700) {
						v.setBackgroundColor(0x8800FF00);
						Toast.makeText(MainService.this, "连续点击两次以退出", Toast.LENGTH_SHORT).show();
					} else {
						stopSelf();
					}
				}
				
			});
		mCanvas.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					//ImageButton我放在了布局中心，布局一共300dp
					mParams.x = (int) event.getRawX() - 150;
					//这就是状态栏偏移量用的地方
					mParams.y = (int) event.getRawY() - 150 - statusBarHeight;
					windowManager.updateViewLayout(toucherLayout,params);
					return false;
				}
			});

	}



	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		if(toucherLayout != null) {
			mWindowManager.removeView(toucherLayout);
		}
		super.onDestroy();
	}


}
