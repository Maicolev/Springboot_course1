package com.bagofideas.springboot.form.app.edits;

import java.beans.PropertyEditorSupport;

public class UpperCaseEdits extends PropertyEditorSupport
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        setValue(text.toUpperCase().trim());
    }
}
