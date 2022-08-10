package ex04;

import java.util.UUID;

public class Transaction
{
    private UUID id;
    private User recipient;
    private User sender;
    private typeCategory category;
    private typeResult result;
    private int amount;
    private int rcpnt_amnt_bfr_trnsct;
    private int rcpnt_amnt_aft_trnsct;
    private int sndr_amnt_bfr_trnsct;
    private int sndr_amnt_aft_trnsct;
    private enum typeCategory
    {
        debits,
        credits
    }
    private enum typeResult
    {
        failure,
        success
    }
    public Transaction(User sender, User recipient, int amount) throws IllegalTransactionException
    {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.rcpnt_amnt_bfr_trnsct = recipient.getBalance();
        this.rcpnt_amnt_aft_trnsct = recipient.getBalance();
        this.sndr_amnt_bfr_trnsct = sender.getBalance();
        this.sndr_amnt_aft_trnsct = sender.getBalance();
        this.amount = amount;
        this.category = typeCategory.credits;
        make_transaction();
        this.sender.getTransaction().addTransaction(new Transaction(this, typeCategory.credits));
        this.recipient.getTransactions().addTransaction(new Transaction(this, typeCategory.debits));
    }
    public Transaction(Transaction transaction, typeCategory category)
    {
        this.id = transaction.id;
        this.sender = transaction.sender;
        this.recipient = transaction.recipient;
        this.rcpnt_amnt_bfr_trnsct = transaction.rcpnt_amnt_bfr_trnsct;
        this.rcpnt_amnt_aft_trnsct = transaction.rcpnt_amnt_aft_trnsct;
        this.sndr_amnt_bfr_trnsct = transaction.sndr_amnt_bfr_trnsct;
        this.sndr_amnt_aft_trnsct = transaction.sndr_amnt_aft_trnsct;
        this.amount = transaction.amount;
        this.category = category;
        this.result = transaction.result;
    }
    private void make_transaction() throws IllegalTransactionException
    {
        this.result = typeResult.failure;
        if (this.sender.getBalance() < this.amount)
            throw new IllegalTransactionException();
        sender.cutBalance(this.amount);
        recipient.addBalance(this.amount);
        this.sndr_amnt_aft_trnsct = sender.getBalance();
        this.rcpnt_amnt_aft_trnsct = recipient.getBalance();
        this.result = typeResult.success;
    }
    public UUID getUUID()
    {
        return this.id;
    }
    public int getAmount()
    {
        return this.amount;
    }
    public void getSenderInfo()
    {
        this.sender.getInfo();
    }
    public void getReceipientInfo()
    {
        this.recipient.getInfo();
    }
    public typeCategory getCategory()
    {
        return this.category;
    }
    public typeResult getResult()
    {
        return this.result;
    }
    public void getInfo()
    {
        System.out.println("Transaction ID: " + this.getUUID());
        System.out.println("Sender's name: " + this.sender.getName());
        System.out.println("Sender's amount before transaction: " + this.sndr_amnt_bfr_trnsct);
        System.out.println("Recipient's name: " + this.recipient.getName());
        System.out.println("Recipient's amount before transaction: " + this.rcpnt_amnt_bfr_trnsct);
        System.out.println("Transaction type: " + this.getCategory());
        System.out.println("Transaction amount: " + this.getAmount());
        System.out.println("Transaction status: " + this.getResult());
        System.out.println("Sender's amount after transaction: " + this.sndr_amnt_aft_trnsct);
        System.out.println("Recipient's amount after transaction: " + this.rcpnt_amnt_aft_trnsct);
    }
    public User getSender()
    {
        return this.sender;
    }
    public User getRecipient()
    {
        return this.recipient;
    }
}
