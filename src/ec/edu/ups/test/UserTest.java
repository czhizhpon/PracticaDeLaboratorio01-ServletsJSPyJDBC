package ec.edu.ups.test;

import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.User;

public class UserTest {

	public static void main(String[] args) {
		UserDAO userDAO = DAOFactory.getFactory().getUserDAO();
		
			// Create Table

		System.out.println("Creando tabla USERS...");
		userDAO.createTable();
		
		
			// Create Users
		// Lista de Usuarios
		User[] usersList = new User[4];
		
		// Crear usuarios
		
		System.out.println("\nCreando 4 usuarios...");
		
		//*
		for (int i = 0; i < usersList.length; i++) {
			usersList[i] = new User();
			usersList[i].setUseUsername("username"+i);
			usersList[i].setUseEmail("email" + i + "@example.com");
			usersList[i].setUseName("Name"+i);
			usersList[i].setUseLastname("LastName"+i);
			usersList[i].setUsePassword("password"+i);
			usersList[i].setUseRole('U');
			//usersList[i].setUseDeleted(false);
					
			userDAO.create(usersList[i]);
		}
		//*/
		
		// Read User
		System.out.println("\n Read: Usuario con ID = 2");
		System.out.println(userDAO.read(2));
		
		
		// Update User
		System.out.println("Modificando Usuario con ID = 2");
		User upUser = new User();
		upUser.setUseId(2);
		upUser.setUseEmail("anotheremail@example.com");
		upUser.setUseName("AnotherName");
		upUser.setUseLastname("AnotherLastName");
		upUser.setUseUsername("AnotherUsername");
		upUser.setUseRole('A');
		upUser.setUsePassword("NewPassword");
		userDAO.update(upUser);
		
		System.out.println("\n Read: Usuario con ID = 2 modificado");
		System.out.println(userDAO.read(2));
		
		// Delete User
		System.out.println("\nUsuario con ID = 3, eliminando...");
		User deUser = new User();
		deUser.setUseId(3);
		userDAO.delete(deUser);
		
		// List Users
		List<User> array = (List<User>) userDAO.find();
		
		System.out.println("\nListando Usuario Activos...");
		
		for (User user : array) {
			System.out.println(userDAO.read(user.getUseId()));
		}

	}

}
