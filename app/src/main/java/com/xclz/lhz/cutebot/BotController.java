package com.xclz.lhz.cutebot;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

public class BotController {
	private BotView botView;
	private BotModel botModel;

	private Context mContext;
	
	public BotController(Context context) {
		mContext = context;
	}
	
	public void create() {
		botModel = new BotModel(mContext);
		Bitmap bitmap = botModel.getBitmap(BotAction.ACTIONID_ORIGIN);
		botView = new BotView(mContext, bitmap);
	}
	
	
}
