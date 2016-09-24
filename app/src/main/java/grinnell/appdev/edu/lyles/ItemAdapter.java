package grinnell.appdev.edu.lyles;

import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by mattmurphy on 9/11/16.
 *
 * General adapter to be used by beer, drinks, favoritefood, hotfood, menu and snacks fragments
 * adapter contains image, and description of catelog item
 */
public class ItemAdapter extends ArrayAdapter<Picture> {
    public ItemAdapter (Context context, int resource) {
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
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.menu_list_item, parent, false);
        }

        return convertView;
    }
}
