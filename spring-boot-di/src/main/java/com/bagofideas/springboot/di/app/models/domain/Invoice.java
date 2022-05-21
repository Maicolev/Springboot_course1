package com.bagofideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@RequestScope
//@SessionScope
//@ApplicationScope
public class Invoice
{
    @Value("${invoice.description}")
    private String description;

    @Autowired
    private Client client;

    @Autowired
    private List <Item> items;

    @PostConstruct
    public void initializer()
    {
        client.setName(client.getName().concat(" ").concat("José"));
        description = description.concat(" for client: ").concat(client.getName());
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("Invoice destroyed: ".concat(description));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
