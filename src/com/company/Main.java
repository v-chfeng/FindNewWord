package com.company;

import com.company.common.TextDatReader;
import com.company.text.evolution.NewWordDiscover;

import java.io.*;
import java.util.Set;


public class Main {

    private final static String path = "C:/Users/v-chfeng/IdeaProjects/TestJava/text.dat";//"text.dat";
    private final static String outPath = "./out.txt";

    public static void main(String[] args) throws IOException {
	// write your code here
        String document = TextDatReader.read(path);

        NewWordDiscover discover = new NewWordDiscover();
        long start = System.currentTimeMillis();
        Set<String> words = discover.discover(document);
        File outFile = new File(outPath);
        FileOutputStream fos = new FileOutputStream(outFile);

        words.forEach(k -> {
            try {
                fos.write((k+ "\r\n").getBytes("UTF-8"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        fos.close();

        System.out.println("Speed: " + (double) document.length()
                / (System.currentTimeMillis() - start) * 1000);
        System.out.println("New words size: " + words.size());

        System.out.printf("hello world!");
    }
}
