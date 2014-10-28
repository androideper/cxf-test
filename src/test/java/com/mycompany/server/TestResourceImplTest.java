package com.mycompany.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 10/28/14 - 4:47 AM
 */
public class TestResourceImplTest {
    private static Server server;
    private TestResource client;

    @BeforeClass
    public static void setUpClass() {
        server = startServer();
    }

    @AfterClass
    public static void tearDownClass(){
        server.destroy();
    }

    @Before
    public void setUp() throws Exception {
        client = JAXRSClientFactory
                .create("http://localhost:8081/", TestResource.class, Collections.singletonList(new JacksonJaxbJsonProvider()));

    }

    @Test
    public void getItems() throws Exception {
        //given a client
        //when
        List<Item> items = client.getItems();
        //then
        assertThat(items.size(), is(1));

    }

    public void getItem() throws Exception {

    }

    public void updateItem() throws Exception {

    }

    public void addItem() throws Exception {

    }

    public void deleteItem() throws Exception {

    }

    private static Server  startServer() {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(TestResource.class);
        sf.setResourceProvider(TestResource.class,
                new SingletonResourceProvider(new TestResourceImpl()));
        sf.setAddress("http://localhost:8081/");
        // needed for json/Jaxb serialization/de-serialization
        sf.setProvider(new JacksonJaxbJsonProvider());
        return sf.create();
    }
}
