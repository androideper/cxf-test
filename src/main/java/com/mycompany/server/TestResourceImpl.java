package com.mycompany.server;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResourceImpl implements TestResource {
    int currentId = 0;
    private Map<Integer, Item> items = new HashMap<Integer, Item>();

    public TestResourceImpl() {
        init();
    }

    @Override
    public List<Item> getItems() {
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String id) {
        return items.get(Integer.parseInt(id));
    }

    @Override
    public Response updateItem(Item item) {
        items.put(item.getId(), item);
        return Response.ok().build();
    }

    @Override
    public Response addItem(Item item) {
        item.setId(++currentId);
        items.put(item.getId(), item);
        return Response.ok(item).build();
    }

    @Override
    public Response deleteItem(String id) {
        items.remove(Integer.parseInt(id));
        return Response.ok().build();
    }

    final void init() {
        Item c = new Item();
        c.setName("Test Item");
        c.setId(123);
        items.put(c.getId(), c);
    }
}