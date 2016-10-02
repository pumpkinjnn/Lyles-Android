package grinnell.appdev.edu.lyles.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import grinnell.appdev.edu.lyles.R;

/**
 * Contributors:
 *  Mattori Birnbaum
 *  Matt Murphy
 */
public class MenuFragment extends Fragment {

    private FragmentTabHost menuHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_layout, container, false);

        // create and setup tabHost
        menuHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        menuHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        // create tabs and add to menuHost
        addToTabHost("Hot Food",  1, HotFoodFragment.class);
        addToTabHost("Snacks",    2, SnacksFragment.class);
        addToTabHost("Drinks",    3, DrinksFragment.class);
        addToTabHost("Favorites", 4, FavoriteFoodFragment.class);

        //TODO: change text size in tab views

        return menuHost;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void addToTabHost(String tabName, int num, Class fragmentClass) {
        Bundle bundle = new Bundle();
        bundle.putInt(tabName + " Tab", num);
        menuHost.addTab(menuHost.newTabSpec(tabName).setIndicator(tabName),
                fragmentClass, bundle);
    }
}
