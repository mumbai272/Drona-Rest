//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Entity
@Table(name = "Groups",uniqueConstraints=@UniqueConstraint(columnNames={"groupName"}))
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(unique=true)
    private String groupName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_Group", joinColumns = { @JoinColumn(name = "groupId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
    private List<User> users = new ArrayList<User>();

    public Group() {
        super();
    }

    public Group(String groupName, Long groupId, List<User> users) {
        super();
        this.groupName = groupName;
        this.groupId = groupId;
        this.users = users;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
