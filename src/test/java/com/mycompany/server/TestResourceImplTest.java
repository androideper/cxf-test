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

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    public static void tearDownClass() {
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
        List<Item> givenItems = client.getItems();
        //when
        Item item = client.addItem(new Item("givenTestListName", "givenTestListDesc")).readEntity(Item.class);
        List<Item> resultItems = client.getItems();
        //then
        assertThat(resultItems.size(), is(givenItems.size() + 1));
        assertListContainsItem(resultItems, item);
    }

    @Test
    public void getItem() throws Exception {
        //given
        Item givenItem = client.addItem(new Item("givenGetItemName", "givenGetItemDesc")).readEntity(Item.class);
        //when
        Item expectedItem = client.getItem(String.valueOf(givenItem.getId()));
        //then
        assertTrue(givenItem.equals(expectedItem));
    }

    @Test
    public void updateItem() throws Exception {
        //given
        Item givenItem = client.addItem(new Item("givenUpdateItemName", "givenUpdateItemDesc")).readEntity(Item.class);
        givenItem.setName("newUpdateName");
        givenItem.setDescription("newUpdateDesc");
        //when
        Response response = client.updateItem(givenItem);
        //then
        Item expectedItem = client.getItem(String.valueOf(givenItem.getId()));
        assertTrue(givenItem.equals(expectedItem));
    }

    @Test
    public void addItem() throws Exception {
        //given
        Item givenItem = new Item("givenItemName", "givenItemDesc");
        //when
        Response response = client.addItem(givenItem);
        //then
        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
        Item item = response.readEntity(Item.class);
        Item responseItem = client.getItem(String.valueOf(item.getId()));
        assertThat(givenItem.getName(), is(responseItem.getName()));
        assertThat(givenItem.getDescription(), is(responseItem.getDescription()));
    }

    @Test
    public void deleteItem() throws Exception {
        //given
        Item givenItem = client.addItem(new Item("givenUpdateItemName", "givenUpdateItemDesc")).readEntity(Item.class);
        //when
        Response response = client.deleteItem(String.valueOf(givenItem.getId()));
        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
        Item item = client.getItem(String.valueOf(givenItem.getId()));
        assertNull(item);
    }

    private static Server startServer() {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(TestResource.class);
        sf.setResourceProvider(TestResource.class,
                new SingletonResourceProvider(new TestResourceImpl()));
        sf.setAddress("http://localhost:8081/");
        // needed for json/Jaxb serialization/de-serialization
        sf.setProvider(new JacksonJaxbJsonProvider());
        return sf.create();
    }

    private void assertListContainsItem(List<Item> list, Item item) {
        for (Item listItem : list) {
            if (item.equals(listItem)) {
                return;
            }
        }
        fail("List does not contain given item: " + item);
    }
}
