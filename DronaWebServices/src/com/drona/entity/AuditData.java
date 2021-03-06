//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * To store audit data
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 17, 2015
 */
@Embeddable
public class AuditData {

    

    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false)
    private Calendar createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE")
    private Calendar lastModifiedDate;

    @Column(name = "AUTHENTICATED_BY")
    private Long authenticatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUTHENTICATED_DATE")
    private Calendar authenticatedDate;   

    public AuditData() {
        super();
    }

    private AuditData(Long createdBy) {
        super();       
        this.createdBy = createdBy;
        this.createdDate = GregorianCalendar.getInstance();
     }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getAuthenticatedBy() {
        return authenticatedBy;
    }

    public void setAuthenticatedBy(long authenticatedBy) {
        this.authenticatedBy = authenticatedBy;
    }

    public Calendar getAuthenticatedDate() {
        return authenticatedDate;
    }

    public void setAuthenticatedDate(Calendar authenticatedDate) {
        this.authenticatedDate = authenticatedDate;
    }


}
