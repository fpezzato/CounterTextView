package org.fpezzato.countertextview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import static org.fpezzato.countertextview.PaintBuilder.newPaintBuilder;

/**
 * Created by francesco on 12/04/2015.
 */
public class UiUtils {
	public static final int STEP = 10;

	public static void drawDebugGuidelines(Canvas canvas, Paint debugPaint, Rect clipBounds) {
		if (debugPaint == null) {
			debugPaint = newPaintBuilder()
				.withAntiAlias()
				.withColor(Color.GREEN)
				.withAlpha(150)
				.withHairLineStroke()
				.build();
		}

		try {
			canvas.save();
			for (int i = 0; i <= clipBounds.right; i = i + STEP) {
				canvas.translate(STEP, 0);
				canvas.drawLine(0, 0, 0, clipBounds.bottom, debugPaint);
			}
		} finally {
			canvas.restore();
		}

		try {
			canvas.save();
			for (int i = 0; i <= clipBounds.bottom; i = i + STEP) {
				canvas.translate(0, STEP);
				canvas.drawLine(0, 0, clipBounds.right, 0, debugPaint);
			}
		} finally {
			canvas.restore();
		}
	}
}