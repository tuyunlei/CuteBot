package com.xclz.lhz.cutebot;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.xclz.lhz.cutebot.R;

public class BotAction {
	public static final int ACTIONID_ORIGIN = 0x000;
	public static final int ACTIONID_SECOND = 0x001;

	private Context mContext;
	
	public BotAction(Context context) {
		mContext = context;
	}
	
	public Bitmap getBitmap(int actionID) {
		Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_launcher); // 间接调用 BitmapFactory.decodeStream
		return bitmap;
	}
}
