package grinnell.appdev.edu.lyles;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import grinnell.appdev.edu.lyles.fragments.DrinksFragment;
import grinnell.appdev.edu.lyles.fragments.FavoritesFragment;
import grinnell.appdev.edu.lyles.fragments.HotFoodFragment;
import grinnell.appdev.edu.lyles.fragments.SnacksFragment;

/**
 * A {@code FragmentStatePagerAdapter} to handle the display of the various {@code Fragment}s,
 * dispatching the correct {@code Fragment} and title name.
 *
 * Created by Mattori on 9/25/16.
 */
public class MenuViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final int HOT_FOOD_INDEX = 0;
    private static final int SNACKS_INDEX = 1;
    private static final int DRINKS_INDEX = 2;
    private static final int FAVORITES_INDEX = 3;
    private static final int NUM_TABS = 4;

    private final Resources mResources;

    public MenuViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mResources = context.getResources();
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case HOT_FOOD_INDEX: return new HotFoodFragment();
            case SNACKS_INDEX: return new SnacksFragment();
            case DRINKS_INDEX: return new DrinksFragment();
            case FAVORITES_INDEX: return new FavoritesFragment();
            default: return new Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case HOT_FOOD_INDEX: return mResources.getString(R.string.hot_food_tab_title);
            case SNACKS_INDEX: return mResources.getString(R.string.snacks_tab_title);
            case DRINKS_INDEX: return mResources.getString(R.string.drinks_tab_title);
            case FAVORITES_INDEX: return mResources.getString(R.string.favorites_tab_title);
            default: return new String();
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }
}
