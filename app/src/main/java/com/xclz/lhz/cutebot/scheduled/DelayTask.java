package com.xclz.lhz.cutebot.scheduled;

public class DelayTask extends Task{
	public long startTime;
	public long endTime;
	
	public DelayTask(long delayTime, TaskFunction func) {
		startTime = System.currentTimeMillis();
		endTime = startTime + delayTime;
		this.func = func;
	}

	@Override
	public boolean isAvailable() {
		if(System.currentTimeMillis() >= endTime)
			return true;
		return false;
	}
	
}
