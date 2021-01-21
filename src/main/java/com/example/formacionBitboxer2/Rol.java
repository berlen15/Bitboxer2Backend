package com.example.formacionBitboxer2;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Rol {
    ADMIN("ADMIN"),
    USER("USER"),
    ALL("ALL");

    public final String name;

    Rol(String s){
        name=s;
    }

    public String getName() {
        return name;
    }
}
