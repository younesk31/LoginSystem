import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private final Map<String, User> userMap;

    public UserRepo() {
        userMap = new HashMap<>();
        userMap.put("younes", new User("younes", "1234"));
        userMap.put("david", new User("david", "4321"));
    }

    public boolean checkPassword(String username, String password){
        User user = userMap.get(username);
        if (user != null){

            return user.getPassword().equals(password);
        } else {
            return false;
        }
    }



}
