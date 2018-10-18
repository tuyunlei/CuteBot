package com.xclz.lhz.cutebot;



import android.content.Context;
import android.graphics.Bitmap;

public class BotModel {
	public static final int SEX_MALE = 0;
	public static final int SEX_FEMALE = 1;
	
	private int sex;
	private String name;
	private BotAction mAction;

	private Context mContext;
	//private BotImages images;
	public BotModel(Context context) {
		mContext = context;
	}
	
	public Bitmap getBitmap(int actionID) {
		return mAction.getBitmap(actionID);
	}
}
