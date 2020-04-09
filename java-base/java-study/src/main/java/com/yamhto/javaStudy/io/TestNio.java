package com.yamhto.javaStudy.io;


import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * @author yamhto
 * @className: TestNio.java
 * @package com.yamhto.javaStudy.io
 * @description:
 * @date 2020/4/8 13:34
 */
public class TestNio {

    private static final String line_sep = "\n";

    public static void main(String[] args) throws IOException {
        test();

    }

    private static void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\admin_YM\\Desktop\\aaa.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));

        File file = new File("C:\\Users\\admin_YM\\Desktop\\bbb.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        while (true) {
            String str = reader.readLine();
            if(StringUtils.isNotEmpty(str)) {
                writer.append(str.replace(line_sep, "") + "@@" + "自定义" + line_sep);
            }
            if (StringUtils.isEmpty(str)) {
                break;
            }
        }
        fileInputStream.close();
        reader.close();
        writer.close();
    }
}
