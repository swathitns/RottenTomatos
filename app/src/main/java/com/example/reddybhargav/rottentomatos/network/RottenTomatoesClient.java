package com.example.reddybhargav.rottentomatos.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by reddybhargav on 11/15/14.
 */
public class RottenTomatoesClient {

    private final String API_KEY ="98fkm87vdapqmbm75kphrd6z";
    private final String API_BASE_URL ="http://api.rottentomatoes.com/api/public/v1.0/";
    private AsyncHttpClient mClient;

    public RottenTomatoesClient(){
        this.mClient = new AsyncHttpClient();

    }

    private String getApiUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }

    public void getBoxOfficeMovies(JsonHttpResponseHandler handler){
        String url = getApiUrl("lists/movies/box_office.json");
        RequestParams params = new RequestParams("apikey",API_KEY);
        params.put("limit","20");
        mClient.get(url,params,handler);

    }
}
