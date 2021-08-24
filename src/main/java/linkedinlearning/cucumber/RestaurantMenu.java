package linkedinlearning.cucumber;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    List<RestaurantMenuItem> menu = new ArrayList<>();

    public void addMenuItem(RestaurantMenuItem item) {
        menu.add(item);
    }

    public boolean contains(RestaurantMenu item) {
        return menu.contains(item);
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "menu=" + menu +
                '}';
    }
}
