package com.xclz.lhz.cutebot.animation;

import android.view.View;

public class PositionAnimation extends Animation{
	public float oneX, oneY;
	public float deltaX, deltaY;
	public AnimFunction funcX, funcY;
	public float startX, startY, endX, endY;
	
	public long time;
	
	public PositionAnimation(float deltaX, float deltaY, long time) {
		this.calc_type = this.CALC_TYPE_DELTA;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.time = time;
	}
	
	public PositionAnimation(AnimFunction funcX, AnimFunction funcY, long time) {
		this.calc_type = this.CALC_TYPE_FUNCTION;
		this.funcX = funcX;
		this.funcY = funcY;
		this.time = time;
	}
	
	
	public PositionAnimation(float startX, float endX, float startY, float endY, long time) {
		this.calc_type = this.CALC_TYPE_ORIGIN;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		//this.deltaX = (endX - startX) / time;
		//this.deltaY = (endY - startY) / time;
		this.time = time;
	}
}
