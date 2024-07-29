package app.quantun.langchanin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class LangchaninApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangchaninApplication.class, args);
    }

}
