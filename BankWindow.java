import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankWindow {
    private JFrame mainFrame;
    private JPanel loginPanel;
    private JPanel accountTypePanel;
    private JPanel transactionPanel;
    private JButton savingsButton;
    private JButton currentButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JTextField amountField;
    private JLabel balanceLabel;

    private Account selectedAccount;

    public BankWindow() {
        prepareGUI();
    }

    private void prepareGUI() {

        mainFrame = new JFrame("Bank Window");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        loginPanel = new JPanel();
        JLabel pinLabel = new JLabel("Enter PIN: ");
        JPasswordField pinField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pin = new String(pinField.getPassword());
                if (pin.equals("5555")) {
                    mainFrame.remove(loginPanel);
                    mainFrame.add(accountTypePanel);
                    mainFrame.revalidate();
                    mainFrame.repaint();
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid PIN!");
                }
            }
        });
        loginPanel.add(pinLabel);
        loginPanel.add(pinField);
        loginPanel.add(loginButton);

        accountTypePanel = new JPanel();
        JLabel accountLabel = new JLabel("Choose account type: ");
        savingsButton = new JButton("Savings");
        savingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAccount = new SavingsAccount2(100000);
                mainFrame.remove(accountTypePanel);
                mainFrame.add(transactionPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        currentButton = new JButton("Current");
        currentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAccount = new CurrentAccount2(100000);
                mainFrame.remove(accountTypePanel);
                mainFrame.add(transactionPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        accountTypePanel.add(accountLabel);
        accountTypePanel.add(savingsButton);
        accountTypePanel.add(currentButton);

        transactionPanel = new JPanel();
        JLabel transactionLabel = new JLabel("Choose transaction type: ");
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountString = amountField.getText();
                double amount = Double.parseDouble(amountString);
                if (selectedAccount instanceof SavingsAccount2 && amount > 20000) {
                    JOptionPane.showMessageDialog(mainFrame, "Savings account withdrawal limit is 20,000");
                } else {
                    selectedAccount.withdraw(amount);
                    updateBalanceLabel();
                }
            }
        });
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountString = amountField.getText();
                double amount = Double.parseDouble(amountString);
                selectedAccount.deposit(amount);
                updateBalanceLabel();
            }
        });
        amountField = new JTextField(10);
        balanceLabel = new JLabel("Balance: 100,000");
        transactionPanel.add(transactionLabel);
        transactionPanel.add(withdrawButton);
        transactionPanel.add(depositButton);
        transactionPanel.add(amountField);
        transactionPanel.add(balanceLabel);

        mainFrame.add(loginPanel);


        mainFrame.setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + selectedAccount.getBalance());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
}

