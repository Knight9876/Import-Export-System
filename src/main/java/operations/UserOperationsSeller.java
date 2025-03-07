package operations;

import models.SellerUpdateDelete;

public interface UserOperationsSeller {
    boolean updateSeller(SellerUpdateDelete seller);
    boolean deleteSeller(String portId);
}
