import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepo users = new UserRepo();
        Scanner input = new Scanner(System.in);

        boolean oneMore = true;

        while (oneMore){
            System.out.println("Username: ");
            String user = input.nextLine();
            System.out.println("Password: ");
            String pass = input.nextLine();
            if (users.checkPassword(user,pass)){
                System.out.println("Login Success! Welcome: "+user+"\nLogging you out now!");
            } else {
                System.out.println("Wrong! Try again!");
            }

            if (user.equals("exit")){
                oneMore = false;
            }
        }
    }
}
