package com.example.raryson.marvelheroisnative.model;

import java.util.AbstractList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreatorList extends AbstractList {
    private List<CreatorSummary> items;

    public List<CreatorSummary> getItems() {
        return items;
    }

    public void setItems(List<CreatorSummary> items) {
        this.items = items;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public Object get(int index) {
        return null;
    }
}