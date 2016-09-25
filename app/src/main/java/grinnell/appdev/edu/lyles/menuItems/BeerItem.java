package grinnell.appdev.edu.lyles.menuItems;

/**
 * Model beer item. Contains
 */
public class BeerItem {

    private String mName;
    private String mDescription;
    private int mRating;



    public BeerItem() {
        mName = null;
        mDescription = null;
        mRating = -1;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getRating() {
        return mRating;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setRating(int rating) {
        mRating = rating;
    }
}
