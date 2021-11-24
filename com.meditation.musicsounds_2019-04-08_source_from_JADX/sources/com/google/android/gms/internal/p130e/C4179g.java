package com.google.android.gms.internal.p130e;

/* renamed from: com.google.android.gms.internal.e.g */
final class C4179g extends C4176d {

    /* renamed from: a */
    private final C4177e f15618a = new C4177e();

    C4179g() {
    }

    /* renamed from: a */
    public final void mo14018a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f15618a.mo14019a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
