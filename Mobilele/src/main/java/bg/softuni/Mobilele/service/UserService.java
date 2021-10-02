package bg.softuni.Mobilele.service;

import bg.softuni.Mobilele.model.service.UserLoginServiceModel;

public interface UserService {

    void initUserAndRoles();

    boolean login(UserLoginServiceModel loginServiceModel);

    void logout();
}
