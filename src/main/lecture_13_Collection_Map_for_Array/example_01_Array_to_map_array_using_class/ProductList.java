package example_01_Array_to_map_array_using_class;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductList implements Constants {

    private List<Map<String, String>> listProducts;
    private Map<String, String> productMap;


    public ProductList() {
        listProducts = new ArrayList<>();
    }


    public void addProduct(Product product) {

        productMap = new HashMap<>();

        productMap.put(NAME_PRODUCT, product.getName());

        listProducts.add(productMap);

    }

    public void show() {

        for (Map<String, String> iter : listProducts) {
            System.out.println(iter);
        }
    }


}
