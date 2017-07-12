package com.mercandalli.android.sdk.library;

import android.util.Log;

import java.io.File;

public class Library {

    public static void loadFromModule() {
        System.loadLibrary("log2");
    }

    public static boolean loadFromSo() {
        try {
            loadSoFromInternalStorage("liblog1.so");
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.e("jm/debug", "loadFromSo error", e);
            return false;
        }
    }

    private static void loadSoFromInternalStorage(String fileName) throws UnsatisfiedLinkError {
        // Awful trick to get the app internal folder (here we are in a lib without context, I did
        // not find another ay to get the path... my bad).
        String path = System.getProperties().get("java.io.tmpdir").toString().replace("/cache", "/files/" + fileName);
        File file = new File(path);
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkLink(file.getAbsolutePath());
        }
        System.load(file.getAbsolutePath());
    }

    public native String log();

    public static native String staticLog();
}
