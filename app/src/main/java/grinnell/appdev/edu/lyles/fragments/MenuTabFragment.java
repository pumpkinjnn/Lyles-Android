package grinnell.appdev.edu.lyles.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import grinnell.appdev.edu.lyles.MenuTabListAdapter;
import grinnell.appdev.edu.lyles.R;

import static grinnell.appdev.edu.lyles.MenuViewPagerAdapter.DRINKS_INDEX;
import static grinnell.appdev.edu.lyles.MenuViewPagerAdapter.HOT_FOOD_INDEX;
import static grinnell.appdev.edu.lyles.MenuViewPagerAdapter.SNACKS_INDEX;

/**
 * A fragment to display available drinks to users
 */
public class MenuTabFragment extends Fragment {

    public final int position;

    public MenuTabFragment() {
        this.position = -1;
    }

    @SuppressLint("ValidFragment")
    public MenuTabFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menutab, container, false);
        ListView list = (ListView) view.findViewById(R.id.menutab_list);

        try {
            URL url;
            switch (this.position) {
                case HOT_FOOD_INDEX:
                    url = new URL("http://www.cs.grinnell.edu/~birnbaum/appdev/lyles/hotfood.json");
                    break;
                case SNACKS_INDEX:
                    url = new URL("http://www.cs.grinnell.edu/~birnbaum/appdev/lyles/snacks.json");
                    break;
                case DRINKS_INDEX:
                    url = new URL("http://www.cs.grinnell.edu/~birnbaum/appdev/lyles/drinks.json");
                    break;
                default:
                    Log.d("error","unexpected position "+position);
                    return view;
            }

            /* todo: I refuse to believe that there is not a better way to do this */
            InputStream is = url.openConnection().getInputStream();
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String str;
            while((str = reader.readLine()) != null) buffer.append(str);
            reader.close();
            is.close();

            JSONObject jo = new JSONObject(buffer.toString());
            JSONArray ja;
            switch (this.position) {
                case HOT_FOOD_INDEX:
                    ja = jo.getJSONArray("hotfood");
                    break;
                case DRINKS_INDEX:
                    ja = jo.getJSONArray("drinks");
                    break;
                case SNACKS_INDEX:
                    ja = jo.getJSONArray("snacks");
                    break;
                default:
                    /* this is literally unreachable code but java requires it anyway. thanks java */
                    return view;
            }
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (int i = 0; i < ja.length(); i++) {
                items.add(ja.getJSONObject(i));
            }
            list.setAdapter(new MenuTabListAdapter(getContext(), items));
        } catch (JSONException | IOException e) {
            Log.d("error",e.getMessage());
        }

        return view;
    }
}