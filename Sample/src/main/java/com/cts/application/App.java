package com.cts.application;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.application.dao.UserDao;
import com.cts.application.dao.impl.UserDaoImpl;
import com.cts.application.entity.User;


/**
* Hello world!
*
*/
public class App {

	


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		ConfigurableApplicationContext context= new ClassPathXmlApplicationContext("com/cts/application/springCore.xml");
		
		UserDao Dao= (UserDaoImpl) context.getBean("dao");

		System.out.println("Make a choice");
		do {
		System.out.println("1. Create User");
		System.out.println("2. Fetch User Data");
		System.out.println("300.  Exit");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			System.out.println("Enter User id : ");
			int id=Integer.parseInt(sc.nextLine());	
			System.out.println("Enter User name : ");
			String uName=sc.nextLine();
			System.out.println("Enter User password : ");
			String upassword=sc.nextLine();
			System.out.println("Enter User role : ");
			String uRole=sc.nextLine();

			sc.close();
			User userRef = (User) context.getBean("userBean");
			  userRef.setId(id);
			  userRef.setName(uName);
			  userRef.setPassword(upassword);
			  userRef.setRole(uRole);
			context.close();
			boolean res=Dao.createUser(userRef);
			if(res)
			System.out.println("User Created");

			break;
		case 2:
			Dao.fetchUser().forEach(user -> System.out.println(user));
         break;
		case 300:
			System.exit(1);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}


		}while(true);
	
	}
}

