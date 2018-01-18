package com.sqlite.models;

public class CustomerVo {
 
    private Long id;
    private String firstName;
    private String lastName;

    protected CustomerVo() {}

    public CustomerVo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}