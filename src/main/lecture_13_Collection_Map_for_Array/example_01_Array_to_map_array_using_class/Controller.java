package example_01_Array_to_map_array_using_class;


public class Controller {

    public static void main(String[] args) {

        ProductList productList =new ProductList();
        productList.addProduct(new Product("LG"));
        productList.addProduct(new Product("Samsung"));
        productList.addProduct(new Product("Nokia"));
        productList.addProduct(new Product("HTC"));
        productList.addProduct(new Product("LG"));
        productList.show();


    }
}
