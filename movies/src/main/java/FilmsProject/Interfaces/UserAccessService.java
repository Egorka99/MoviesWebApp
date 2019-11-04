package FilmsProject.Interfaces;

import FilmsProject.Model.User;

public interface UserAccessService {
    public User getUserByLogin(String login);
    public boolean addNewUser(User user);
}
