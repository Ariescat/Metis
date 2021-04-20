package com.ariescat.metis.base.string;

public class CharacterisTitleCaseDemo {

    public static void main(String[] args) {
        String str="www.51gjie.com";

        char[] buffer = str.toCharArray();

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];

            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);

            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);

            } else if (Character.isLowerCase(ch)) {
                buffer[i] = Character.toUpperCase(ch);

            }

        }

        String str2 = new String(buffer);

        System.out.println(str2);

    }
}
