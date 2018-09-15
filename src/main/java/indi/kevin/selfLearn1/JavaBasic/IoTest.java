package indi.kevin.selfLearn1.JavaBasic;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoTest {
    public static void main(String[] args) throws IOException {

        InputStreamReader iR = new InputStreamReader(new FileInputStream(new File("src/main/WEB-INF/className.properties")));
        int readChar;
        StringBuilder stringBuilder = new StringBuilder();
        while((readChar=iR.read())!=-1){
            System.out.print((char)readChar);
            stringBuilder.append((char)readChar);
        }
        System.out.println();
        System.out.println(stringBuilder.toString());


/*        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream daos = new DataOutputStream(baos);
        double randomDouble = Math.random();
        System.out.println(randomDouble);
        daos.writeDouble(randomDouble);
        daos.writeBoolean(true);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dais = new DataInputStream(bais);
        System.out.println(dais.available());
        System.out.println(dais.readDouble());
        System.out.println(dais.readBoolean());*/

    }
}
