package org.eagle.entity;

import org.eagle.annotation.Field;
import org.eagle.annotation.Table;

/**
 * @author ljj
 * @description 英雄类
 */
@Table("hero")
public class Hero {
    @Field(columnName = "id", type = "String")
    private String id;

    @Field(columnName = "name", type = "String")
    private String name;

    @Field(columnName = "age", type = "int")
    private Integer age;

    public Hero() {
    }

    public Hero(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
