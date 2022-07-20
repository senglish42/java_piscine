package ex03;

import java.util.UUID;
public class TransactionsLinkedList implements TransactionsList
{
    private Node  head;
    private Node  last;
    private int         size;

    private static class Node {
        public Transaction transaction;
        public Node prev;
        public Node next;

        public Node(Transaction newTransaction, Node newPrev, Node newNext)
        {
            this.transaction = newTransaction;
            this.prev = newPrev;
            this.next = newNext;
        }
    }
    public TransactionsLinkedList()
    {
        this.head = new Node(null, null, null);
        this.last = new Node(null, null, null);
        this.head.next = this.last;
        this.last.prev = this.head;
        this.size = 0;
    }
    public void addTransaction(Transaction transaction)
    {
        Node temp;
        Node new_node;
        temp = this.last;
        new_node = new Node(transaction, temp, null);
        this.last = new_node;
        if (this.size == 0)
            this.head = new_node;
        else
            temp.next = new_node;
//        this.head.next = new Node(transaction, this.head, this.head.next);
        ++this.size;

    }
    public void removeTransaction(UUID id) throws TransactionNotFoundException
    {
        Node current = this.head;
        while (current.next != null)
        {
            if (current.transaction.getUUID().equals(id))
            {
                Node prev = current.prev;
                Node next = current.next;
                if (prev == null)
                    this.head = next;
                 else
                 {
                    prev.next = next;
                    current.prev = null;
                }
                if (next == null)
                    this.last = prev;
                else
                {
                    next.prev = prev;
                    current.next = null;
                }
                --this.size;
                return;
            }
            current = current.next;
        }
        throw new TransactionNotFoundException();
    }
    public Transaction[] toArray()
    {
        Transaction[] array = new Transaction[this.size];
        Node current = this.head;
        for (int count = 0; count < this.size; ++count)
        {
            array[count] = current.transaction;
            current = current.next;
        }
        return array;
    }
    public int getSize()
    {
        return this.size;
    }
    public void getCurrentInfo()
    {
        this.head.transaction.getInfo();
    }
    public void getLastInfo()
    {
        this.last.transaction.getInfo();
    }
    public void getListInfo()
    {
        Node current = this.head;
        while (current != null)
        {
            current.transaction.getInfo();
            current = current.next;
        }
    }
}
