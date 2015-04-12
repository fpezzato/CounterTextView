package org.fpezzato.countertextview.sample;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.fpezzato.countertextview.CounterTextView;


public class MainActivity extends ActionBarActivity {

	private CounterTextView mCounterTextView;
	private TextView mCurrentRealCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mCounterTextView = (CounterTextView) findViewById(R.id.counter_text_view);
		mCurrentRealCount = (TextView)findViewById(R.id.main_activity_current_count);

		SeekBar textSizeSeekBar = (SeekBar) findViewById(R.id.main_activity_text_size_bar);
		textSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mCounterTextView.setTextSize(progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//nop
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//nop
			}
		});

		SeekBar countBar = (SeekBar) findViewById(R.id.main_activity_count_bar);
		countBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mCounterTextView.setCount(progress);
				mCurrentRealCount.setText(Integer.valueOf(progress).toString());
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//nop
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//nop
			}
		});
		((CheckBox) findViewById(R.id.checkbox_show_guidelines)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCounterTextView.setGuidelinesShown(isChecked);
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private boolean isNullOrBlank(String s) {
		return s == null || s.trim().equals("");
	}
}
