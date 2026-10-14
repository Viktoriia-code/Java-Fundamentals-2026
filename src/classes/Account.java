package classes;

public class Account {
    private int balance;
    private int pin;

    public int getBalance() {
        return balance;
    }

    Account(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    int deposit(int amount) {
        if(amount>0)
            balance += amount;
        return balance;
    }

    int withdraw(int amount, int pin) {
        if(amount>0 && pin == this.pin && amount <= balance)
            balance -= amount;
        return balance;
    }
}
