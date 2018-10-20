package com.json.microcontroller.DataManager;

import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.json.microcontroller.Helper.CallBack;
import com.json.microcontroller.Helper.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;


public final class ArrayDataManager {
    private static
    Gson gson =new Gson();


    public static<T> void getJSONArrayData(final Class<T> myClass , String url, final CallBack<ArrayList<T>> callBack ) {


        StringRequest jsonArrayRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response ) {
                ArrayList<T> fromJson =new ArrayList<>();
                try {
                    JSONArray result =new JSONArray(response);

                    for (int i = 0; i < result.length() ; i++) {

                    JSONObject ss=result.getJSONObject(i);
                    Log.d(TAG, "onRespons: "+ss.toString());

                        T item =gson.fromJson(ss.toString(),myClass);
                        fromJson.add(item);


                }
                    callBack.onSuccess(fromJson);

                } catch (JSONException e) {
                    e.printStackTrace();
                    callBack.onError(e.getMessage());
                }

          }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest,"test");

    }
    public static<T> void getJSONArrayData(final Class<T> myClass , String url, final HashMap<String,String> headers, final CallBack<ArrayList<T>> callBack ) {


        StringRequest jsonArrayRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response ) {
                ArrayList<T> fromJson =new ArrayList<>();
                try {
                    JSONArray result =new JSONArray(response);

                    for (int i = 0; i < result.length() ; i++) {

                    JSONObject ss=result.getJSONObject(i);
                    Log.d(TAG, "onRespons: "+ss.toString());

                        T item =gson.fromJson(ss.toString(),myClass);
                        fromJson.add(item);


                }
                    callBack.onSuccess(fromJson);

                } catch (JSONException e) {
                    e.printStackTrace();
                    callBack.onError(e.getMessage());
                }

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
        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest,"test");

    }
    public static<T> void JSONArrayManageData(int Method,String url, @Nullable ArrayList<T> array,  final CallBack<String> callBack){
        final String jsonArray = gson.toJson(array);
        Log.d(TAG, "postJSONARRAY:onSuccess: "+jsonArray);

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
                return jsonArray.getBytes();
            }


        };
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }
    public static<T> void JSONArrayManageData(int Method, String url, @Nullable ArrayList<T> array, final HashMap<String,String> headers, final CallBack<String> callBack){
        final String jsonArray = gson.toJson(array);
        Log.d(TAG, "postJSONARRAY:onSuccess: "+jsonArray);

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
                return jsonArray.getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(stringRequest,"test");
    }
    public static void JSONArrayManageData(int Method, String url, final CallBack<String> callBack){
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
    public static void JSONArrayManageData(int Method, String url, final HashMap<String,String> headers, final CallBack<String> callBack){
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
