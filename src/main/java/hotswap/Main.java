package hotswap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        int i = 0 ;

        while(true){
            MyClassLoader mcl = new MyClassLoader() ;
            System.out.println(mcl.getParent());
            Class<?> personClass =  mcl.findClass("hotswap.Person");

            try {
                Object person =  personClass.newInstance() ;
                Method sayHelloMethod = personClass.getMethod("sayHello");
                sayHelloMethod.invoke(person) ;
                System.out.println(++i);

                Field field = Person.class.getField("name");
                Object o = field.get(new Person("111"));
                System.err.println(o);
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
