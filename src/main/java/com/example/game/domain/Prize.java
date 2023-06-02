package com.example.game.domain;

public class Prize {
    private String name;

    private Integer id;

    private static Integer index = 0;

    public Prize(String name) {
        this.name = name;
        this.id = index;
        index++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
