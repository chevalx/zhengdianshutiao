# 表示源文件在project中的位置
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
#该模块名字
LOCAL_MODULE := hello
#源文件位置，每个源文件以空格分隔
LOCAL_SRC_FILES := hello.c
LOCAL_LDFLAGS := -static
include $(BUILD_EXECUTABLE)