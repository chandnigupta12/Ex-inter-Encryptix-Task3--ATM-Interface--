import java.util.*;
class BankAccount {

    String name;
    String Username;
    String password;
    String accountNo;
    float balance = 1000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter your Name: ");
        this.name = scan.nextLine();
        System.out.println("\nEnter your Username:");
        this.Username = scan.nextLine();
        System.out.println("\nEnter your password:");
        this.password = scan.nextLine();
        System.out.println("\nEnter your account number:");
        this.accountNo = scan.nextLine();
        System.out.println("\nSuccessFull registered . Please Log in your Bank account");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner scan = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("\nEnter your username: ");
            String username = scan.nextLine();
            if (Username.equals(username)) {
                while (!isLogin) {
                    System.out.println("\nEnter your Password: ");
                    String Password = scan.nextLine();
                    if (password.equals(Password)) {
                        System.out.println("\nLog IN SuccessFull");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("\nEnter  Amount to withdraw:  ");
        Scanner scan = new Scanner(System.in);
        float amount = scan.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nwihdraw Successfull.");
                String str = amount + "Rs withdraw\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient  Balancce");
            }
        } catch (Exception e) {

        }

    }

    public void deposit() {
        System.out.println("\nEnter  Amount to Deposit:  ");
        Scanner scan = new Scanner(System.in);
        float amount = scan.nextFloat();
        try {
            if (balance <= 10000f) {
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Successfull.");
                String str = amount + "Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry. the limit is 10000.");
            }
        } catch (Exception e) {

        }

    }

    public void transfer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name: ");
        String receipent = scan.nextLine();
        System.out.println("\nEnter  Amount to transfer:  ");
        float amount = scan.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("/n Successfully Transferred to " + receipent);
                    String str = amount + "Rs transferred to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry. the limit is 50000.");
                }
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {

        }

    }

    public void checkBalance() {
        System.out.println("\n" + balance + "Rs");
    }

    public void transactionHistory() {
        if (transactions == 0) {
            System.out.println("No Transaction happened");
        } else {
            System.out.print("\n" + transactionHistory);
        }
    }

    public class ATMInterface {

        public static int takenIntegerInput(int limit) {
            int input = 0;
            boolean flag = false;
            while (!flag) {
                try {
                    Scanner scan = new Scanner(System.in);
                    input = scan.nextInt();
                    flag = true;

                    if (flag && input > limit || input < 1) {
                        System.out.println("Choose the number between 1 to " + limit);
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("Enter only interger value.");
                    flag = false;
                }
            }
            return input;

        }

        public static void main(String[] args) {

            System.out.println("\n**************************** WELCOME TO CHANDNI ATM INTERFACE **********8******8******8*88***");
            System.out.println("1.Register  \n2.Exit");
            System.out.println("Choose  one option: ");
            int choose = takenIntegerInput(2);

            if (choose == 1) {
                BankAccount b = new BankAccount();
                b.register();

                while (true) {
                    System.out.println("1.Login  \n2.Exit");
                    System.out.println("Enter your  choice: ");
                    int ch = takenIntegerInput(6);
                    if (ch == 1) {
                        if (b.login()) {
                            System.out.println("\n**************************** WELCOME BACK" + b.name+"**********8******8******8*88***");
                            boolean isFinished = false;
                            while (true) {
                                System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance  \n5.Transaction History  \n6.Exit");
                                System.out.println("Enter your  choice: ");
                                int c = takenIntegerInput(6)
                                        ;
                                switch (c) {
                                    case 1:
                                        b.withdraw();
                                        break;
                                    case 2:
                                        b.deposit();
                                        break;
                                    case 3:
                                        b.transfer();
                                        break;
                                    case 4:
                                        b.checkBalance();
                                        break;
                                    case 5:
                                        b.transactionHistory();
                                        break;
                                    case 6:
                                        isFinished = true;
                                        break;
                                }
                            }
                        }

                    } else {
                        System.exit(0);
                    }
                }

            } else {
                System.exit(0);
            }
        }
    }
}

