package test;

import proxy.Animal;
import proxy.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTestCase {

    public static void main(String[] args) {

        final Dog dog = new Dog();

        ClassLoader classLoader = dog.getClass().getClassLoader();

        Class[] interfaces = dog.getClass().getInterfaces();

        Animal animal = (Animal) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("狗跑");
                Object obj = method.invoke(dog,args);
                System.out.println("狗坐");
                return obj;

            }
        });

        animal.bark();
        animal.stop();


    }

}
