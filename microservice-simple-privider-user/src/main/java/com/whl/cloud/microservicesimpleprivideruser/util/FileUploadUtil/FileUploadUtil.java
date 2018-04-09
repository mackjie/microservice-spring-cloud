package com.whl.cloud.microservicesimpleprivideruser.util.FileUploadUtil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * FileUploadUtil
 * TODO:
 * 2018/4/814:02
 * 1.0
 * hlwu
 * 输入输出流都是相对于程序而言，都是站在程序角度来说的
 * Reader 读文件 Writer 写文内容
 * FileInputStream、FileOutputStream、FileReader、FileWriter针对文件进行的读写操作
 * InputStream、OutputStream、Reader、Writer
 * 转换流:InputStreamReader、OutputStreamWriter把字节流转换为字符流
 */
public class FileUploadUtil {
    public static void main(String[] args) throws IOException {

    }

    @DisplayName("处理流")
    @Test
    public void fileBufferStream() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\visio\\makcjie.txt"));
        BufferedReader br = new BufferedReader(new FileReader("D:\\visio\\makcjie.txt"));
        int b = br.read();
        String str = null;
        for (int i=0;i<10;i++){
            str = String.valueOf(Math.random());
            System.out.println("当前输入的随机数位："+str);
            //写入数据
            bw.write(str);
            //换行
            bw.newLine();
        }
        bw.flush();//刷新将缓存中的数据全部些人文件中
        //br.readLine():当读到换行标记'\n'、'\r'（回车）时，会跟着换行，同时会以字符串形式返回这一行的数据
        while ((str = br.readLine()) !=null ){
            //整行整行的取数据
            System.out.println(str);
        }
        bw.close();
        br.close();
    }

    @Test
    @DisplayName("字符流")
    public void fileCharStramTest() throws IOException {
        File oldfile = new File("D:\\visio\\三叉街资讯网.txt");
        File newfile = new File("D:\\visio\\makcjie.txt");
        FileReader fileReader = new FileReader(oldfile);
        FileWriter fileWriter = new FileWriter(newfile);
        int b;
        if(!oldfile.getParentFile().exists()){
            oldfile.mkdir();
        }
        if(!oldfile.getParentFile().exists()){
            oldfile.mkdir();
        }
        if(newfile.exists()){
            //如果存在就删除文件
            newfile.delete();
        }
        //创建新的、空的文件
        newfile.createNewFile();
        while((b=fileReader.read()) != -1){
            System.out.println((char)b);
            fileWriter.write(b);
        }
        fileReader.close();
        fileWriter.close();
    }

    @Test
    @DisplayName("字节流")
    public void fileByteStreamTest() throws IOException, InterruptedException {

       //使用字节流读取方式，以字节形式进行读取，返回（010101...）不能正常显示打印
        //找到源文件
        File file = new File("D:\\visio\\三叉街资讯网.txt");
        if(!file.getParentFile().exists()){
            file.mkdir();
        }
        //创建输入管道（读文件）
        FileInputStream fis = new FileInputStream(file);
        //创建输出管道(往文件中写内容)
        FileOutputStream out = new FileOutputStream("D:\\visio\\makcjie.txt");
        int num = 0;
        int byt;
        //开始读源文件中的内容，.read（）方法，如果返回-1则已经表示读完，否则就返回内容
        while ((byt = fis.read()) != -1){
            System.out.print((char)byt);
            out.write(byt);
            num++;
        }
        System.out.println("总共字符数为："+num);
        fis.close();

        System.out.println("-----------------------------------------------------------------------------------");
        //使用字符流进行读取
        FileReader fr = new FileReader(file);
        if((byt=fr.read()) != -1 ){
            System.out.println((char)fr.read());
        }
        fr.close();

        //输出流：向文件中写入数据
    }
}

