package br.com.produto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Microsserviço responsável pelo cadastro de produtos",
				version = "1.0",
				description = "API-Produtos.",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class MsprodutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsprodutoApplication.class, args);
	}

}
