package bg.softuni.Mobilele.user;

import bg.softuni.Mobilele.model.entity.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private boolean loggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private Set<RoleEnum> roles = new HashSet<>();

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addRole(RoleEnum role) {
        roles.add(role);
    }

    public void clean() {
        setLoggedIn(false);
        setUsername(null);
        setFirstName(null);
        setLastName(null);
        clearRoles();
    }

    private void clearRoles() {
        roles.clear();
    }
}
