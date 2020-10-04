package com.giga.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents the user role.
 */
@Entity(name = "roles")
public class Role {
    @Id
    private String roleID;
    private Roles name;

    public Role(String roleID, Roles name) {
        this.roleID = roleID;
        this.name = name;
    }

    // getters
    public String getRoleID() {
        return roleID;
    }

    public Roles getRoleName() {
        return name;
    }

    // setters
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(Roles name) {
        this.name = name;
    }
}