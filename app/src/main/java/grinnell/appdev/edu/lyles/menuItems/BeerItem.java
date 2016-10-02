package grinnell.appdev.edu.lyles.menuItems;

/**
 * Model beer item. Contains information on beer name and beer description
 */
public class BeerItem implements OrderItem {

    String mName;
    String mDescription;
    double mPrice;

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

    public double getPrice() {
        return mPrice;
    }

    @Override
    public void setPrice(double price) {
        mPrice = price;
    }

    // TODO: gather image resources from beer name
    // completed from switch statement on possible names
    public String getImageResource() {
        String resName = null;

        return resName;
    }

}
