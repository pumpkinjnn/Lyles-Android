package grinnell.appdev.edu.lyles.adapters;

import android.content.Context;
import android.graphics.Picture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import grinnell.appdev.edu.lyles.MainActivity;
import grinnell.appdev.edu.lyles.R;
import grinnell.appdev.edu.lyles.menuItems.BeerItem;

/**
 * Created by mattmurphy on 9/11/16.
 *
 * General adapter to be used by beer, drinks, favoritefood, hotfood, menu and snacks fragments
 * adapter contains image, and description of catelog item
 */
public class BeerAdapter extends ArrayAdapter<BeerItem> {
    private static final String TAG = ArrayAdapter.class.getSimpleName();

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

        BeerItem beer = BeerAdapter.super.getItem(pos);

        if (beer != null) {
            Log.d("beer", "Beer item is not null");
            ImageView beerImage = (ImageView) convertView.findViewById(R.id.beer_image);
            // TODO: figure out how to set beer images
            // beerImage.setImageDrawable((drawable) beer.getImageResource());

            TextView  beerName  = (TextView)  convertView.findViewById(R.id.beer_name);
            beerName.setText(beer.getName());

            TextView  beerType  = (TextView)  convertView.findViewById(R.id.beer_type);
            beerType.setText(beer.getDescription());
        }

        return convertView;
    }
}
