package org.eagle.generics;

/**
 * @author ljj
 * @description 泛型接口的实现类，不是泛型类，必须固定泛型类型
 */
@SuppressWarnings("all")
public class GenericInterfaceOne implements GenericInterface<String> {

    @Override
    public String getTest() {
        return null;
    }

    @Override
    public void setTest(String test) {

    }

    /**
     * <p>泛型方法</p>
     * 【访问修饰符】与【返回值】之间声明了【泛型列表】的方法，才是【泛型方法】
     * 使用【泛型】的方法不是泛型方法
     * 【泛型方法】的【泛型标识】独立于【泛型类】，即使与【泛型类的泛型标识相同】，也不影响【泛型方法】指定【泛型类型】
     * 【泛型类的成员方法】不能设置为【静态方法】，【泛型方法】可以声明为【静态方法】
     */
    public <T,E,K,V> void look(String test) {

    }
}
