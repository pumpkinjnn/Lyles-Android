package grinnell.appdev.edu.lyles.menuItems;

/**
 * Model beer item. Contains
 */
public class BeerItem {

    private String mName;
    private String mDescription;

    public BeerItem() {
        mName = null;
        mDescription = null;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
