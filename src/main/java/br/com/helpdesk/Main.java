package br.com.helpdesk;

import br.com.helpdesk.entity.User;
import br.com.helpdesk.enums.ProfileEnum;
import br.com.helpdesk.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            initUsers(userRepository, passwordEncoder);
        };
    }

    public void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User admin = new User();
        admin.setEmail("admin@helpdesk.com");
        admin.setPassword(passwordEncoder.encode("teste123"));
        admin.setProfile(ProfileEnum.ROLE_ADMIN);

        User find = userRepository.findByEmail("admin@helpdesk.com");
        if(find ==null){
            userRepository.save(admin);
        }
    }
}
