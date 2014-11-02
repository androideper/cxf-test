package com.mycompany.server;

import static com.mycompany.Utils.stringsEqual;

/**
 */
public class Item {
    private int id;
    private String name;
    private String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that instanceof Item) {
            Item thatItem = (Item) that;
            return this.getId() == thatItem.getId() && stringsEqual(this.getName(), thatItem.getName()) &&
                    stringsEqual(this.getDescription(), thatItem.getDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Item["); //todo - check what is toString best practices
        sb.append("id=").append(id).append(", name=").append(name).append(", desc=").append(description).append("]");
        return sb.toString();
    }
}
