package com.dayjava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        try{
            dateTest();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void dateTest() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        Date d1 = df.parse("20211113091731");
        Date d2 = df.parse("20211113031731");
        long diff = d1.getTime() - d2.getTime();
        long days = diff / (60 * 60 * 24);
        long diffRange = 1000 * 60 * 60 * 6;
        System.out.println(diffRange);
        System.out.println(diff > diffRange);
        System.out.println(diff);
        System.out.println(days);
    }
}
