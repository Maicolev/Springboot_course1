package com.bagofideas.springboot.form.app.edits;

import com.bagofideas.springboot.form.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CountryPropertyEdits extends PropertyEditorSupport
{
    @Autowired
    private CountryService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {

        try {
            Integer id = Integer.parseInt(idString);
            this.setValue(service.getById(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }

    }

}
