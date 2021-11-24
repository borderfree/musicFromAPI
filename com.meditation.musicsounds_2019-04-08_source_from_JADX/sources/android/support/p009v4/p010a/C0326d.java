package android.support.p009v4.p010a;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

/* renamed from: android.support.v4.a.d */
class C0326d extends C0329g {
    C0326d() {
    }

    /* renamed from: a */
    private File m1225a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/self/fd/");
            sb.append(parcelFileDescriptor.getFd());
            String readlink = Os.readlink(sb.toString());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0062, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0063, code lost:
        r3 = r7;
        r7 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0018] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo1174a(android.content.Context r5, android.os.CancellationSignal r6, android.support.p009v4.p017e.C0464b.C0470b[] r7, int r8) {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            android.support.v4.e.b$b r7 = r4.mo1177a(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.mo1864a()     // Catch:{ IOException -> 0x0077 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch:{ IOException -> 0x0077 }
            java.io.File r7 = r4.m1225a(r6)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            if (r7 == 0) goto L_0x002f
            boolean r8 = r7.canRead()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            if (r8 != 0) goto L_0x0025
            goto L_0x002f
        L_0x0025:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            if (r6 == 0) goto L_0x002e
            r6.close()     // Catch:{ IOException -> 0x0077 }
        L_0x002e:
            return r5
        L_0x002f:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            android.graphics.Typeface r5 = super.mo1176a(r5, r7)     // Catch:{ Throwable -> 0x0048, all -> 0x0045 }
            r7.close()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            if (r6 == 0) goto L_0x0044
            r6.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0044:
            return r5
        L_0x0045:
            r5 = move-exception
            r8 = r1
            goto L_0x004e
        L_0x0048:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004a }
        L_0x004a:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L_0x004e:
            if (r8 == 0) goto L_0x0059
            r7.close()     // Catch:{ Throwable -> 0x0054, all -> 0x005d }
            goto L_0x005c
        L_0x0054:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            goto L_0x005c
        L_0x0059:
            r7.close()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
        L_0x005c:
            throw r5     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
        L_0x005d:
            r5 = move-exception
            r7 = r1
            goto L_0x0066
        L_0x0060:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L_0x0066:
            if (r6 == 0) goto L_0x0076
            if (r7 == 0) goto L_0x0073
            r6.close()     // Catch:{ Throwable -> 0x006e }
            goto L_0x0076
        L_0x006e:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ IOException -> 0x0077 }
            goto L_0x0076
        L_0x0073:
            r6.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0076:
            throw r5     // Catch:{ IOException -> 0x0077 }
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.p010a.C0326d.mo1174a(android.content.Context, android.os.CancellationSignal, android.support.v4.e.b$b[], int):android.graphics.Typeface");
    }
}
