package com.company.sattr.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|sysUser")
@Table(name = "SATTR_BUSINESS_USER")
@Entity(name = "sattr$BusinessUser")
public class BusinessUser extends StandardEntity {
    private static final long serialVersionUID = 6410198822233172316L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SYS_USER_ID", unique = true)
    protected User sysUser;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    protected Company company;

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

    public User getSysUser() {
        return sysUser;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }


}