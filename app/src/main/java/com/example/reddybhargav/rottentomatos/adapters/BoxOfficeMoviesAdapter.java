package com.example.reddybhargav.rottentomatos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reddybhargav.rottentomatos.R;
import com.example.reddybhargav.rottentomatos.model.BoxOfficeMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by reddybhargav on 11/15/14.
 */
public class BoxOfficeMoviesAdapter extends ArrayAdapter<BoxOfficeMovie>{

    private final Context mContext;

    public BoxOfficeMoviesAdapter(Context context,ArrayList<BoxOfficeMovie> aMovies){
        super(context,0,aMovies);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BoxOfficeMovie movie = getItem(position);
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_box_office_movie,parent,false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvCriicScore = (TextView) convertView.findViewById(R.id.tvCriticScore);
        TextView tvCastList = (TextView) convertView.findViewById(R.id.tvCastList);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);
        tvTitle.setText(movie.getTitle());
        tvCriicScore.setText(String.valueOf(movie.getCriticsScore()));
        tvCastList.setText(movie.getCastList());

        Picasso.with(getContext()).load(movie.getPosterUrl()).into(ivPosterImage);
        return convertView;
    }
}
