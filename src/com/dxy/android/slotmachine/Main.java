package com.dxy.android.slotmachine;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.dxy.android.slotmachine.RollControll.StopListener;

public class Main extends Activity {

	RollControll mRoll1;
	RollControll mRoll2;
	RollControll mRoll3;
	Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mRoll1 = new RollControll((ViewFlipper) findViewById(R.id.view_flipper_1), 3);
		mRoll2 = new RollControll((ViewFlipper) findViewById(R.id.view_flipper_2), 3);
		mRoll3 = new RollControll((ViewFlipper) findViewById(R.id.view_flipper_3), 3);

		View btn = findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startRoll();
			}
		});

		mRoll3.setOnStop(new StopListener() {

			@Override
			public void onStop() {
				Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}

	private void startRoll() {
		mRoll1.start(1000, 2);
		mRoll2.start(1100, 2);
		mRoll3.start(1200, 2);

	}

}