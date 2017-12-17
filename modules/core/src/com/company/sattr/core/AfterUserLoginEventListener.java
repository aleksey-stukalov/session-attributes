package com.company.sattr.core;

import com.company.sattr.entity.BusinessUser;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.security.app.Authentication;
import com.haulmont.cuba.security.auth.events.UserLoggedInEvent;
import com.haulmont.cuba.security.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Aleksey Stukalov on 17/12/2017.
 */

@Component
public class AfterUserLoginEventListener implements ApplicationListener<UserLoggedInEvent> {

    @Inject
    private DataManager dataManager;

    @Inject
    private Authentication auth;

    @Override
    public void onApplicationEvent(UserLoggedInEvent event) {
        if (event.getUserSession() != null && !event.getUserSession().isSystem()) {
            auth.withSystemUser(() -> {
                User user = event.getUserSession().getUser();
                LoadContext<BusinessUser> loadContext = LoadContext.create(BusinessUser.class)
                        .setQuery(
                                LoadContext.createQuery("select e from sattr$BusinessUser e where e.sysUser.id = :user")
                                        .setParameter("user", user)
                        )
                        .setView("business-user-view");


                BusinessUser businessUser = dataManager.load(loadContext);

                if (businessUser != null)
                    event.getUserSession().setAttribute("businessUser", businessUser);
                return null;
            });
        }
    }
}
