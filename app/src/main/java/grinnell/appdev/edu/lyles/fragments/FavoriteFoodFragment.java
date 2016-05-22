package grinnell.appdev.edu.lyles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import grinnell.appdev.edu.lyles.R;

/**
 * A fragment to display favorited foods by user
 */
public class FavoriteFoodFragment extends Fragment {


    public FavoriteFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_food, container, false);
    }

}
