package com.xclz.lhz.cutebot.scheduled;

public abstract class Task {
	public static final int TYPE_LOOP = 0;
	public static final int TYPE_TIME = 1;
	public static final int TYPE_FUNC = 2;
	public static final int TYPE_DELAY = 3;

	public int type;
}
