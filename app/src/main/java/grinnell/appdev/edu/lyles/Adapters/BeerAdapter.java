package grinnell.appdev.edu.lyles.adapters;

import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import grinnell.appdev.edu.lyles.R;
import grinnell.appdev.edu.lyles.menuItems.BeerItem;

/**
 * Created by mattmurphy on 9/11/16.
 *
 * General adapter to be used by beer, drinks, favoritefood, hotfood, menu and snacks fragments
 * adapter contains image, and description of catelog item
 */
public class BeerAdapter extends ArrayAdapter<BeerItem> {
    public BeerAdapter(Context context, int resource) {
        super(context, resource);
    }

    /**
     * TODO: set adapter content according to server
     *       learn how to gather information from server
     *
     * item picture
     * item description
     */

    public View getView(int pos, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.beer_list_item, parent, false);
        }

        final BeerItem beer = BeerAdapter.super.getItem(pos);

        if (beer != null) {
            // create references to view items
            // final ImageView beerImage = convertView.findViewById(R.id.beerImage);
        }

        

        return convertView;
    }
}
