package io.github.Ital023.DesafioComponentesInjecaoDeDependencias;

import io.github.Ital023.DesafioComponentesInjecaoDeDependencias.Entities.OrderEntity;
import io.github.Ital023.DesafioComponentesInjecaoDeDependencias.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioComponentesInjecaoDeDependenciasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioComponentesInjecaoDeDependenciasApplication.class, args);
	}

	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		OrderEntity orderEntity = new OrderEntity(1309, 95.90, 0.0);

		System.out.println(orderService.total(orderEntity));

	}
}
