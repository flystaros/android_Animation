package com.example.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends Activity 
{
	private ViewFlipper viewFlipper;
	private float startx;
	private Animation enter_lefttoright;
	private Animation out_lefttoright;
	private Animation enter_righttoleft;
	private Animation out_righttoleft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
		
		enter_lefttoright = AnimationUtils.loadAnimation(this, R.anim.enter_lefttoright);
		out_lefttoright = AnimationUtils.loadAnimation(this, R.anim.out_lefttoright);
		enter_righttoleft = AnimationUtils.loadAnimation(this, R.anim.enter_righttoleft);
		out_righttoleft = AnimationUtils.loadAnimation(this, R.anim.out_rithttoleft);
		
	}
	
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			startx = event.getX();
		}
		else if(event.getAction() == MotionEvent.ACTION_UP)
		{
			float endx = event.getX();
			if((endx - startx) > 50)
			{
				//显示下一页
				viewFlipper.setInAnimation(enter_lefttoright);
				viewFlipper.setOutAnimation(out_lefttoright);
				viewFlipper.showNext();
			}
			else if((startx-endx) > 50) 
			{
				//显示上一页
				viewFlipper.setInAnimation(enter_righttoleft);
				viewFlipper.setOutAnimation(out_righttoleft);
				viewFlipper.showPrevious();
			}
			
			return true;
		}
		return super.onTouchEvent(event);
		
	}






	public void openActivity(View v)
	{
		Intent intent = new Intent(this,OtherActivity.class);
		startActivity(intent);
		this.overridePendingTransition(R.anim.enter, R.anim.exit);
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
