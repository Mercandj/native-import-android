package com.mercandalli.android.sdk.library;

public class Library {

    static {
        System.loadLibrary("library");
    }

    public Library() {

    }

    public native String log();
}
