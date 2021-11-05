package com.skill.test.discovery.task3;

public class Contract {
    private ContractType type;

    public Contract(ContractType type) {
        this.type = type;
    }

    public ContractType getType() {
        return type;
    }

    public void setType(ContractType type) {
        this.type = type;
    }
}
