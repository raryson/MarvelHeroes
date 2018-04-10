package com.example.raryson.marvelheroisnative.parameters;

import com.example.raryson.marvelheroisnative.parameters.AbstractParameters;
import com.example.raryson.marvelheroisnative.parameters.StoryOrderBy;

import java.util.ArrayList;
import java.util.List;

import io.mikael.urlbuilder.UrlBuilder;

public class StoryParameters extends AbstractParameters {

    private Integer id;
    private List<StoryOrderBy> orderBy = new ArrayList<StoryOrderBy>();

    public StoryParameters(Integer id) {
        this.id = id;
    }

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        return addParameterToUrl("orderBy", orderBy, urlBuilder);
    }

    public Integer getId() {
        return id;
    }

    public void addOrderBy(StoryOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }
}