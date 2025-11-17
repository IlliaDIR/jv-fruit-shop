package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (String s : report) {
            if (s.equals(HEADER)) {
                continue;
            }
            String[] split = s.split(",");
            String operation = split[OPERATION_INDEX];
            String fruit = split[FRUIT_INDEX];
            int quantity = Integer.parseInt(split[QUANTITY_INDEX]);
            FruitTransaction transaction = new FruitTransaction(operation,
                    fruit, quantity);
            transactionsList.add(transaction);
        }
        return transactionsList;
    }
}
