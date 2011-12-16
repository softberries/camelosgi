package com.softwarepassion.camelosgi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoteProcessor implements Processor {

	private static final transient Logger LOG = LoggerFactory.getLogger(NoteProcessor.class);

    public void process(Exchange exchange) throws Exception {
    	if(exchange != null && exchange.getOut() != null && exchange.getOut().getBody() != null){
    		System.out.println("PROCESSOR: " + exchange.getOut().getBody().toString());
    	}
    	
//    	LOG.debug("setting id to 444");
//        exchange.getOut().setHeader("id", "444");
//        exchange.getOut().setBody("CreditAgency processed the request.");
    }
}
