package grinnell.appdev.edu.lyles.slidingtab;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import grinnell.appdev.edu.lyles.R;

/**
 * A {@code SlidingTabLayout.TabColorizer} to display the correct color for {@code SlidingTabLayout}
 *
 * Created by Mattori on 9/29/16.
 */

public class MenuTabColorizer implements SlidingTabLayout.TabColorizer {

    private Context mContext;

    public MenuTabColorizer(Context ctxt) {
        mContext = ctxt;
    }

    @Override
    public int getIndicatorColor(int pos) {
        return ContextCompat.getColor(mContext, R.color.tabsScrollColor);
    }
}
