package org.fpezzato.countertextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import static org.fpezzato.countertextview.PaintBuilder.newPaintBuilder;

/**
 * Created by francesco on 12/04/2015.
 */
public class CenteredTextView extends TextView {

	private Paint mTextPaint;
	private boolean mShowGuidelines = false;
	private Rect mClipBounds = new Rect();
	private Paint mDebugPaint;
	private PaintDrawable mBackground;
	private int mTextHeight;
	private int mOriginalTextColor;

	public CenteredTextView(Context context) {
		super(context);

		init();
	}

	public CenteredTextView(Context context, AttributeSet attrs) {
		super(context, attrs, R.attr.ctv_centeredTextViewStyle);

		setAttributes(context, attrs);
		init();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public CenteredTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		setAttributes(context, attrs);
		init();
	}


	private void setAttributes(Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.CenteredTextView,
			R.attr.ctv_centeredTextViewStyle,
			0);

		try {
			//Explicit background color
			int color = a.getColor(R.styleable.CenteredTextView_ctv_rounded_background_color, Color.TRANSPARENT);
			mBackground = new PaintDrawable(color);

			//enable debug mode from xml
			mShowGuidelines = a.getBoolean(R.styleable.CenteredTextView_ctv_show_guidelines, false);

		} finally {
			a.recycle();
		}
	}

	public void setGuidelinesShown(boolean showGuidelines) {
		this.mShowGuidelines = showGuidelines;
		invalidate();
	}

	private void init() {
		mTextPaint = new TextPaint();

		//Trick to avoid the parent to write visible text
		mOriginalTextColor = getCurrentTextColor();
		super.setTextColor(Color.TRANSPARENT);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		mTextPaint.set(super.getPaint());
		mTextPaint.setColor(mOriginalTextColor);
		mTextPaint.setTextAlign(Paint.Align.CENTER);

		CharSequence text = getText();
		int textWidth = (int) mTextPaint.measureText(text, 0, text.length());

		//Real text  Height
		Rect textBounds = new Rect();
		mTextPaint.getTextBounds(text.toString(), 0, text.length(), textBounds);
		mTextHeight = textBounds.height();

		int height = (int) (mTextHeight + getTextSize());
		int width = (int) Math.max(textWidth + getTextSize(), height);

		setMeasuredDimension(width, height);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//re-acquire the clipbounds var.
		canvas.getClipBounds(mClipBounds);

		int radius = mClipBounds.height() / 2;

		if (mBackground == null) {
			mBackground = new PaintDrawable();
			mBackground.getPaint().setColor(Color.TRANSPARENT);
		}

		mBackground.setBounds(mClipBounds);
		mBackground.setCornerRadius(radius);
		mBackground.draw(canvas);

		CharSequence text = getText();
		canvas.drawText(text, 0, text.length(),
			mClipBounds.centerX(),
			mClipBounds.centerY() + (mTextHeight / 2f),
			mTextPaint);

		if (mShowGuidelines) {
			displayDebugGuidelines(canvas);
		}
	}

	private void displayDebugGuidelines(Canvas canvas) {
		if (mDebugPaint == null) {
			mDebugPaint = newPaintBuilder()
				.withAntiAlias()
				.withColor(Color.GREEN)
				.withAlpha(150)
				.withHairLineStroke()
				.build();
		}
		UiUtils.drawDebugGuidelines(canvas, mDebugPaint, mClipBounds);
	}
}
