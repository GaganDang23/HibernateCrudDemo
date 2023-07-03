package com.webosmotic.HibernateCrudDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.webosmotic.HibernateCrudDemo.dao.UserDaoImpl;
import com.webosmotic.HibernateCrudDemo.modal.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {

				System.out.println("1. Create a new User");
				System.out.println("2 See a user");
				System.out.println("3 See all the Users");
				System.out.println("4 update a user");
				System.out.println("5 Delete a User");
				System.out.println("6 Exit");
				System.out.println("Enter a Valid Choice");
				Integer choice = Integer.valueOf(reader.readLine());

				switch (choice) {
				case 1: {

					System.out.println("Enter UserId=");
					String userId = reader.readLine().trim();
					System.out.println("Enter First Name=");
					String firstName = reader.readLine().trim();
					System.out.println("Enter Last Name=");
					String lastName = reader.readLine().trim();
					System.out.println("Enter Username=");
					String userName = reader.readLine().trim();
					System.out.println("Enter Password=");
					String password = reader.readLine().trim();
					User user = new User(userId, firstName, lastName, userName, password);
					userDaoImpl.saveUser(user);
					System.out.println("Saved Sucessfully");
					break;
				}

				case 2:

				{
					System.out.println("Enter UserId=");
					String id = reader.readLine().trim();
					System.out.println(userDaoImpl.getUserById(id));
					System.out.println("Got Record Sucessfully");
					break;
				}

				case 3: {

					userDaoImpl.getAllUser().forEach(System.out::println);
					System.out.println("Get all users Sucessfully");
					break;
				}

				case 4: {

					System.out.println("Enter UserId=");
					String id = reader.readLine().trim();
					User user = userDaoImpl.getUserById(id);
					if (user == null) {
						System.out.println("User doesnot exsist");

						break;
					}
					System.out.println("Enter First Name ");
					String fname = reader.readLine().trim();
					if (fname != "")
						user.setFirstName(fname);
					System.out.println("Enter Last Name");
					String lname = reader.readLine().trim();
					if (lname != "")
						user.setLastName(lname);
					System.out.println("Enter Username");
					String username = reader.readLine().trim();
					if (username != "")
						user.setUserName(username);
					System.out.println("Enter Password");
					String password = reader.readLine().trim();
					if (password != "")
						user.setPassword(password);
					userDaoImpl.updateUser(user);
					System.out.println("User Updated Sucessfully");
					break;

				}

				case 5: {
					System.out.println("Enter userId=");
					String id = reader.readLine().trim();
					userDaoImpl.deleteByUserId(id);
					System.out.println("User Deleted Succesfully");

				}

				case 6: {
					System.exit(0);

				}

				default:
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

	}
}
