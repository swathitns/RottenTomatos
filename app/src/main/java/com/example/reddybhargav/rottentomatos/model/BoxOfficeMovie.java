package com.example.reddybhargav.rottentomatos.model;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by reddybhargav on 11/15/14.
 */
public class BoxOfficeMovie {
    private String title;
    private int year;
    private String synopsis;
    private String posterUrl;
    private int criticsScore;
    private ArrayList<String> catList;

    public  String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public int getCriticsScore(){
        return criticsScore;
    }

    public String getCastList(){
        return TextUtils.join(",",catList);
    }

    public String getPosterUrl(){
        return  posterUrl;
    }

    public static BoxOfficeMovie fromJson(JSONObject jsonObject){
        BoxOfficeMovie b = new BoxOfficeMovie();
        try {
                b.title = jsonObject.getString("title");
                b.year = jsonObject.getInt("year");
                b.synopsis = jsonObject.getString("synopsis");
                b.posterUrl = jsonObject.getJSONObject("posters").getString("thumbnail");
                b.criticsScore = jsonObject.getJSONObject("ratings").getInt("critics_score");

                b.catList = new ArrayList<String>();
                JSONArray abridgedCast = jsonObject.getJSONArray("abridged_cast");
                for(int i = 0 ;i<abridgedCast.length();i++){
                    b.catList.add(abridgedCast.getJSONObject(i).getString("name"));
                }
        }
             catch(JSONException e) {
                 e.printStackTrace();
        }
        return b;
    }

    public static ArrayList<BoxOfficeMovie> fromJson(JSONArray jsonArray){
        ArrayList<BoxOfficeMovie> movies = new ArrayList<BoxOfficeMovie>(jsonArray.length());
        for(int i = 0 ; i <jsonArray.length();i++){
            JSONObject movieObject = null;
            try{
                movieObject = jsonArray.getJSONObject(i);
            }catch(Exception e){
                e.printStackTrace();
            }

            BoxOfficeMovie movie = BoxOfficeMovie.fromJson(movieObject);
            if(movie != null){
                movies.add(movie);
            }
        }
        return movies;
    }

}

