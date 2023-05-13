import javax.swing.*;

abstract class User extends Generator{
    public abstract double get_balance();
    public abstract String get_phone_number();
    public abstract String get_credit_card_number();
    public abstract String get_first_name();
    public abstract void deposit_balance(double amount);
    public abstract void withdraw_balance(double amount);
    public abstract void set_balance(double amount);
    public abstract void set_phone_number(String phonenumber);
    public abstract void set_credit_card_number(String credit_card_number);
    public abstract void set_first_name(String first_name);
    public abstract void set_password(String password);
    public abstract String toString();
}
public class Account extends User{
    public static void Errorbox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.WARNING_MESSAGE);
    }
    String password="1111";
    double balance = 0;
    String phonenumber="Unknown";
    String credit_card_number=generate_cc("546616",12);;
    String first_name="Unknown";

    public Account(double balance,String phonenumber,String first_name,String password){
        this.balance = balance;
        this.phonenumber = ("+2"+phonenumber);
        this.first_name=first_name;
        this.password=password;
    }
    public Account(){

    }
    @Override
    public double get_balance() {
        return balance;
    }

    @Override
    public String get_phone_number() {
        return phonenumber;
    }

    @Override
    public String get_credit_card_number() {
        return credit_card_number;
    }

    @Override
    public String get_first_name() {
        return first_name;
    }

    @Override
    public void deposit_balance(double amount) {
        if (amount<0){
            Errorbox("Cannot deposit negative amount","Error");
            throw new ArithmeticException("Cannot deposit negative amount");
        }
        this.balance+=amount;
    }

    @Override
    public void withdraw_balance(double amount) {
        if (amount>this.balance){
            Errorbox("Amount not available","Error");
            throw new ArithmeticException("Amount not available");
        }else if (amount<0){
            Errorbox("Cannot Withdraw negative amount","Error");
            throw new ArithmeticException("Cannot withdraw negative amount");
        }
        this.balance-=amount;
    }

    @Override
    public void set_balance(double amount) {
    this.balance=amount;
    }

    @Override
    public void set_phone_number(String phonenumber) {
    this.phonenumber=("+2"+phonenumber);
    }

    @Override
    public void set_credit_card_number(String credit_card_number) {
        this.credit_card_number=credit_card_number;
    }

    @Override
    public void set_first_name(String first_name) {
    this.first_name=first_name;
    }

    @Override
    public void set_password(String password) {
        this.password=password;
    }

    @Override
    public String toString() {
        return ("Name: "+get_first_name()+"\n   Phone Number: "+get_phone_number()+"\n  Credit Number: "+get_credit_card_number()+"\n   Balance: "+get_balance());
    }
}
