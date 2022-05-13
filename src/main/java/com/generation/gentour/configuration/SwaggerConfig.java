package com.generation.gentour.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springGenTouropenApi() {
		return new OpenAPI()
				.info(new Info().title("Projeto integrador").description("projeto integrador - Generation Brasil")
				.version("v0.01")
				.license(new License().name("Generation Brasil").url("https://brazil.generation.org//"))
				.contact(new Contact().name("GenTour").url("https://github.com/Projeto-Integrador-Gen-Tour")
				.email("projetogentur@gmail.com")))
				.externalDocs(new ExternalDocumentation().description("Github")
				.url("https://github.com/Projeto-Integrador-Gen-Tour"));
	}

	@Bean
	public OpenApiCustomiser costumerGlobalHeaderOpenApiCostumiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro Na Requisição"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro Na Aplicação"));
			}));
		};
	}
	
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
}
