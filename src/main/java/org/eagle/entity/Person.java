package org.eagle.entity;

/**
 * @author ljj
 */


class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        // 方式一
        final Class<? extends Person> a1 = person.getClass();

        // 方式二
        final Class<?> a2 = Class.forName("org.eagle.entity.Student");

        // 方式三
        final Class<Student> a3 = Student.class;

        // 方式四：基本数据类型的包装类，都有一个Type属性【课外技巧】
        final Class<Integer> type = Integer.TYPE;


        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());
    }
}

class Student extends Person {

    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {

    public Teacher() {
        this.name = "老师";
    }
}