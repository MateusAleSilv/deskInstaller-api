package br.com.ondatermica.ondatermica;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OndatermicaApplication {

	@PostConstruct
    public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
	
	public static void main(String[] args) {
		SpringApplication.run(OndatermicaApplication.class, args);
	}

}
