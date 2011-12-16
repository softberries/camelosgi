package com.softwarepassion.camelosgi;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy {
	
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			System.out.println("old exchange was null");
            return newExchange;
        }
		Message newIn = newExchange.getIn();
		String oldBody = oldExchange.getIn().getBody(String.class);
		System.out.println("oldBody: " + oldBody);
		String newBody = newIn.getBody(String.class);
		System.out.println("newBody: " + newBody);
		System.out.println("body: " + oldBody + newBody);
		newIn.setBody(oldBody + newBody);
		
		return newExchange;
	}
}