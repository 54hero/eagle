package org.eagle.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ljj
 */
class Person {
    private String name;

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

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Person person = new Student();
        System.out.println(person.name);

        // ************** 获取类本身的 Class 对象 **************
        // 方式一
        final Class<? extends Person> a1 = person.getClass();
        // 方式二
        final Class<?> a2 = Class.forName("org.eagle.entity.Student");
        // 方式三
        final Class<Student> a3 = Student.class;
        // 方式四：基本数据类型的包装类，都有一个Type属性【课外技巧】
        final Class<Integer> type = Integer.TYPE;

        System.out.println(a1);
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());

        // ************** 获取父类的 Class 对象 **************
        final Class<?> superclass = a1.getSuperclass();
        System.out.println(superclass);

        // 获取类名
        System.out.println(superclass.getName());
        System.out.println(superclass.getSimpleName());

        // 获得类的属性
        // getFields() 只能获取 public 修饰的字段
        // getDeclaredFields() 可以获取所有字段
        final Field[] fields = superclass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        final Field[] declaredFields = superclass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        /* System.out.println(superclass.getField("name")); */
        System.out.println(superclass.getDeclaredField("name"));

        // 获取类的方法
        // getMethods 获取本类及其父类的所有 public 方法
        // declaredMethods 获取本类的所有方法
        final Method[] methods = superclass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println(" ++++++++++++++++++++++++++++++++++++++ ");
        final Method[] declaredMethods = superclass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}

class Student extends Person {

    public Student() {
        super("学生");
    }
}

class Teacher extends Person {

    public Teacher() {
        super("老师");
    }
}