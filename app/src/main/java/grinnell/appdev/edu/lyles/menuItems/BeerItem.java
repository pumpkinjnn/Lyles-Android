package grinnell.appdev.edu.lyles.menuItems;

/**
 * Model beer item. Contains information on beer name and beer description
 */
public class BeerItem implements MenuItem {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {

    }

    // TODO: gather image resources from beer name
    // completed from switch statement on possible names
    public String getImageResource() {
        String resName = null;

        return resName;
    }

}
