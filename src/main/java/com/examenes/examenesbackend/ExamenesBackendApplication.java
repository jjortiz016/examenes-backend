package com.examenes.examenesbackend;

import com.examenes.examenesbackend.entities.Role;
import com.examenes.examenesbackend.entities.User;
import com.examenes.examenesbackend.entities.UserRole;
import com.examenes.examenesbackend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class ExamenesBackendApplication implements CommandLineRunner {
    @Autowired
	private IUserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user= new User();

		user.setName("Jhon");
		user.setLastName("Ortiz");
		user.setUsername("jortiz");
		user.setPassword("1234");
		user.setEmail("correo@correo.com");
		user.setPhone("2121546131");
		user.setProfile("photo.png");

		Role role = new Role();
		role.setIdRole(1L);
		role.setName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userrole= new UserRole();
		userrole.setRole(role);
		userrole.setUser(user);
		userRoles.add(userrole);

		User userSaved = userService.saveUser(user, userRoles );
	}
}
