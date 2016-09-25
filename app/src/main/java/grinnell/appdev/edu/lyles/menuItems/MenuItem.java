package grinnell.appdev.edu.lyles.menuItems;

/**
 * Created by mattmurphy on 9/25/16.
 */

public interface MenuItem {

    public String getName();

    public String getDescription();

    public void setName(String name);

    public void setDescription(String description);

    public double getPrice();

    public void setPrice(double price);

}
