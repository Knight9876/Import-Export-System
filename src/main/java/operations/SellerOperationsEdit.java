package operations;

import models.SellerEdit;

public interface SellerOperationsEdit {
    boolean updateSeller(SellerEdit seller);
    boolean deleteSeller(int portId);
}
