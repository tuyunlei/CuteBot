package com.xclz.lhz.cutebot.scheduled;

public class DelayTask extends LoopTask{
	public DelayTask(long time, TaskFunction func) {
		super(time, func);
	}

	@Override
	public boolean isAvailable() {
		return super.isAvailable();
	}
}
