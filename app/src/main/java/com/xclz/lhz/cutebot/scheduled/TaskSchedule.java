package com.xclz.lhz.cutebot.scheduled;

import com.xclz.lhz.cutebot.FloatBot;

public class TaskSchedule extends Thread {

	private FloatBot mBot;
	
	public TaskSchedule(FloatBot bot) {
		mBot = bot;
	}
	
}
