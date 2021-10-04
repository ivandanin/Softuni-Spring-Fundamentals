package bg.softuni.Mobilele.service.impl;

import bg.softuni.Mobilele.model.entity.User;
import bg.softuni.Mobilele.model.entity.UserRole;
import bg.softuni.Mobilele.model.entity.enums.RoleEnum;
import bg.softuni.Mobilele.model.service.UserLoginServiceModel;
import bg.softuni.Mobilele.repository.UserRepository;
import bg.softuni.Mobilele.repository.UserRoleRepository;
import bg.softuni.Mobilele.service.UserService;
import bg.softuni.Mobilele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void initUserAndRoles() {
        initRoles();
        initUsers();
    }

    private void initUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleRepository.findByRole(RoleEnum.ADMIN);
            UserRole userRole = userRoleRepository.findByRole(RoleEnum.USER);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("test"));
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setActive(true);

            admin.setRoles(List.of(adminRole, userRole));
            userRepository.save(admin);

            User pesho = new User();
            pesho.setUsername("pesho");
            pesho.setPassword(passwordEncoder.encode("test"));
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setActive(true);

            pesho.setRoles(List.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(RoleEnum.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(RoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> userOpt = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(
                    loginServiceModel.getRawPassword(),
                    userOpt.get().getPassword());

            if (success) {
                User loggedInUser = userOpt.get();
                currentUser.setLoggedIn(true)
                        .setUsername(loggedInUser.getUsername())
                        .setFirstName(loggedInUser.getFirstName())
                        .setLastName(loggedInUser.getLastName());
                

                loggedInUser.getRoles().forEach(r -> currentUser.addRole(r.getRole()));
            }
                return success;
        }
    }

    @Override
    public void logout() {
        currentUser.clean();
    }
}
