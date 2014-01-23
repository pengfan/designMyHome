package com.cpsdna.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.codingpower.home.R;
import com.cpsdna.test.manager.Manager;

public class GuideActivity extends BaseActivity {

	private TextView mRoomWidthView;
	private TextView mRoomHeightView;
	private TextView mTeatableWidthView;
	private TextView mTeatableHeightView;
	private TextView mFootstoolWidthView;
	private TextView mFootstoolHeightView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.guide);
		
		mRoomWidthView = findView(R.id.roomWidth);
		mRoomHeightView = findView(R.id.roomHeight);
		mTeatableWidthView = findView(R.id.teatableWidth);
		mTeatableHeightView = findView(R.id.teatableHeight);
		mFootstoolWidthView = findView(R.id.footstoolWidth);
		mFootstoolHeightView = findView(R.id.footstoolHeight);
		
		load(mRoomWidthView);
		load(mRoomHeightView);
		load(mTeatableWidthView);
		load(mTeatableHeightView);
		load(mFootstoolWidthView);
		load(mFootstoolHeightView);
	}
	
	public void generate(View view){
		try {
			Manager.instance().setRoomWidth(getDoubleView(mRoomWidthView));
			Manager.instance().setRoomHeight(getDoubleView(mRoomHeightView));
			Manager.instance().setTeatableWidth(getDoubleView(mTeatableWidthView));
			Manager.instance().setTeatableHeight(getDoubleView(mTeatableHeightView));
			Manager.instance().setFootstoolWidth(getDoubleView(mFootstoolWidthView));
			Manager.instance().setFootstoolHeight(getDoubleView(mFootstoolHeightView));
			
			startActivity(new Intent(GuideActivity.this, FinalActivity.class));
		} catch (NumberFormatException  e) {
			Toast.makeText(this, R.string.input_error, Toast.LENGTH_SHORT).show();
		}
	}
	
	private double getDoubleView(TextView valView){
		if(TextUtils.isEmpty(valView.getText()))
			return 0;
		double res = Double.valueOf(valView.getText().toString());
		persist(valView);
		return res;
	}
	
	private void persist(TextView textView){
		getSharedPreferences("MYAPP", 0).edit().putString(textView.getId() + "", textView.getText().toString()).commit();
	}
	
	private void load(TextView textView){
		textView.setText(getSharedPreferences("MYAPP", 0).getString(textView.getId() + "", ""));
	}
}
