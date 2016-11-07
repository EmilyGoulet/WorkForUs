package butte.emily.passionprojectserver;


import butte.emily.passionprojectserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(UserService service) {
		return args -> {
			log.info("@@ Inserting Data...");
			service.insertData();
			log.info("@@ findAll() call...");
			service.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
}





