package FilmsProject.Controller;

import FilmsProject.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserStorage  {
    private static List<User> listOfUsers = new ArrayList<>();

    private HashMap<String,String> userData = new HashMap<>();

    private static UserStorage instance;

    private UserStorage(){
    }

    public static UserStorage getInstance() {
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }

    public HashMap<String, String> getUserData() {
        return userData;
    }

    public boolean addNewUser(User user)
    {
        if (!isExistLogin(user.getLogin())) {
            listOfUsers.add(user);
            userData.put(user.getLogin(),user.getPassword());
            return true;
        }
        return false;
    }

    public List<User> getUsers() {
        return listOfUsers;
    }

    private boolean isExistLogin(String login){
         return userData.containsKey(login);
    }




}
