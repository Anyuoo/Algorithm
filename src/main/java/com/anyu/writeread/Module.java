package com.anyu.writeread;

import java.io.IOException;
import java.util.Scanner;

/**
 * java输入输出模板,字符串分割
 * 1.Scanner
 * 2.BufferedReader
 * 例子：生成一个二维数组
 * 第一行： 2 3
 * 第二行： 1 2 3
 * 第三行： 4 5 6
 */
public class Module {
    public static void main(String[] args) throws IOException {
        //Scanner
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");//读入一行数据，空格分割成字符串
        int row = Integer.valueOf(strs[0]);
        int col = Integer.valueOf(strs[1]);
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] data = in.nextLine().split(" ");
            for (int j = 0; j < col; j++)
                nums[i][j] = Integer.valueOf(data[j]);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d\t", nums[i][j]);
            }
            System.out.println();
        }
        //BufferedReader
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String[] strs1=br.readLine().split(" ");
//        int row = Integer.valueOf(strs[0]);
//        int col = Integer.valueOf(strs[1]);
//        int[][] nums=new int[row][col];
//        for (int i = 0; i < row; i++) {
//            String[] data = br.readLine().split(" ");
//            for (int j = 0; j < col; j++)
//                nums[i][j] = Integer.valueOf(data[j]);
//        }
//        for (int i = 0; i <row ; i++) {
//            for (int j = 0; j <col ; j++) {
//                System.out.printf("%d\t",nums[i][j]);
//            }
//            System.out.println();
//        }
    }
}
