#include "LibraryEntryPoint.h"

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_log(
        JNIEnv *env,
        jobject obj) {
    char *log = "jm/debug test 1";
    LOGD(log);
    jstring jstrBuf = env->NewStringUTF(log);
    return jstrBuf;
}