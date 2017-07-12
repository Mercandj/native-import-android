#include <jni.h>

#ifndef LIBRARYNATIVE_ENTRYPOINT_H
#define LIBRARYNATIVE_ENTRYPOINT_H

#ifdef __cplusplus
extern "C" {
#endif

#include <sys/types.h>
#include <assert.h>

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_staticLog(
        JNIEnv *,
        jclass);

JNIEXPORT jstring JNICALL Java_com_mercandalli_android_sdk_library_Library_log(
        JNIEnv *,
        jobject);

#ifdef __cplusplus
}
#endif
#endif
