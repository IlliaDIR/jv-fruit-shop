package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new NullPointerException("The transaction list can't be null.");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new NullPointerException("Transaction is null, can't be processed.");
            }
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
