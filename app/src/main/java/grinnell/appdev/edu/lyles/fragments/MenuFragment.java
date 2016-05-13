package grinnell.appdev.edu.lyles.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import grinnell.appdev.edu.lyles.R;

/**
 * Created by Mattori on 5/9/16.
 */
public class MenuFragment extends Fragment {

    private FragmentTabHost menuHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_layout, container, false);

        // create and setup tabHost
        menuHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        menuHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        // hot food
        Bundle hotFoodBundle = new Bundle();
        hotFoodBundle.putInt("Hot Food Tab", 1);
        menuHost.addTab(menuHost.newTabSpec("Hot Food").setIndicator("Hot Food"),
                HotFoodFragment.class, hotFoodBundle);

        // snacks
        Bundle snackBundle = new Bundle();
        snackBundle.putInt("Snack Tab", 2);
        menuHost.addTab(menuHost.newTabSpec("Snacks").setIndicator("Snacks"),
                SnacksFragment.class, snackBundle);

        // drinks
        Bundle drinkBundle = new Bundle();
        snackBundle.putInt("Drink Tab", 2);
        menuHost.addTab(menuHost.newTabSpec("Drinks").setIndicator("Drinks"),
                DrinksFragment.class, drinkBundle);

        // Favorites
        Bundle favoriteBundle = new Bundle();
        snackBundle.putInt("Favorite Tab", 2);
        menuHost.addTab(menuHost.newTabSpec("Favorite").setIndicator("Favorite"),
                FavoriteFoodFragment.class, favoriteBundle);

        return menuHost;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
