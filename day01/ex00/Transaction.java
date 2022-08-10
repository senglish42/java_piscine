package ex00;

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
    public Transaction(User sender, User recipient, int amount)
    {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.rcpnt_amnt_bfr_trnsct = recipient.getBalance();
        this.rcpnt_amnt_aft_trnsct = recipient.getBalance();
        this.sndr_amnt_bfr_trnsct = sender.getBalance();
        this.sndr_amnt_aft_trnsct = sender.getBalance();
        this.amount = amount < 0 ? -amount : amount;
        this.category = amount < 0 ? typeCategory.credits : typeCategory.debits;
        make_transaction();
    }
    private void make_transaction()
    {
        this.result = typeResult.failure;
        if (this.sender.getBalance() < this.amount)
            return;
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
}
