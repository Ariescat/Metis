package com.metis.io.iostream;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Ariescat
 * @version 2020/3/17 12:08
 */
public class Test {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = Test.class.getResource("/test-iostream.txt");
        File file = new File(url.toURI());
        if(file.exists()) {
            System.err.println(file.getAbsolutePath());

            FileReader fileReader = new FileReader(file);
//            fileReader.read()
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            System.err.println(s);
            System.err.println(s.length());
        }
    }
}
