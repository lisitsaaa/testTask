package entity;

import java.util.List;
import java.util.Set;

public class User {

    private int id;
    private final String name;
    private final String familyName;
    private final String email;
    private final Set<Role> roles;
    private final List<Phone> phoneNumbers;

    public User(String name, String familyName, String email, List<Phone> phoneNumbers, Set<Role> roles) {
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", familyName = '" + familyName + '\'' +
                ", email = '" + email + '\'' +
                ", phoneNumbers = " + phoneNumbers.toString() +
                ", roles = " + roles.toString();
    }

    public enum Role {
        USER(1), CUSTOMER(1),
        ADMIN(2), PROVIDER(2),
        SUPER_ADMIN(3);

        private final int level;

        Role(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

    }
}
