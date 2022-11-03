package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DefaultUsers {

    final RoleService roleService;

    final UserService userService;

    @Autowired
    public DefaultUsers(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addDefaultUser() {
        roleService.saveRole(new Role(null, "ROLE_USER"));
        roleService.saveRole(new Role(null, "ROLE_ADMIN"));
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(roleService.getRoleById(1L));
        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(roleService.getRoleById(1L));
        roleSet2.add(roleService.getRoleById(2L));
        User user1 = new User("Igor", "Suvorov", 24, "User@user.com", "user", roleSet1);
        User user2 = new User("Petr", "Sidorov",27, "Admin@admin.com", "admin", roleSet2);
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
