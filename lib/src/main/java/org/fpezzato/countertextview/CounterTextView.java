package org.fpezzato.countertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/**
 * Created by francesco on 12/04/2015.
 * <p/>
 * Simplify the display of a counter with a (rounded) background if needed.
 * Permits to set the 'upper bound'  of the counter, and in case of overflow
 * the upper bound is displayed, with a '+' sign as prefix.
 */
public class CounterTextView extends CenteredTextView {

	private int mUpperBound = 99;
	private String mOverflowPrefix = "+";

	public CounterTextView(Context context) {
		super(context);
	}

	public CounterTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAttributes(context, attrs);
	}

	public CounterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setAttributes(context, attrs);
	}

	public void setCount(int count) {
		String result = (mUpperBound < count) ? mOverflowPrefix + mUpperBound : Integer.valueOf(count).toString();
		super.setText(result);

	}

	private void setAttributes(Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(
			attrs, R.styleable.CounterTextView, 0, 0);

		try {
			//Explicit overflow string
			String overflowPrefix = a.getString(R.styleable.CounterTextView_ctv_overflow_prefix);
			if (overflowPrefix != null) {
				mOverflowPrefix = overflowPrefix;
			}

		} finally {
			a.recycle();
		}
	}


	/**
	 * Set up the upper bound of the counter. When reached, the prefix '+' will be prefixed.
	 *
	 * @param upperBound the maximum value displayed.
	 */
	public CounterTextView withUpperBound(int upperBound) {
		this.mUpperBound = upperBound;
		return this;
	}

	/**
	 * SEt the overflow string, used as prefix when the total counter is bigger than the Upper bound.
	 *
	 * @param overflowPrefix
	 * @return
	 */
	public CounterTextView withOverflowPrefix(String overflowPrefix) {
		this.mOverflowPrefix = overflowPrefix;
		return this;
	}

}
