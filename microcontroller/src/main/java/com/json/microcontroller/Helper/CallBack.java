package com.json.microcontroller.Helper;

import android.support.annotation.Nullable;

public interface CallBack<T> {
    void onSuccess( T data);
    void onError(@Nullable String errorMsg);
}
