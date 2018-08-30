package coding.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "coding.*"})
public class AirtelCodingRoundApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AirtelCodingRoundApplication.class, args);
	}
}
