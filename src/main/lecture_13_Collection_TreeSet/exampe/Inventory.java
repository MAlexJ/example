package exampe;

/**
 * Base entity class
 */
public class Inventory {

    /**
     * Name entity
     */
    private String name;

    /**
     * Price in string format
     */
    private String priceInString;

    /**
     * Price in long format
     */
    private float price;

    public Inventory() {
    }

    public Inventory(String name, String priceInString, float price) {
        this.name = name;
        this.priceInString = priceInString;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceInString() {
        return priceInString;
    }

    public void setPriceInString(String priceInString) {
        this.priceInString = priceInString;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + name +
                ", \'" + priceInString + '\'' +
                ", " + price +
                '}';
    }
}
