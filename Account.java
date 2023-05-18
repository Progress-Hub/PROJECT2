abstract class Account {
    protected double balance;

    public Account() {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}

class SavingsAccount2 extends Account {
    private static final double WITHDRAWAL_LIMIT = 20000;

    public SavingsAccount2(double balance) {
        super();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal limit exceeded!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
}

class CurrentAccount2 extends Account {
    public CurrentAccount2(double balance) {
        super();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
}
