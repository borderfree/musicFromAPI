package com.google.android.gms.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.common.util.k */
public class C3306k {

    /* renamed from: a */
    private static final Pattern f11206a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b */
    private static final Pattern f11207b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* renamed from: c */
    private static final Pattern f11208c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    /* renamed from: a */
    private static String m15062a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public static Map<String, String> m15063a(URI uri, String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new HashMap<>();
            Scanner scanner = new Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                String[] split = scanner.next().split("=");
                if (split.length == 0 || split.length > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                String a = m15062a(split[0], str);
                String str2 = null;
                if (split.length == 2) {
                    str2 = m15062a(split[1], str);
                }
                emptyMap.put(a, str2);
            }
        }
        return emptyMap;
    }
}
