package exampe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The class creates an Inventory
 *
 * @author malex
 */
public class CreateInventoryUtil {

    public static Inventory createInventory(String name, String priceInString, float price) {
        return new Inventory(name, priceInString, price);
    }

    public static List<String> generateList(String... names) {
        return new ArrayList<>(Arrays.asList(names));
    }

    /**
     * Custom comparator:
     * sort: A_Z or Z_A
     * sort: 0_9 or 9_0
     */
    public static Comparator<Inventory> createComparator(String compare) {
        return (obj1, obj2) -> {

            int comp = obj1.getPriceInString().compareTo(obj2.getPriceInString());

            switch (compare) {
                case "ALPH_A_Z":
                    comp = obj1.getName().compareTo(obj2.getName());
                    if (comp == 0) {
                        return -1;
                    }
                    break;
                case "ALPH_Z_A":
                    comp = -obj1.getName().compareTo(obj2.getName());
                    if (comp == 0) {
                        return -1;
                    }
                    break;
                case "PRICE_HIGH":
                    if (obj1.getPrice() < obj2.getPrice()) {
                        comp = 1;
                    } else {
                        comp = -1;
                    }
                    break;
                case "PRICE_LOW":
                    comp = (obj1.getPrice() < obj2.getPrice()) ? -1 : 1;
                    break;
            }

            return comp;
        };

    }

}
