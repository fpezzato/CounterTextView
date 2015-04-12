package org.fpezzato.countertextview;

import android.graphics.Paint;

/**
 * Created by francesco on 12/04/2015.
 */
public class PaintBuilder extends BasePaintBuilder<PaintBuilder, Paint> {

	public static PaintBuilder newPaintBuilder() {
		return new PaintBuilder();
	}

	@Override
	protected Paint newInstance() {
		return new Paint();
	}
}
