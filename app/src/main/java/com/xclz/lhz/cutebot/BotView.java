package com.xclz.lhz.cutebot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class BotView extends View {
	public Bitmap origin;
	
	public BotView(Context context, Bitmap bitmap) {
		super(context);
		origin = bitmap;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(origin, 0, 0, null);
	}
	
}
