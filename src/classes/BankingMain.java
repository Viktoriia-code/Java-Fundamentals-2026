package classes;

public class BankingMain {
    public static void main(String[] args) {
        Account myAccount;
        myAccount = new Account(1000, 1234);
        System.out.println("Initial balance: " + myAccount.getBalance());

        myAccount.deposit(500);
        System.out.println("Balance after deposit: " + myAccount.getBalance());

        myAccount.withdraw(200, 1234);
        System.out.println("Balance after withdrawal: " + myAccount.getBalance());
    }
}