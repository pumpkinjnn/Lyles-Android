package grinnell.appdev.edu.lyles;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import grinnell.appdev.edu.lyles.fragments.BeerFragment;
import grinnell.appdev.edu.lyles.fragments.FavoritesFragment;
import grinnell.appdev.edu.lyles.fragments.MenuFragment;
import grinnell.appdev.edu.lyles.fragments.ScheduleFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set toolbar as the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);

        //Enable navigation drawer buttons
        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //Set "checked" highlight
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                //Close the drawer when an item is selected
                drawer.closeDrawers();

                Fragment newFrag;

                //Choose the new fragment based on which item is chosen
                switch(item.getItemId()) {
                    case R.id.schedule:
                        Log.d("nav", "Schedule selected from nav");
                        newFrag = new ScheduleFragment();
                        break;
                    case R.id.menu:
                        Log.d("nav", "Menu selected from nav");
                        newFrag = new MenuFragment();
                        break;
                    case R.id.beer:
                        Log.d("nav", "Beer selected from nav");
                        newFrag = new BeerFragment();
                        break;
                    case R.id.favorites:
                        Log.d("nav", "Favorites selected from nav");
                        newFrag = new FavoritesFragment();
                        break;
                    default:
                        Log.d("nav", "Invalid nav option selected (" + item.getItemId() + ")");
                        Toast.makeText(getApplicationContext(), "Invalid nav option selected (" + item.getItemId() + ")", Toast.LENGTH_LONG).show();
                        return false;
                }

                //Replace the content fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, newFrag).commit();
                return true;
            }
        });

        //Create the drawer toggle button
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
}
