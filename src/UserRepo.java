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
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Login System! Press q to exit");
            System.out.println("Please input your Username: ");
            String user = input.nextLine();
            System.out.println("Please input your Password: ");
            String pass = input.nextLine();
            if (checkPassword(user, pass)) {
                System.out.println("Login Success! Found: " + user + "\n");
            } else {
                System.out.println("Login Failed! Try again\n");
            }
            if (user.equals("q") || user.equals("Q") || pass.equals("q") || pass.equals("Q")) {
                System.exit(0);
            }
        }
    }

    private void addUsersFromFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("users.txt"));
        if (!scan.hasNextLine()) {
            System.out.println("No users found in file!");
        }
        while (scan.hasNextLine()) {
            String user = scan.nextLine();
            String pass = scan.nextLine();
            userMap.put(user, new User(user, pass));
        }
    }
}
