package indi.kevin.selfLearn1.JavaBasic;

import java.io.*;
import java.util.Date;

public class StreamWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter("E://outPutText.txt",true);
        PrintWriter pw = new PrintWriter(fileWriter);
        String s = null;
        while((s=br.readLine())!=null){
            if(s.equals("exit")) break;
            System.out.println(s.toUpperCase());/*
            pw.println("--------");
            pw.println(s);
            pw.flush();*/
            fileWriter.write("--------");
            fileWriter.write(s);
            fileWriter.flush();
        }
        pw.println("========"+new Date()+"========");
        pw.flush();
        pw.close();
    }
}
