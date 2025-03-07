package operations;

import models.SellerOrder;
import java.util.List;

public interface SellerOrderOperations {
    List<SellerOrder> getOrdersBySellerId(int sellerId);
}
