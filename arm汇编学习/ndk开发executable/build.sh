#!/bin/bash

~/Android/Sdk/ndk/23.0.7599858/ndk-build NDK_PROJECT_PATH=. NDK_APPLICATION_MK=Application.mk APP_BUILD_SCRIPT=Android.mk
adb push libs/arm64-v8a/hello /data/local/tmp