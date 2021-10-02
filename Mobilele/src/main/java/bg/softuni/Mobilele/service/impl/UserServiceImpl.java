package bg.softuni.Mobilele.service.impl;

import bg.softuni.Mobilele.model.service.UserLoginServiceModel;
import bg.softuni.Mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void initUserAndRoles() {

    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {
        return false;
    }

    @Override
    public void logout() {

    }
}
