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

    int withdraw(int amount, int tryPin) {
        if(amount>0 && tryPin == this.pin) {
            if (amount <= balance) {
                balance -= amount;
            } else if (amount > balance) {
                balance = 0;
            }
        }
        return balance;
    }

    void changePIN(int oldPin, int newPin) {

    }
}
