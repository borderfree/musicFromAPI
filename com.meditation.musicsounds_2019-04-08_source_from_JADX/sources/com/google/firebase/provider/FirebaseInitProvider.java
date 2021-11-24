package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.C3266s;
import com.google.firebase.C4890b;

public class FirebaseInitProvider extends ContentProvider {
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        C3266s.m14914a(providerInfo, (Object) "FirebaseInitProvider ProviderInfo cannot be null.");
        if (!"com.google.firebase.firebaseinitprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        String str;
        String str2;
        if (C4890b.m24413b(getContext()) == null) {
            str = "FirebaseInitProvider";
            str2 = "FirebaseApp initialization unsuccessful";
        } else {
            str = "FirebaseInitProvider";
            str2 = "FirebaseApp initialization successful";
        }
        Log.i(str, str2);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}