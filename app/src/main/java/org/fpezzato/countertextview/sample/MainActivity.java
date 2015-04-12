package org.fpezzato.countertextview.sample;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;

import org.fpezzato.countertextview.CenteredTextView;


public class MainActivity extends ActionBarActivity {

	private CenteredTextView mCenteredTextView;
	private EditText mTextSource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextSource = (EditText)findViewById(R.id.source_text);
		mCenteredTextView = (CenteredTextView) findViewById(R.id.centered_text_view);

		SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				//	mCenteredTextView.setTextSize(progress)

				mCenteredTextView.setTextSize(progress);
				if(isNullOrBlank(mTextSource.getText().toString())){
					mCenteredTextView.setText(Integer.valueOf(progress).toString());
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		((CheckBox)findViewById(R.id.checkbox_show_guidelines)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCenteredTextView.setGuidelinesShown(isChecked);
			}
		});

		mTextSource.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				mCenteredTextView.setText(s.toString());
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

	private boolean isNullOrBlank(String s){
		return s == null || s.trim().equals("");
	}
}
