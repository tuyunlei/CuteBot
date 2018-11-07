package com.xclz.lhz.cutebot.animation;

import com.xclz.lhz.cutebot.FloatBot;

abstract public class Animation {
	protected static final int CALC_TYPE_ORIGIN = 0;
	protected static final int CALC_TYPE_DELTA = 1;
	protected static final int CALC_TYPE_FUNCTION = 2;
	
	public int calc_type;

	protected FloatBot mBot;
	
	public void init(FloatBot bot) {
		mBot = bot;
	}
	
	public abstract void onTime(long time);
}
