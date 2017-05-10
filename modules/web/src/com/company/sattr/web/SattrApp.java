package com.company.sattr.web;

import com.company.sattr.entity.BusinessUser;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.web.Connection;
import com.haulmont.cuba.web.DefaultApp;

import javax.inject.Inject;

/**
 * Created by aleksey on 10/05/2017.
 */
public class SattrApp extends DefaultApp {

    @Inject
    private DataManager dataManager;

    @Override
    public void connectionStateChanged(Connection connection) throws LoginException {
        if (connection.isConnected() && connection.getSession() != null) {
            User user = connection.getSession().getUser();
            LoadContext<BusinessUser> loadContext = LoadContext.create(BusinessUser.class)
                    .setQuery(
                            LoadContext.createQuery("select e from sattr$BusinessUser e where e.sysUser.id = :user")
                            .setParameter("user", user)
                    )
                    .setView("business-user-view");
            BusinessUser businessUser = dataManager.load(loadContext);

            if (businessUser != null)
                connection.getSession().setAttribute("businessUser", businessUser);
        }

        super.connectionStateChanged(connection);
    }
}
