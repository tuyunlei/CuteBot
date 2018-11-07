package com.xclz.lhz.cutebot.animation;

import android.view.View;
import com.xclz.lhz.cutebot.FloatBot;

public class PositionAnimation extends Animation {
	public float oneX, oneY;
	public float deltaX, deltaY;
	//public AnimFunction funcX, funcY;
	public float startX, startY, endX, endY;
	
	public long ttime;
	
	public PositionAnimation(float deltaX, float deltaY, long time) {
		this.calc_type = this.CALC_TYPE_DELTA;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.oneX = deltaX / time;
		this.oneY = deltaY / time;
		this.ttime = time;
	}
	
	/*
	public PositionAnimation(AnimFunction funcX, AnimFunction funcY, long time) {
		this.calc_type = this.CALC_TYPE_FUNCTION;
		this.funcX = funcX;
		this.funcY = funcY;
		this.time = time;
	}
	*/
	
	
	public PositionAnimation(float startX, float endX, float startY, float endY, long time) {
		this.calc_type = this.CALC_TYPE_ORIGIN;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.oneX = (endX - startX) / time;
		this.oneY = (endY - startY) / time;
		this.ttime = time;
	}

	@Override
	public void init(FloatBot bot) {
		super.init(bot);
		if(this.calc_type == this.CALC_TYPE_DELTA) {
			startX = bot.getX();
			startY = bot.getY();
		}
	}
	
	@Override
	public void onTime(long time) {
		float x = startX + oneX*time;
	}
}
