package com.xclz.lhz.cutebot.animation;

import android.view.View;

public class AnimationGroup {
	public SizeAnimation sizeAnim;
	public ImageAnimation imgAnim;
	public PositionAnimation posAnim;
	public RotateAnimation rotateAnim;
	
	public void init(View view) {
		if(this.posAnim.calc_type == Animation.CALC_TYPE_ORIGIN) {
			this.posAnim.oneX = (this.posAnim.endX - this.posAnim.startX) / this.posAnim.ttime;
			this.posAnim.oneY = (this.posAnim.endY - this.posAnim.startY) / this.posAnim.ttime;
		} else if(this.posAnim.calc_type == Animation.CALC_TYPE_DELTA) {
			this.posAnim.startX = view.getX();
			this.posAnim.startY = view.getY();
			this.posAnim.oneX = this.posAnim.deltaX / this.posAnim.ttime;
			this.posAnim.oneY = this.posAnim.deltaY / this.posAnim.ttime;
		} //TODO: other anims;
	}
}
