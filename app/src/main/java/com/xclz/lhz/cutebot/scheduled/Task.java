package com.xclz.lhz.cutebot.scheduled;

public abstract class Task {
	public TaskFunction func;
	
	public abstract boolean isAvailable();
}
