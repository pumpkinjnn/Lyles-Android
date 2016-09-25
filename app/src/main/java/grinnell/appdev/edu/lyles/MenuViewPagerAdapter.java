package grinnell.appdev.edu.lyles;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import grinnell.appdev.edu.lyles.fragments.DrinksFragment;
import grinnell.appdev.edu.lyles.fragments.FavoritesFragment;
import grinnell.appdev.edu.lyles.fragments.HotFoodFragment;
import grinnell.appdev.edu.lyles.fragments.SnacksFragment;

/**
 * Created by Mattori on 9/25/16.
 */
public class MenuViewPagerAdapter extends FragmentStatePagerAdapter {

    public MenuViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * The number of tabs in the menu
     */
    private static final int NUM_TABS = 4;

    /**
     * Determines which tab to show
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return new HotFoodFragment();
            case 1: return new SnacksFragment();
            case 2: return new DrinksFragment();
            case 3: return new FavoritesFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
