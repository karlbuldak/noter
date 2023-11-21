package pl.karolbuldak.notes_web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesWebApp {

	public static void main(String[] args) {
		SpringApplication.run(NotesWebApp.class, args);
//		String test = Utils.generateRandomSlug(6);
//		System.out.print(test);
	}

}
