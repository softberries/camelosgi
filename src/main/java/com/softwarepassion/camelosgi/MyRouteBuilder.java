/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.softwarepassion.camelosgi;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

/**
 * A simple example router to show how to define the route with Java DSL
 *
 * @version $Revision$
 */
public class MyRouteBuilder extends RouteBuilder {
    /**
     * Allow this route to be run as an application
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        new Main().run(args);
    }

    public void configure() {
    	from("activemq:test2").split(xpath("/notes/note")).parallelProcessing().setHeader("id", simple("123")).to("activemq:test3");
    	from("activemq:test3").aggregate(header("id"), new MyAggregationStrategy()).completionTimeout(3000).to("log:ExampleRouter");
    }

    
}
