package cf.awidiyadew.daggerexample.ui.customUi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
/**
 * Created by awidiyadew on 4/11/17.
 */

public class RelativeLayoutSquareView extends RelativeLayout {

    private float heightRatio;
    private int maxHeight;


    public RelativeLayoutSquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        heightRatio = attrs.getAttributeFloatValue(null, "heightRatio", 1.0f);
        maxHeight = -1;
    }


    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // We have to manually resize the child views to match the parent.
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            final LayoutParams params = (LayoutParams)child.getLayoutParams();

            if (params.height == LayoutParams.MATCH_PARENT) {
                params.height = bottom - top;
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int)Math.ceil(this.heightRatio * (float)width);
        if (maxHeight != -1 && height > maxHeight) height = maxHeight;
        setMeasuredDimension(width, height);
    }
}

