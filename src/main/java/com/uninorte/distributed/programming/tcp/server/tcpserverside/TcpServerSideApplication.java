package com.uninorte.distributed.programming.tcp.server.tcpserverside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.uninorte.distributed.programming.tcp.*")
public class TcpServerSideApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcpServerSideApplication.class, args);
	}

}
