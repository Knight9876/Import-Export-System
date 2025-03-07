package operations;

import models.ConsumerUpdateDelete;

public interface UserOperationsConsumer {
    boolean updateConsumer(ConsumerUpdateDelete consumer);
    boolean deleteConsumer(String portId);
}
