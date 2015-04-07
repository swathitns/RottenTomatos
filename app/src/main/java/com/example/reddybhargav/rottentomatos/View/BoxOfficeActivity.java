package com.example.reddybhargav.rottentomatos.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.reddybhargav.rottentomatos.R;
import com.example.reddybhargav.rottentomatos.adapters.BoxOfficeMoviesAdapter;
import com.example.reddybhargav.rottentomatos.model.BoxOfficeMovie;
import com.example.reddybhargav.rottentomatos.network.RottenTomatoesClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by reddybhargav on 11/15/14.
 */
public class BoxOfficeActivity  extends Activity{

    private ListView mLvMovies;
    private BoxOfficeMoviesAdapter mMovieAdapter;
    RottenTomatoesClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office);

        mLvMovies =(ListView)findViewById(R.id.lvMovies);
        ArrayList<BoxOfficeMovie> movieList = new ArrayList<BoxOfficeMovie>();

        mMovieAdapter = new BoxOfficeMoviesAdapter(this,movieList);
        mLvMovies.setAdapter(mMovieAdapter);

        fetchBoxOfficeMovies();
    }

    private void fetchBoxOfficeMovies() {
        mClient = new RottenTomatoesClient();
        mClient.getBoxOfficeMovies(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int code,JSONObject body) {
                JSONArray items = null;
                try {
                    items = body.getJSONArray("movies");
                    ArrayList<BoxOfficeMovie> movies = BoxOfficeMovie.fromJson(items);

                    for(BoxOfficeMovie movie:movies){
                        mMovieAdapter.add(movie);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


}
