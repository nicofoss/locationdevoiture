package fr.inti.myapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context;
		
		// si plusieurs fichier on fait un tableau de string
		//context = new ClassPathXmlApplicationContext(new String[]{"app.xml"});
		context = new ClassPathXmlApplicationContext("app.xml");
		
	}

}
