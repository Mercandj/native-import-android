#ifndef LIBRARYNATIVE_ENTRYPOINT_H
#define LIBRARYNATIVE_ENTRYPOINT_H

#include <jni.h>
#include <utils/android_debug.h>
#include <sys/types.h>
#include <assert.h>

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_log(
        JNIEnv *env,
        jobject obj);

#endif //LIBRARYNATIVE_ENTRYPOINT_H
