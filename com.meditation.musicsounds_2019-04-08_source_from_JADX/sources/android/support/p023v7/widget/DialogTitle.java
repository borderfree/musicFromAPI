package android.support.p023v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p023v7.p024a.C0726a.C0736j;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.DialogTitle */
public class DialogTitle extends TextView {
    public DialogTitle(Context context) {
        super(context);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            int lineCount = layout.getLineCount();
            if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                setSingleLine(false);
                setMaxLines(2);
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0736j.TextAppearance, 16842817, 16973892);
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0736j.TextAppearance_android_textSize, 0);
                if (dimensionPixelSize != 0) {
                    setTextSize(0, (float) dimensionPixelSize);
                }
                obtainStyledAttributes.recycle();
                super.onMeasure(i, i2);
            }
        }
    }
}
