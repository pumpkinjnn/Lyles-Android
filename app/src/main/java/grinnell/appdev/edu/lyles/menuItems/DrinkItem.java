package grinnell.appdev.edu.lyles.menuItems;

/**
 * Created by mattmurphy on 9/25/16.
 */

public class DrinkItem {

    private String mName;
    private String mDescription;

    public DrinkItem() {
        mName = null;
        mDescription = null;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
