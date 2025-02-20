package com.example.Splitwise12;

import com.example.Splitwise12.command.Command;
import com.example.Splitwise12.command.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Splitwise12Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Splitwise12Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner=new Scanner(System.in);
          while(true) {
			  System.out.println("Awaiting input ");
			  String input = scanner.next();
			  Command command = CommandRegistry.getInstance().getCommand(input);
			  command.execute(input);
		  }
	}
}
