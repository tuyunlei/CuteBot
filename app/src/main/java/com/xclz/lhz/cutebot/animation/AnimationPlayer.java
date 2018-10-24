package com.xclz.lhz.cutebot.animation;

import java.util.ArrayList;
import java.util.List;

public class AnimationPlayer extends Thread {
	//long lCurTime;
	long lStartTime;
	
	boolean bOver;
	boolean bPaused;

	List<AnimationGroup> mAnimGroups;

	public AnimationPlayer() {
		mAnimGroups = new ArrayList<AnimationGroup>();
	}

	@Override
	public void run() {
		while(!bOver) {
			if(!bPaused && mAnimGroups.size() >= 1) {
				boolean finished = true;
				AnimationGroup group = mAnimGroups.get(0);
				
				if(lStartTime == 0) {
					lStartTime = System.currentTimeMillis();
					initAnimGroup(group);
				}
				long curTime = System.currentTimeMillis() - lStartTime;
				
				if(group.posAnim != null && curTime <= group.posAnim.time) {
					finished = false;
					switch(group.posAnim.calc_type) {
						case Animation.CALC_TYPE_ORIGIN:
							float x = (group.posAnim.endX - group.posAnim.startX) * curTime / group.posAnim.time;
							float y = (group.posAnim.endY - group.posAnim.startY) * curTime / group.posAnim.time;
							
							break;
						case Animation.CALC_TYPE_DELTA:
							break;
						case Animation.CALC_TYPE_FUNCTION:
							break;
					}
				}
			}
		}
	}
	
	public void initAnimGroup(AnimationGroup group) {
		
	}


}
