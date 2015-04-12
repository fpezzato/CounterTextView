package org.fpezzato.countertextview;


import android.graphics.Paint;
import android.text.TextPaint;
/**
 * Created by francesco on 12/04/2015.
 */
public class TextPaintBuilder  extends BasePaintBuilder<TextPaintBuilder,TextPaint> {

	private Float mTextSize;

	private Paint.Align mAlign;

	public static TextPaintBuilder newTextPaintBuilder() {
		return new TextPaintBuilder();
	}

	public TextPaintBuilder withTextSize(float textSize){
		this.mTextSize = textSize;
		return this;
	}

	public TextPaintBuilder withTextAlign(Paint.Align textAlign){
		this.mAlign = textAlign;
		return this;
	}

	@Override
	protected TextPaint populate(TextPaint paint) {

		TextPaint result = super.populate(paint);
		if(mTextSize != null) {
			result.setTextSize(mTextSize);
		}
		if(mAlign != null) {
			result.setTextAlign(mAlign);
		}
		return result;
	}

	@Override
	protected TextPaint newInstance() {
		return new TextPaint();
	}
}
