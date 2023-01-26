package com.uninorte.distributed.programming.tcp.server.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.uninorte.distributed.programming.tcp.server.service.ServiceImplementation;
import com.uninorte.distributed.programming.tcp.server.service.ServiceInterface;

@MessageEndpoint
public class TCPEndpoint {
	
	@Autowired
	private ServiceInterface serviceInterface;
	
	@ServiceActivator(inputChannel = "getMessageChannel")
	public byte[] processIncommingMessage(byte[] data) {
		return serviceInterface.processIncommingMessage(data);
	}
	

}
