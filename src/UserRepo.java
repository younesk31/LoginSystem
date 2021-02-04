import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRepo {
    private final Map<String, User> userMap;

    public UserRepo() throws FileNotFoundException {
        userMap = new HashMap<>();
        addUsersFromFile();
    }


    public boolean checkPassword(String username, String password) {
        User user = userMap.get(username);
        if (user != null) {
            return user.getPassword().equals(password);
        } else {
            return false;
        }
    }

    public void doTheWork() {
        boolean oneMore = true;
        Scanner input = new Scanner(System.in);
        while (oneMore) {
            System.out.println("Username: ");
            String user = input.nextLine();
            System.out.println("Password: ");
            String pass = input.nextLine();
            if (checkPassword(user, pass)) {
                System.out.println("Login Success! Welcome: " + user + "\nLogging you out now!");
            } else {
                System.out.println("Wrong! Try again!");
            }

            if (user.equals("exit")) {
                oneMore = false;
            }
        }
    }

    private void addUsersFromFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("users.txt"));
        while (scan.hasNextLine()) {
            String user = scan.nextLine();
            String pass = scan.nextLine();
            userMap.put(user, new User(user, pass));
        }
        if (!scan.hasNextLine()) {
            System.out.println("No users found in file!");
        }
    }

}
