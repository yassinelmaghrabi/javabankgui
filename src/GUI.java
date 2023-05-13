import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends GUI2{
    private JTextField Phonenumber;
    private JButton registerButton;
    private JPanel panel1;
    private JTextField Name;
    private JTextField Password;
    public void updatestring(Account account){
        toString.setText(account.toString());
    }

    public GUI(){
        Account account=new Account();
        setContentPane(panel1);
        setTitle("Bank by Yassin Elmaghrabi");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.gray);



        setVisible(true);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account.set_first_name(Name.getText());
                account.set_phone_number(Phonenumber.getText());
                account.set_password(Password.getText());
                System.out.println(account.toString());
                setContentPane(panel2);
                Welcome.setText("Welcome, "+Name.getText());
                setSize(750,400);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setBackground(Color.lightGray);
                updatestring(account);
                setVisible(true);

            }
        });
        depositebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            account.deposit_balance(Double.parseDouble(deposit_amount.getText()));
            updatestring(account);
            JOptionPane.showMessageDialog(null, "You have deposited: "+deposit_amount.getText()+"\n New Balance: "+account.get_balance(), "InfoBox: " + "Deposit successful", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        withdrawbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            account.withdraw_balance(Double.parseDouble(withdraw_amount.getText()));
            updatestring(account);
            JOptionPane.showMessageDialog(null, "You have withdrawn: "+withdraw_amount.getText()+"\nplease take your money and credit card."+"\n New Balance: "+account.get_balance(), "InfoBox: " + "Withdraw successful", JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }
}
