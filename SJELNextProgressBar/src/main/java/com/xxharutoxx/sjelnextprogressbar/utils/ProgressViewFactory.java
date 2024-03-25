package com.xxharutoxx.sjelnextprogressbar.utils;

import android.content.Context;

import com.xxharutoxx.sjelnextprogressbar.ArcProgressBar;
import com.xxharutoxx.sjelnextprogressbar.CircleProgressBar;
import com.xxharutoxx.sjelnextprogressbar.CircleSegmentBar;
import com.xxharutoxx.sjelnextprogressbar.LineProgressBar;

public class ProgressViewFactory {
    private Context context;

    public ProgressViewFactory(Context context) {
        this.context = context;
    }

    public ProgressShape getShape(ShapeType shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equals(ShapeType.ARC)) {
            return new ArcProgressBar(context);

        } else if (shapeType.equals(ShapeType.CIRCLE)) {
            return new CircleProgressBar(context);

        } else if (shapeType.equals(ShapeType.SEGMENT_CIRCLE)) {
            return new CircleSegmentBar(context);

        } else if (shapeType.equals(ShapeType.SEGMENT_CIRCLE)) {
            return new LineProgressBar(context);
        }

        return null;
    }
}
