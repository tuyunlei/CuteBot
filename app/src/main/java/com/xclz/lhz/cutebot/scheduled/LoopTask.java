package com.xclz.lhz.cutebot.scheduled;

public class LoopTask extends Task {
	private long startTime;
	private long delayTime;
	private long endTime;

	public LoopTask(long time, TaskFunction func) {
		startTime = System.currentTimeMillis();
		delayTime = time;
		endTime = startTime + delayTime;
		this.func = func;
	}

	@Override
	public boolean isAvailable() {
		if(System.currentTimeMillis() >= endTime) {
			startTime = System.currentTimeMillis();
			endTime = startTime + delayTime;
			return true;
		}
		return false;
	}


}

