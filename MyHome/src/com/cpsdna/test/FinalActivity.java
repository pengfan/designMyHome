package com.cpsdna.test;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

import com.codingpower.home.R;
import com.cpsdna.test.manager.Manager;
import com.cpsdna.test.view.HorizontalDimensionLine;
import com.cpsdna.test.view.VerticalDimensionLine;

public class FinalActivity extends BaseActivity {

	private RelativeLayout mRoomView;
	private RelativeLayout mTeatableView;
	private double trueWidth;
	private int pixelWidth;
	
	private VerticalDimensionLine mTopTableLine;
	private HorizontalDimensionLine mLeftTableLine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.result);
		
		mRoomView = findView(R.id.room);
		mTeatableView = findView(R.id.teatable);
		mTopTableLine = findView(R.id.toptableline);
		mLeftTableLine = findView(R.id.lefttableline);
		setData();
	}
	
	private void setData(){
		trueWidth = Manager.instance().getRoomWidth();
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		pixelWidth = metrics.widthPixels;
		
		setViewSize(mRoomView, Manager.instance().getRoomWidth(), Manager.instance().getRoomHeight());
		setViewSize(mTeatableView, Manager.instance().getTeatableWidth(), Manager.instance().getTeatableHeight());
		mTeatableView.post(new Runnable() {
			
			@Override
			public void run() {
				mTopTableLine.setValue(getTrueVal(mTeatableView.getTop()));
				mLeftTableLine.setValue(getTrueVal(mTeatableView.getLeft()));
			}
		});
	}
	
	private void setViewSize(View view, double width, double height){
		LayoutParams lp = view.getLayoutParams();
		lp.width = getPixel(width);
		lp.height = getPixel(height);
		view.setLayoutParams(lp);
	}
	
	private int getPixel(double val){
		return (int)(pixelWidth * val / trueWidth);
	}
	
	private double getTrueVal(int pixel){
		return pixel * trueWidth / pixelWidth;
	}
}
