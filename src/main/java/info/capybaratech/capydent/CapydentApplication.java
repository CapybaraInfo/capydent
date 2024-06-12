package info.capybaratech.capydent;

import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CapydentApplication {

	public static void main(String[] args) {

		SpringApplication.run(CapydentApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("321@Mudar") + " " + UlidCreator.getUlid());
	}

}
