package com.mycompany.server;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class StandaloneServer {

    protected StandaloneServer() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(TestResource.class);
        sf.setResourceProvider(TestResource.class,
                new SingletonResourceProvider(new TestResourceImpl()));
        sf.setAddress("http://localhost:8081/");

        sf.setProvider(new JacksonJaxbJsonProvider());
        sf.create();
    }

    public static void main(String args[]) throws Exception {
        new StandaloneServer();
        Thread.sleep(5 * 6000 * 1000);
        System.exit(0);
    }
}