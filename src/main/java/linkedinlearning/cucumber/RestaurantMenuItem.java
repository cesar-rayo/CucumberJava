package linkedinlearning.cucumber;

import java.util.Objects;

public class RestaurantMenuItem {
    private String itemName;
    private String description;
    private int price;

    public RestaurantMenuItem(String itemName, String description, int price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantMenuItem that = (RestaurantMenuItem) o;
        return price == that.price && Objects.equals(itemName, that.itemName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, description, price);
    }

    @Override
    public String toString() {
        return "{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
