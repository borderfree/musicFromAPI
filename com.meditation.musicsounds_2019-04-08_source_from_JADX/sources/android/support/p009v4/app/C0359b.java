package android.support.p009v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.app.b */
public final class C0359b {
    /* renamed from: a */
    public static int m1492a(Context context, String str, String str2) {
        if (VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }

    /* renamed from: a */
    public static String m1493a(String str) {
        if (VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }
}