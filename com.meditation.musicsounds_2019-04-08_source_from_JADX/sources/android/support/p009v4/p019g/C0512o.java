package android.support.p009v4.p019g;

import java.io.PrintWriter;

/* renamed from: android.support.v4.g.o */
public final class C0512o {

    /* renamed from: a */
    private static final Object f1517a = new Object();

    /* renamed from: b */
    private static char[] f1518b = new char[24];

    /* renamed from: a */
    private static int m2279a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    /* renamed from: a */
    private static int m2280a(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2 = j;
        int i7 = i;
        if (f1518b.length < i7) {
            f1518b = new char[i7];
        }
        char[] cArr = f1518b;
        if (j2 == 0) {
            int i8 = i7 - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i9 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i10 = floor / 60;
            i4 = floor - (i10 * 60);
            i5 = i10;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i7 != 0) {
            int a = m2279a(i2, 1, false, 0);
            int a2 = a + m2279a(i3, 1, a > 0, 2);
            int a3 = a2 + m2279a(i5, 1, a2 > 0, 2);
            int a4 = a3 + m2279a(i4, 1, a3 > 0, 2);
            i6 = 0;
            for (int a5 = a4 + m2279a(i9, 2, true, a4 > 0 ? 3 : 0) + 1; a5 < i7; a5++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i11 = i6 + 1;
        boolean z = i7 != 0;
        int i12 = i11;
        int a6 = m2281a(cArr, i2, 'd', i11, false, 0);
        int a7 = m2281a(cArr, i3, 'h', a6, a6 != i12, z ? 2 : 0);
        int a8 = m2281a(cArr, i5, 'm', a7, a7 != i12, z ? 2 : 0);
        int a9 = m2281a(cArr, i4, 's', a8, a8 != i12, z ? 2 : 0);
        int a10 = m2281a(cArr, i9, 'm', a9, true, (!z || a9 == i12) ? 0 : 3);
        cArr[a10] = 's';
        return a10 + 1;
    }

    /* renamed from: a */
    private static int m2281a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        int i7 = i4 + 1;
        cArr[i7] = c;
        return i7 + 1;
    }

    /* renamed from: a */
    public static void m2282a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m2284a(j - j2, printWriter, 0);
        }
    }

    /* renamed from: a */
    public static void m2283a(long j, PrintWriter printWriter) {
        m2284a(j, printWriter, 0);
    }

    /* renamed from: a */
    public static void m2284a(long j, PrintWriter printWriter, int i) {
        synchronized (f1517a) {
            printWriter.print(new String(f1518b, 0, m2280a(j, i)));
        }
    }
}
