package com.json.microcontroller.Helper;

import com.android.volley.Request;

public interface Method  {
    int POST = Request.Method.POST;
    int GET =Request.Method.GET;
    int PUT =Request.Method.PUT;
    int DELETE =Request.Method.DELETE;
    int PATCH =  Request.Method.PATCH;
    int TRACE =  Request.Method.TRACE;
    int HEAD =  Request.Method.HEAD;
    int DEPRECATED_GET_OR_POST =  Request.Method.DEPRECATED_GET_OR_POST;
}
