package id.muhammadfaisal.kring.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Date;

@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@ComponentScan
public class SessionHelper {

    @Value("${application.salt}")
    private String saltProperties;

    @PostConstruct
    public String generateSession(Environment environment, String identifer) {
        String salt = environment.getProperty("application.salt");
        String dateTimeNow = String.valueOf(new Date().getTime());

        if (salt != null) {
            return Encrypter.encrypt(salt.concat(identifer).concat(dateTimeNow));
        }

        return null;
    }
}
