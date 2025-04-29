import java.util.Scanner;

class Account {
    private int acc_no;
    private String name;
    private int pin;
    private double balance;

    public Account(int acc_no, String name, int pin, double balance) {
        this.acc_no = acc_no;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public String showName() {
        return this.name;
    }

    public boolean checkPin(int inputPin) {
        return this.pin == inputPin;
    }

    public int getAccNo() {
        return acc_no;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void depositMoney(double amount) {
        if (amount > 0 && amount % 100 == 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance && amount % 100 == 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    public void changePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = {
            new Account(210905, "Jasaman Singh", 2109, 10000.0),
            new Account(654321, "Jai Vishun", 4321, 2000.0),
            new Account(111222, "Johit", 1111, 500.0),
            new Account(121212, "Kamlesh Kumar", 1212, 500.0)
        };
        System.out.print("Enter Account Number: ");
        int inputAccNo = sc.nextInt();
        System.out.print("Enter PIN: ");
        int inputPin = sc.nextInt();
        Account acc = null;
        for (Account a : accounts) {
            if (a.getAccNo() == inputAccNo && a.checkPin(inputPin)) {
                acc = a;
                break;
            }
        }
        if (acc == null) {
            System.out.println("Incorrect account number or PIN. Exiting.");
            sc.close();
            return;
        }

        System.out.println("Account Holder: "+ acc.showName());

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    acc.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.depositMoney(dep);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    acc.withdrawMoney(wd);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();
                    acc.changePin(oldPin, newPin);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}