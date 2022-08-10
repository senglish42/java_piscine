package ex03;

import java.util.UUID;

public interface TransactionsList
{
    void addTransaction(Transaction transaction);
    void removeTransaction(UUID id);
    Transaction[] toArray();
    int getSize();
    void getCurrentInfo();
    void getLastInfo();
    void getListInfo();
}
