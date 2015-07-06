package example_01_Array_to_map_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain_01 {
    public static final String STR = "nameGroup";


    public static void main(String[] args) {
        // List products
        List<Map<String, String>> listProduct = new ArrayList<>();

        // Product
        Map<String, String> product;

        // Array to products
        String[] groups = new String[]{"LG", "Nokia", "Samsung", "HTC"};

        //input
        /**
         * nameGroup -> LG
         * nameGroup -> Nokia
         * nameGroup -> Samsung
         * nameGroup -> HTC
         */


        for (String iter : groups) {
            product = new HashMap<>();
            product.put(STR, iter);
            listProduct.add(product);
        }

        System.out.println("listProduct -> " + listProduct);

    }
}
