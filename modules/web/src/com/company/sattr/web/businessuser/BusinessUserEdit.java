package com.company.sattr.web.businessuser;

import com.company.sattr.entity.BusinessUser;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.LookupPickerField;

import javax.inject.Named;

public class BusinessUserEdit extends AbstractEditor<BusinessUser> {
    @Named("fieldGroup.sysUser")
    private LookupPickerField userLookupField;

    @Override
    public void ready() {
        super.ready();
        userLookupField.getLookupAction().setLookupScreen("sec$User.browse");
    }
}