package com.company.sattr.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "SATTR_COMPANY")
@Entity(name = "sattr$Company")
public class Company extends StandardEntity {
    private static final long serialVersionUID = 3517519941907470693L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "ADDRESS")
    protected String address;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


}