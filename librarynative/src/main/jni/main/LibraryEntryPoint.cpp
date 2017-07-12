
#include <utils/android_debug.h>
#include "LibraryEntryPoint.h"

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_staticLog(
        JNIEnv *env,
        jclass jclass) {
    char *log = "[jm/debug] staticLog 2";
    LOGD(log);
    jstring jstrBuf = env->NewStringUTF(log);
    return jstrBuf;
}

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_log(
        JNIEnv *env,
        jobject jobject) {
    char *log = "[jm/debug] log 2";
    LOGD(log);
    jstring jstrBuf = env->NewStringUTF(log);
    return jstrBuf;
}