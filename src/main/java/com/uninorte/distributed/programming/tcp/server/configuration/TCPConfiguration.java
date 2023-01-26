package com.uninorte.distributed.programming.tcp.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.tcp.TcpInboundGateway;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNioServerConnectionFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
public class TCPConfiguration {
	
	@Value("${tcp.server.port}")
	private int port;
	
	@Bean
	public AbstractServerConnectionFactory getAbstractServerConnectionFactory() {
		
		TcpNioServerConnectionFactory serverConnectionFactory=new TcpNioServerConnectionFactory(this.port);
		serverConnectionFactory.setUsingDirectBuffers(true);
		return serverConnectionFactory;
		
	}
	
	@Bean
	@Primary
	public MessageChannel getMessageChannel() {
		DirectChannel directChannel=new DirectChannel();
		return directChannel;
	}
	
	@Bean
	public TcpInboundGateway getTcpInboundGateway(AbstractServerConnectionFactory connectionFactory,  MessageChannel channel) {
		TcpInboundGateway gateway=new TcpInboundGateway();
		gateway.setConnectionFactory(connectionFactory);
		gateway.setRequestChannel(channel);
		return gateway;
	}
	
	
	

}
