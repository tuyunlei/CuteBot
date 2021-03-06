package com.xclz.lhz.cutebot.scheduled;

import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.ArrayList;

public class ScheduledTask extends Thread {
	
	private boolean bOver;
	
	private View mView;
	private Context mContext;
	private List<Task> mTasks;

	public ScheduledTask(Context context, View view) {
		mView = view;
		mContext = context;
		mTasks = new ArrayList<Task>();
		bOver = false;
	}
	
	@Override
	public void run() {
		while(!bOver) {
			for(Task task : mTasks) {
				if(!task.isAvailable())
					continue;
				new Thread(task.func).start();
				if(task instanceof LoopTask)
					mTasks.remove(task);
			}
		}
	}
	
	public void addTask(Task task) {
		mTasks.add(task);
	}
	
}
