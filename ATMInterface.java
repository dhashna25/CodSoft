import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface
{
private JFrame frame;
private JLabel balanceLabel;
private JTextField depositField;
private JTextField withdrawField;
private double balance = 1000.0;
public ATMInterface() {
frame = new JFrame("ATM Interface");
frame.setSize(400, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new GridLayout(4, 2));
balanceLabel = new JLabel("Current Balance: $" + balance);
frame.add(balanceLabel);
JLabel depositLabel = new JLabel("Deposit Amount:");
frame.add(depositLabel);
depositField = new JTextField();
frame.add(depositField);
JButton depositButton = new JButton("Deposit");
depositButton.addActionListener(new DepositListener());
frame.add(depositButton);
JLabel withdrawLabel = new JLabel("Withdraw Amount:");
frame.add(withdrawLabel);
withdrawField = new JTextField();
frame.add(withdrawField);
JButton withdrawButton = new JButton("Withdraw");
withdrawButton.addActionListener(new WithdrawListener());
frame.add(withdrawButton);
frame.setVisible(true);
}
private class DepositListener implements ActionListener 
{
public void actionPerformed(ActionEvent e) 
{
try 
{
double depositAmount = Double.parseDouble(depositField.getText());
if (depositAmount > 0) 
{
balance += depositAmount;
balanceLabel.setText("Current Balance: $" + balance);
JOptionPane.showMessageDialog(frame, "$" + depositAmount + " deposited successfully.");
}
else 
{
JOptionPane.showMessageDialog(frame, "Invalid deposit amount.");
}
}
catch (NumberFormatException ex) 
{
JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
}
depositField.setText("");
}
}

private class WithdrawListener implements ActionListener 
{
public void actionPerformed(ActionEvent e) 
{
try 
{
double withdrawAmount = Double.parseDouble(withdrawField.getText());
if (withdrawAmount > 0 && withdrawAmount <= balance) 
{
balance -= withdrawAmount;
balanceLabel.setText("Current Balance: $" + balance);
JOptionPane.showMessageDialog(frame, "$" + withdrawAmount + " withdrawn successfully.");
} 
else if (withdrawAmount <= 0) 
{
JOptionPane.showMessageDialog(frame, "Invalid withdrawal amount.");
}
else
{
JOptionPane.showMessageDialog(frame, "Insufficient funds.");
}
}
catch (NumberFormatException ex) {
JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
}
withdrawField.setText("");
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
new ATMInterface();
}
});
}
}