package myStore;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

public interface ProductStockContainer {

    int getProductQuantity(int productId); //aka getStock
    void addProductQuantity(Product product, int quantity);
    void removeProductQuantity(Product product, int quantity);
    int getNumOfProducts();


}
