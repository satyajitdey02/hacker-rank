package com.skill.test.zalando.customs.tech;

import javax.management.relation.Role;
import java.util.*;

public class LiveCoding {

    public static void main(String[] args) {
        //print(3);
    }

    public String getUserName(User user) {
        return (user != null && user.getName() != null) ? user.getName() : "default";
    }
}

class User {
    private String name;
    private List<Role> roles;

    public String getName() {return name;}

    public List<Role> getRoles() {return roles;}

}
