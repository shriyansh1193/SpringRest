package com.shrey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld implements CommandLineRunner {
	@Value("${company}")
	private String company;

	@Value("${team.size}")
	private int teamsize;

	@Value("${client.name}")
	private String clientName;
	@Value("${project}")
	private String projID;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello shrey!");
		System.out.println("!---------------------!");
		System.out.println("training startedS");
		System.out.println("This is from: " + company);
		System.out.println("team size is: " + teamsize);
		System.out.println("Client name:" + clientName);
		System.out.println("Project id:" + projID);

	}

}
