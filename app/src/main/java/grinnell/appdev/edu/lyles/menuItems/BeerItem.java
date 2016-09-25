package grinnell.appdev.edu.lyles.menuItems;

/**
 * Model beer item. Contains information on beer name and beer description
 */
public class BeerItem {

    private String mName;
    private String mDescription;
    private double mPrice;

    public BeerItem() {
        mName = null;
        mDescription = null;
        mPrice = 0.00;
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

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(float price) {
        mPrice = price;
    }

    // TODO: gather image resources from beer name
    // completed from switch statement on possible names
    public String getImageResource() {

    }

}
