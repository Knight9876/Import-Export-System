package operations;

import models.SellerProduct;
import java.util.List;

public interface SellerProductOperations {
    boolean addProduct(SellerProduct product);
    boolean updateProduct(SellerProduct product);
    boolean deleteProduct(int productId, int sellerId);
    List<SellerProduct> getSellerProducts(int sellerId);
}
