package linkedinlearning.cucumber;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    List<RestaurantMenuItem> menu = new ArrayList<>();

    public void addMenuItem(RestaurantMenuItem item) {
        if (doesItemExist(item)) {
            throw new IllegalArgumentException("Duplicated Item!");
        } else {
            menu.add(item);
        }
    }

    public boolean doesItemExist(RestaurantMenuItem newItem) {
        for (RestaurantMenuItem item: menu) {
            if (item.equals(newItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "menu=" + menu +
                '}';
    }
}
