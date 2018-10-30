package com.xclz.lhz.cutebot.scheduled;

public class LoopTask extends DelayTask {

	public LoopTask(long delayTime, TaskFunction func) {
		super(delayTime, func);
		TaskFunction newFunc = new TaskFunction(){
			@Override
			public void run() {
				
			}
		};
	}

	private class LoopFuntion extends TaskFunction {
		public LoopFuntion() {
			
		}

		@Override
		public void run() {
		}

	}
}

