package grinnell.appdev.edu.lyles.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import grinnell.appdev.edu.lyles.MenuViewPagerAdapter;
import grinnell.appdev.edu.lyles.R;
import grinnell.appdev.edu.lyles.slidingtab.MenuTabColorizer;
import grinnell.appdev.edu.lyles.slidingtab.SlidingTabLayout;

/**
 * Contributors:
 *  Mattori Birnbaum
 *  Matt Murphy
 */
public class MenuFragment extends Fragment {
    private FragmentTabHost menuHost;

    public MenuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_layout, container, false);

        setupViewPager(view);

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

    private void setupViewPager(View view) {
        MenuViewPagerAdapter adapter = new MenuViewPagerAdapter(getFragmentManager());
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        SlidingTabLayout tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new MenuTabColorizer(getContext()));
    }
}
