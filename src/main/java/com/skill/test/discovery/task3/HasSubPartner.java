package com.skill.test.discovery.task3;

public interface HasSubPartner {
    void add(Partner partner);

    void remove(Partner partner);

    Partner getPartner(int index);
}
