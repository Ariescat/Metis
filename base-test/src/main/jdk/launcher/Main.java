package launcher;

import sun.misc.Launcher;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        String bootClassPath = System.getProperty("sun.boot.class.path");
        String property = System.getProperty("java.security.manager");
        String dirs = System.getProperty("java.ext.dirs"); // ExtClassLoader
        String path = System.getProperty("java.class.path"); // AppClassLoader

        System.err.println(bootClassPath);
        System.err.println(property);
        System.err.println(dirs);
        System.err.println(path);

        Method getClassPath = Launcher.class.getDeclaredMethod("getClassPath", String.class);
        getClassPath.setAccessible(true);
        File[] files = (File[]) getClassPath.invoke(null, path);

//        Method pathToURLs = Launcher.class.getDeclaredMethod("pathToURLs", File[].class);
//        pathToURLs.setAccessible(true);
//        pathToURLs.invoke(Launcher.class, files);



        Field props = System.class.getDeclaredField("props");
        props.setAccessible(true);
        Properties properties = (Properties) props.get(null);
        System.err.println(properties.stringPropertyNames());

        ClassLoader cl = Main.class.getClassLoader();
        System.out.println("ClassLoader is:" + cl.toString());
        // AppClassLoader的parent是ExtClassLoader，ExtClassLoader的parent是null
        System.out.println("ClassLoader\'s parent is:" + cl.getParent().toString());
        System.out.println("ClassLoader\'s grand father is:" + cl.getParent().getParent().toString());

    }
}
