package filmsproject.interfaces;

import filmsproject.model.User;

public interface UserAccessService {
    public User getUserByLogin(String login);
    public boolean addNewUser(User user);
}
