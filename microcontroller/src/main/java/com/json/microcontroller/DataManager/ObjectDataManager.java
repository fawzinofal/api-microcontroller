package com.json.microcontroller.DataManager;

import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.json.microcontroller.Helper.CallBack;
import com.json.microcontroller.Helper.MyApplication;

import java.util.HashMap;
import java.util.Map;

public final class ObjectDataManager {
    private static
    Gson gson =new Gson();

    public static <T> void GetJSONObjectData(final Class<T> myClass , String url , final CallBack<T> callBack){
        StringRequest jsonObjectRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    T data =  gson.fromJson(response,myClass);
                    callBack.onSuccess(data);

                }catch (Exception e){
                    callBack.onError(e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());

            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest,"Test");
    }

    public static <T> void GetJSONObjectData(final Class<T> myClass , String url , final HashMap<String,String> headers, final CallBack<T> callBack){
        StringRequest jsonObjectRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                T data =  gson.fromJson(response,myClass);
                callBack.onSuccess(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest,"Test");
    }

    public static <T> void JSONObjectManageData(int Method, String url, @Nullable final T data, final CallBack<String> callBack){
        StringRequest stringRequest =new StringRequest(Method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError {
                return gson.toJson(data).getBytes();
            }

        };
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }

    public static <T> void JSONObjectManageData(int Method, String url, @Nullable final T data, final HashMap<String,String> headers, final CallBack<String> callBack){
        StringRequest stringRequest =new StringRequest(Method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError {
                return gson.toJson(data).getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }

    public static void JSONObjectManageData(int Method, String url, final CallBack<String> callBack){
        StringRequest stringRequest =new StringRequest(Method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }

    public static void JSONObjectManageData(int Method, String url, final HashMap<String,String> headers, final CallBack<String> callBack){
        StringRequest stringRequest =new StringRequest(Method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }


}
