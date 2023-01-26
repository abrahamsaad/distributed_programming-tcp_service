package com.uninorte.distributed.programming.tcp.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplementation implements ServiceInterface{
	
	private Logger logger=LoggerFactory.getLogger(ServiceImplementation.class);

	@Override
	public byte[] processIncommingMessage(byte[] incommingMessage) {
		logger.info("Message received: "+(new String(incommingMessage)));
		
		return new String("ack for: "+(new String(incommingMessage))).getBytes();
	}

}
