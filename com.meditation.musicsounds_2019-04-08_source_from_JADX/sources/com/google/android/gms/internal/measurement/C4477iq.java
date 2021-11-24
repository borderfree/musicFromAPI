package com.google.android.gms.internal.measurement;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.internal.measurement.iq */
public final class C4477iq {

    /* renamed from: a */
    private final ByteBuffer f16307a;

    /* renamed from: b */
    private zztv f16308b;

    /* renamed from: c */
    private int f16309c;

    private C4477iq(ByteBuffer byteBuffer) {
        this.f16307a = byteBuffer;
        this.f16307a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private C4477iq(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    public static int m22215a(int i) {
        if (i >= 0) {
            return m22229d(i);
        }
        return 10;
    }

    /* renamed from: a */
    public static int m22216a(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: a */
    private static int m22217a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: a */
    public static int m22218a(String str) {
        int a = m22217a((CharSequence) str);
        return m22229d(a) + a;
    }

    /* renamed from: a */
    public static C4477iq m22219a(byte[] bArr) {
        return m22220a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C4477iq m22220a(byte[] bArr, int i, int i2) {
        return new C4477iq(bArr, 0, i2);
    }

    /* renamed from: a */
    private static void m22221a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5) {
                            break;
                        }
                        char charAt = charSequence.charAt(i4);
                        if (charAt >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 < 128 && i2 < i5) {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i2 <= i5 - 2) {
                                int i7 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                i2 = i7 + 1;
                                array[i7] = (byte) ((charAt2 & '?') | 128);
                                i4++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i2 <= i5 - 3) {
                                int i8 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 12) | 480);
                                int i9 = i8 + 1;
                                array[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i3 = i9 + 1;
                                array[i9] = (byte) ((charAt2 & '?') | 128);
                            } else if (i2 <= i5 - 4) {
                                int i10 = i4 + 1;
                                if (i10 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i11 = i2 + 1;
                                        array[i2] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i2 = i13 + 1;
                                        array[i13] = (byte) ((codePoint & 63) | 128);
                                        i4 = i10;
                                        i4++;
                                    } else {
                                        i4 = i10;
                                    }
                                }
                                int i14 = i4 - 1;
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i14);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                            i = ((charAt4 >>> 6) & 63) | 128;
                        } else {
                            int i15 = i4 + 1;
                            if (i15 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i15);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                    i4 = i15;
                                    i4++;
                                } else {
                                    i4 = i15;
                                }
                            }
                            int i16 = i4 - 1;
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i16);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        byteBuffer.put((byte) i);
                        charAt4 = (charAt4 & '?') | 128;
                    }
                    byteBuffer.put((byte) charAt4);
                    i4++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    /* renamed from: b */
    public static int m22222b(int i) {
        return m22229d(i << 3);
    }

    /* renamed from: b */
    public static int m22223b(int i, int i2) {
        return m22222b(i) + m22215a(i2);
    }

    /* renamed from: b */
    public static int m22224b(int i, C4483iw iwVar) {
        int b = m22222b(i);
        int e = iwVar.mo14784e();
        return b + m22229d(e) + e;
    }

    /* renamed from: b */
    public static int m22225b(int i, String str) {
        return m22222b(i) + m22218a(str);
    }

    /* renamed from: b */
    private final zztv m22226b() {
        if (this.f16308b == null) {
            this.f16308b = zztv.m22408a(this.f16307a);
        } else {
            if (this.f16309c != this.f16307a.position()) {
                this.f16308b.mo14924b(this.f16307a.array(), this.f16309c, this.f16307a.position() - this.f16309c);
            }
            return this.f16308b;
        }
        this.f16309c = this.f16307a.position();
        return this.f16308b;
    }

    /* renamed from: b */
    private final void m22227b(long j) {
        while ((-128 & j) != 0) {
            m22230e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m22230e((int) j);
    }

    /* renamed from: c */
    public static int m22228c(int i, long j) {
        return m22222b(i) + m22216a(j);
    }

    /* renamed from: d */
    public static int m22229d(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: e */
    private final void m22230e(int i) {
        byte b = (byte) i;
        if (this.f16307a.hasRemaining()) {
            this.f16307a.put(b);
            return;
        }
        throw new zzyb(this.f16307a.position(), this.f16307a.limit());
    }

    /* renamed from: a */
    public final void mo14747a() {
        if (this.f16307a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.f16307a.remaining())}));
        }
    }

    /* renamed from: a */
    public final void mo14748a(int i, double d) {
        mo14760c(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.f16307a.remaining() >= 8) {
            this.f16307a.putLong(doubleToLongBits);
            return;
        }
        throw new zzyb(this.f16307a.position(), this.f16307a.limit());
    }

    /* renamed from: a */
    public final void mo14749a(int i, float f) {
        mo14760c(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.f16307a.remaining() >= 4) {
            this.f16307a.putInt(floatToIntBits);
            return;
        }
        throw new zzyb(this.f16307a.position(), this.f16307a.limit());
    }

    /* renamed from: a */
    public final void mo14750a(int i, int i2) {
        mo14760c(i, 0);
        if (i2 >= 0) {
            mo14759c(i2);
        } else {
            m22227b((long) i2);
        }
    }

    /* renamed from: a */
    public final void mo14751a(int i, long j) {
        mo14760c(i, 0);
        m22227b(j);
    }

    /* renamed from: a */
    public final void mo14752a(int i, C4419gq gqVar) {
        zztv b = m22226b();
        b.mo14905a(i, gqVar);
        b.mo14896a();
        this.f16309c = this.f16307a.position();
    }

    /* renamed from: a */
    public final void mo14753a(int i, C4483iw iwVar) {
        mo14760c(i, 2);
        mo14756a(iwVar);
    }

    /* renamed from: a */
    public final void mo14754a(int i, String str) {
        mo14760c(i, 2);
        try {
            int d = m22229d(str.length());
            if (d == m22229d(str.length() * 3)) {
                int position = this.f16307a.position();
                if (this.f16307a.remaining() >= d) {
                    this.f16307a.position(position + d);
                    m22221a((CharSequence) str, this.f16307a);
                    int position2 = this.f16307a.position();
                    this.f16307a.position(position);
                    mo14759c((position2 - position) - d);
                    this.f16307a.position(position2);
                    return;
                }
                throw new zzyb(position + d, this.f16307a.limit());
            }
            mo14759c(m22217a((CharSequence) str));
            m22221a((CharSequence) str, this.f16307a);
        } catch (BufferOverflowException e) {
            zzyb zzyb = new zzyb(this.f16307a.position(), this.f16307a.limit());
            zzyb.initCause(e);
            throw zzyb;
        }
    }

    /* renamed from: a */
    public final void mo14755a(int i, boolean z) {
        mo14760c(i, 0);
        byte b = z ? (byte) 1 : 0;
        if (this.f16307a.hasRemaining()) {
            this.f16307a.put(b);
            return;
        }
        throw new zzyb(this.f16307a.position(), this.f16307a.limit());
    }

    /* renamed from: a */
    public final void mo14756a(C4483iw iwVar) {
        mo14759c(iwVar.mo14783d());
        iwVar.mo14224a(this);
    }

    /* renamed from: b */
    public final void mo14757b(int i, long j) {
        mo14760c(i, 0);
        m22227b(j);
    }

    /* renamed from: b */
    public final void mo14758b(byte[] bArr) {
        int length = bArr.length;
        if (this.f16307a.remaining() >= length) {
            this.f16307a.put(bArr, 0, length);
            return;
        }
        throw new zzyb(this.f16307a.position(), this.f16307a.limit());
    }

    /* renamed from: c */
    public final void mo14759c(int i) {
        while ((i & -128) != 0) {
            m22230e((i & 127) | 128);
            i >>>= 7;
        }
        m22230e(i);
    }

    /* renamed from: c */
    public final void mo14760c(int i, int i2) {
        mo14759c((i << 3) | i2);
    }
}
