package phy.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
        
        //获取键盘输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.print("你的姓名：");
            String name = in.nextLine();
            System.out.println("Hello," + name);
        }

        
        //Scanner读取文件
//        Scanner fileIn = new Scanner(new File("D:\\NetBeansProjects\\PHY\\src\\README.txt"));
//        while(fileIn.hasNext()) {
//            System.out.println(fileIn.nextLine());
//        }
    }
}
