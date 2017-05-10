package com.company.sattr.web.screens;

import com.company.sattr.entity.BusinessUser;
import com.company.sattr.entity.Company;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.UUID;

public class ExtAppMainWindow extends AppMainWindow {

    @Inject
    private CollectionDatasource<Company, UUID> companiesDs;

    @Inject
    private UserSessionSource userSessionSource;

    @Inject
    private LookupField companyLookup;

    @Override
    public void ready() {
        super.ready();

        BusinessUser businessUser = userSessionSource.getUserSession().getAttribute("businessUser");
        if (businessUser != null) {
            Company company = businessUser.getCompany();

            //companiesDs.setItem(company);
            companyLookup.setValue(company);
        }

        companiesDs.addItemChangeListener(e -> showNotification("Company has been changed"));
    }
}