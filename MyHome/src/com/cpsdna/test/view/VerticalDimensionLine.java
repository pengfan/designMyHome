package com.cpsdna.test.view;

import java.text.DecimalFormat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.codingpower.home.R;

public class VerticalDimensionLine extends FrameLayout {
	private TextView mValView;
	private static final DecimalFormat FORMAT = new DecimalFormat("##.#"); 

	public VerticalDimensionLine(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public VerticalDimensionLine(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.vertical_dimen, this, true);
		mValView = (TextView)findViewById(R.id.valueView);
	}

	public VerticalDimensionLine(Context context) {
		super(context);
	}
	
	public void setValue(double value){
		mValView.setText(FORMAT.format(value));
	}

}
