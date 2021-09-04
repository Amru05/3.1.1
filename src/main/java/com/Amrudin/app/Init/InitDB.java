package com.Amrudin.app.Init;


import com.Amrudin.app.service.UserService;
import com.Amrudin.app.model.Role;
import com.Amrudin.app.model.User;
import com.Amrudin.app.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
public class InitDB {

    private final UserService userService;
    private final RoleRepo roleRepo;



    @Autowired
    public InitDB(UserService userService, RoleRepo roleRepo) {

        this.userService = userService;
        this.roleRepo = roleRepo;

    }

    @PostConstruct
    public void InitUsersDB() {

        Role role1 = new Role(1L, "ROLE_ADMIN");
        roleRepo.save(role1);
        Role role2 = new Role(2L, "ROLE_USER");
        roleRepo.save(role2);


        User user1 = new User("Andrey",
                "pass", (byte) 18, "Petrov", "And@mail.ru",
                new HashSet<>() {{
                    add(role1);

                }});
        userService.addUser(user1);

        User user2 = new User("Maga",
                "pass1", (byte) 19,  "Gavrilov", "Maga05@mail.ru",
                new HashSet<>() {{

                    add(role2);
                }});
        userService.addUser(user2);

        User user3 = new User("Lesha",
                "pass2", (byte) 19,  "Gavrilov", "Leh11@mail.ru",
                new HashSet<>() {{

                    add(role2);
                }});
        userService.addUser(user3);
    }
}
