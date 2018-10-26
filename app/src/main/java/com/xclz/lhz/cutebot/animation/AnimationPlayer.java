package com.xclz.lhz.cutebot.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AnimationPlayer extends Thread {
	long lCurTime;
	long lSavedTime;
	long lStartTime;

	boolean bOver;
	boolean bPaused;
	boolean bStatic;

	List<AnimationGroup> mAnimGroups;

	private View mView;

	public AnimationPlayer(View view) {
		bOver = false;
		bStatic = false;
		bPaused = false;

		mView = view;
		mAnimGroups = new ArrayList<AnimationGroup>();
	}

	@Override
	public void run() {
		while(!bOver) {
			if(!bPaused) {
				if(mAnimGroups.size() >= 1) {
					boolean finished = true;
					AnimationGroup group = mAnimGroups.get(0);

					if(lStartTime == 0) {
						lStartTime = System.currentTimeMillis();
						if(lSavedTime == 0)
							initAnimGroup(group);
					}
					lCurTime = System.currentTimeMillis() - lStartTime;
					//TODO:Add the curTime to savedTime when paused!!

					if(group.posAnim != null && lCurTime <= group.posAnim.time) {
						finished = false;
						if(group.posAnim.calc_type != Animation.CALC_TYPE_FUNCTION) {
							float x = group.posAnim.startX + group.posAnim.oneX * (lSavedTime + lCurTime);
							float y = group.posAnim.startY + group.posAnim.oneY * (lSavedTime + lCurTime);
							mView.setX(x);
							mView.setY(y);
						}
					}

					if(finished) {
						mAnimGroups.remove(group);
						lCurTime = 0;
						lStartTime = 0;
						lSavedTime = 0;
					}
				} else {
					if(!bStatic) {
						//TODO:Change the staticBitmap
					}
				}
			}
		}
	}

	public void initAnimGroup(AnimationGroup group) {
		if(group.posAnim.calc_type == Animation.CALC_TYPE_ORIGIN) {
			group.posAnim.oneX = (group.posAnim.endX - group.posAnim.startX) / group.posAnim.time;
			group.posAnim.oneY = (group.posAnim.endY - group.posAnim.startY) / group.posAnim.time;
		} else if(group.posAnim.calc_type == Animation.CALC_TYPE_DELTA) {
			group.posAnim.startX = mView.getX();
			group.posAnim.startY = mView.getY();
			group.posAnim.oneX = group.posAnim.deltaX / group.posAnim.time;
			group.posAnim.oneY = group.posAnim.deltaY / group.posAnim.time;
		}
	}


}
