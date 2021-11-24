package android.support.p023v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.p009v4.p010a.p011a.C0313c;
import android.support.p023v7.p028d.p029a.C0820a;

/* renamed from: android.support.v7.widget.ag */
public class C1011ag {

    /* renamed from: a */
    public static final Rect f3469a = new Rect();

    /* renamed from: b */
    private static Class<?> f3470b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f3470b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* renamed from: a */
    public static Mode m5518a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[Catch:{ Exception -> 0x0098 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Rect m5519a(android.graphics.drawable.Drawable r10) {
        /*
            java.lang.Class<?> r0 = f3470b
            if (r0 == 0) goto L_0x009f
            android.graphics.drawable.Drawable r10 = android.support.p009v4.p010a.p011a.C0311a.m1187h(r10)     // Catch:{ Exception -> 0x0098 }
            java.lang.Class r0 = r10.getClass()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r1 = "getOpticalInsets"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0098 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0098 }
            java.lang.Object r10 = r0.invoke(r10, r1)     // Catch:{ Exception -> 0x0098 }
            if (r10 == 0) goto L_0x009f
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x0098 }
            r0.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.Class<?> r1 = f3470b     // Catch:{ Exception -> 0x0098 }
            java.lang.reflect.Field[] r1 = r1.getFields()     // Catch:{ Exception -> 0x0098 }
            int r3 = r1.length     // Catch:{ Exception -> 0x0098 }
            r4 = 0
        L_0x002a:
            if (r4 >= r3) goto L_0x0097
            r5 = r1[r4]     // Catch:{ Exception -> 0x0098 }
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x0098 }
            r7 = -1
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x0098 }
            r9 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
            if (r8 == r9) goto L_0x006a
            r9 = 115029(0x1c155, float:1.6119E-40)
            if (r8 == r9) goto L_0x0060
            r9 = 3317767(0x32a007, float:4.649182E-39)
            if (r8 == r9) goto L_0x0056
            r9 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r8 == r9) goto L_0x004c
            goto L_0x0074
        L_0x004c:
            java.lang.String r8 = "right"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x0098 }
            if (r6 == 0) goto L_0x0074
            r6 = 2
            goto L_0x0075
        L_0x0056:
            java.lang.String r8 = "left"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x0098 }
            if (r6 == 0) goto L_0x0074
            r6 = 0
            goto L_0x0075
        L_0x0060:
            java.lang.String r8 = "top"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x0098 }
            if (r6 == 0) goto L_0x0074
            r6 = 1
            goto L_0x0075
        L_0x006a:
            java.lang.String r8 = "bottom"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x0098 }
            if (r6 == 0) goto L_0x0074
            r6 = 3
            goto L_0x0075
        L_0x0074:
            r6 = -1
        L_0x0075:
            switch(r6) {
                case 0: goto L_0x008e;
                case 1: goto L_0x0087;
                case 2: goto L_0x0080;
                case 3: goto L_0x0079;
                default: goto L_0x0078;
            }     // Catch:{ Exception -> 0x0098 }
        L_0x0078:
            goto L_0x0094
        L_0x0079:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x0098 }
            r0.bottom = r5     // Catch:{ Exception -> 0x0098 }
            goto L_0x0094
        L_0x0080:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x0098 }
            r0.right = r5     // Catch:{ Exception -> 0x0098 }
            goto L_0x0094
        L_0x0087:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x0098 }
            r0.top = r5     // Catch:{ Exception -> 0x0098 }
            goto L_0x0094
        L_0x008e:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x0098 }
            r0.left = r5     // Catch:{ Exception -> 0x0098 }
        L_0x0094:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x0097:
            return r0
        L_0x0098:
            java.lang.String r10 = "DrawableUtils"
            java.lang.String r0 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r10, r0)
        L_0x009f:
            android.graphics.Rect r10 = f3469a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p023v7.widget.C1011ag.m5519a(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    /* renamed from: b */
    static void m5520b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m5522d(drawable);
        }
    }

    /* renamed from: c */
    public static boolean m5521c(Drawable drawable) {
        Drawable drawable2;
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable c : ((DrawableContainerState) constantState).getChildren()) {
                    if (!m5521c(c)) {
                        return false;
                    }
                }
            }
        } else {
            if (drawable instanceof C0313c) {
                drawable2 = ((C0313c) drawable).mo1131a();
            } else if (drawable instanceof C0820a) {
                drawable2 = ((C0820a) drawable).mo3236b();
            } else if (drawable instanceof ScaleDrawable) {
                drawable2 = ((ScaleDrawable) drawable).getDrawable();
            }
            return m5521c(drawable2);
        }
        return true;
    }

    /* renamed from: d */
    private static void m5522d(Drawable drawable) {
        int[] state = drawable.getState();
        drawable.setState((state == null || state.length == 0) ? C1073bf.f3735e : C1073bf.f3738h);
        drawable.setState(state);
    }
}