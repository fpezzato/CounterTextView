package org.fpezzato.countertextview;

import android.graphics.Paint;

/**
 * Created by francesco on 12/04/2015.
 */
public abstract class BasePaintBuilder<T extends BasePaintBuilder<T,S>, S extends Paint> {
	private boolean mIsAntiAlias;
	private int mColor;
	private int mAlpha;
	private Integer mStrokeWidth;


	public T withAntiAlias() {
		this.mIsAntiAlias = true;
		return (T) this;
	}

	public T withColor(int color) {
		this.mColor = color;
		return (T) this;
	}

	public T withAlpha(int alpha){
		this.mAlpha = alpha;
		return (T) this;
	}


	public T withHairLineStroke(){
		this.mStrokeWidth = 0;
		return (T) this;
	}

	public T withStrokeWidth(int strokeWidth){
		this.mStrokeWidth = strokeWidth;
		return (T) this;
	}

	protected S build(){
		return populate(newInstance());
	}

	protected abstract S newInstance();


	protected S populate(S paint) {
		paint.setAntiAlias(mIsAntiAlias);
		paint.setColor(mColor);
		paint.setAlpha(mAlpha);
		if(mStrokeWidth != null){
			paint.setStrokeWidth(mStrokeWidth);
		}
		return paint;
	}
}
