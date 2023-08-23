import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
//Scanner class which is used to take input from the command line
public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    // this denotes that what kind of money format you have
    HashMap<Integer, Integer> data = new HashMap<>();
    // then we have a hashmap which is storing a couple of a records of account number to pin mapping ,and we create a map named data

    public void getLogin() {
        int x = 1;
        do {
            try {
                // we had a couple of entries to the map
                data.put(952141, 191904);
                data.put(989947, 71976);
                // first integer is pointing to tha customer no and the second integer is pointing to the pin no of customer account no

                // if we call the get login method this method will insert the data after that he will ask you line no 26
                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                // if we give wrong customer no then it will give error
                System.out.println("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
                //if we write incorrect pin no or customer no then we get an exception
            } catch (Exception e) {
                System.out.println("""

                        Invalid Character(s).Only Numbers.
                        """);
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("""

                        Wrong Customer Number or Pin Number
                        """);
            }
            while (x == 1) ;
        }
        //in get login method we asked the customer to enter the  pin no or customer no. based on that we provide customers an option to choose there account type from getAccount type whether they choose checking and saving account based on that whatever account they choose .it calls getChecking method or getSaving method in these method we provide customer some other option like withdraw,view ,deposit fund  this is what happening in the OptionMenu class
        //once a customer provide pin no or customer no after that we will ask customer to provide the account type .this application support two type of account one is checking account and other one is saving ,and we will take input from the command line using the scanner class

        public void getAccountType(){
            System.out.println("Select the Account you Want to Access: ");
            System.out.println(" Type 1 - Checking Account");
            System.out.println(" Type 2 - Saving Account");
            System.out.println(" Type 3 - Exit");

            int selection = menuInput.nextInt();

            switch (selection) {
                // if the customer enter 1 then it will execute some code for the checking and saving account
                case 1 -> getChecking();
                case 2 -> getSaving();
                case 3 -> System.out.println("Thank You for using this ATM,bye. \n");
                default -> System.out.println("""

                        Invalid Choice.
                        """);
            }
        }
        public void getChecking(){
            System.out.println("Checking Account:");
            System.out.println(" Type 1 - View Balance");
            System.out.println(" Type 2 - Withdraw Funds");
            System.out.println(" Type 3 - Deposit Funds");
            System.out.println(" Type 4 - Exit");
            System.out.println("Choice: ");
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1 -> {
                    System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    getAccountType();
                }
                case 2 -> {
                    getCheckingWithdrawInput();
                    getAccountType();
                }
                case 3 -> {
                    getCheckingDepositInput();
                    getAccountType();
                }
                case 4 -> System.out.println("Thank You for using this ATM, bye.");
                default -> {
                    System.out.println("""

                            Invalid Choice.
                            """);
                    getChecking();
                }
            }
        }

        public void getSaving(){
             System.out.println("Saving Account: ");
            System.out.println(" Type 1 - View Balance");
            System.out.println(" Type 2 - Withdraw Funds");
            System.out.println(" Type 3 - Deposit Funds");
            System.out.println(" Type 4 - Exit");
            System.out.println("Choice: ");

            int selection = menuInput.nextInt();

            switch (selection) {
                case 1 -> {
                    System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                    getAccountType();
                }
                case 2 -> {
                    getSavingWithdrawInput();
                    getAccountType();
                }
                case 3 -> {
                    getSavingDepositInput();
                    getAccountType();
                }
                case 4 -> System.out.println("Thank You for using this ATM, bye.");
                default -> {
                    System.out.println("""

                            Invalid Choice.
                            """);
                    getSaving();
                }
            }
        }
}
