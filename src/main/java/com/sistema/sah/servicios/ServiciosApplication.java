package com.sistema.sah.servicios;

import com.sistema.sah.seguridad.helper.configuration.SpringSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.sistema.sah"
)
@Import(SpringSecurityConfig.class)
public class ServiciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosApplication.class, args);
	}

}
