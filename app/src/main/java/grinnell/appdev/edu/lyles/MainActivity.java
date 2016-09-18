package grinnell.appdev.edu.lyles;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import grinnell.appdev.edu.lyles.fragments.BeerFragment;
import grinnell.appdev.edu.lyles.fragments.MenuFragment;
import grinnell.appdev.edu.lyles.fragments.ScheduleFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFragmentContainer((BottomBar) findViewById(R.id.bottombar));
    }

    private void setupFragmentContainer(BottomBar bar) {
        bar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment newFrag;
                switch(tabId) {
                    case R.id.tab_schedule: newFrag = new ScheduleFragment(); break;
                    case R.id.tab_menu: newFrag = new MenuFragment(); break;
                    case R.id.tab_beer: newFrag = new BeerFragment(); break;
                    default: newFrag = new ScheduleFragment(); // something went wrong
                }
                changeFragment(newFrag);
            }
        });
    }

    private void changeFragment(Fragment target) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, target);
        transaction.commit();
    }
}
