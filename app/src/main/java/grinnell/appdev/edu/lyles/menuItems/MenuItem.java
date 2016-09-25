package grinnell.appdev.edu.lyles.menuItems;

/**
 * Created by mattmurphy on 9/25/16.
 */

public interface MenuItem {

    String getName();

    String getDescription();

    void setName(String name);

    void setDescription(String description);

    double getPrice();

    void setPrice(double price);

    String getImageResource();

}
