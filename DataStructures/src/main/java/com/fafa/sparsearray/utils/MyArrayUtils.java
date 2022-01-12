package com.fafa.sparsearray.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 我的工具类
 *
 * @author Sire
 */
public class MyArrayUtils {

    /**
     * 循环遍历
     */
    public void queryAll(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 获取有效的数字个数
     *
     * @param arr 数组
     * @return
     */
    public int valueNum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    /**
     * 将稀疏数组存盘
     *
     * @param sparseArray
     */
    public void saveToFile(int[][] sparseArray) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("src/sparseArray.txt"));
            for (int[] array : sparseArray) {
                fileWriter.write(array[0] + "\t" + array[1] + "\t" + array[2]);
                // \r是回车符,\n是换行符
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从磁盘中读取稀疏数组
     *
     * @return
     */
    public int[][] readFromFile() {
        int[][] sparseArray2 = null;
        boolean isNotRead = false;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("src/sparseArray.txt")));
            String lineStr = null;
            int curCount = 0;
            while ((lineStr = bufferedReader.readLine()) != null) {
                String[] tempStr = lineStr.split("\t");
                if (!isNotRead) {
                    sparseArray2 = new int[Integer.parseInt(tempStr[2]) + 1][3];
                    sparseArray2[curCount][0] = Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1] = Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2] = Integer.parseInt(tempStr[2]);
                    curCount++;
                    isNotRead = true;
                } else {
                    sparseArray2[curCount][0] = Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1] = Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2] = Integer.parseInt(tempStr[2]);
                    curCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArray2;
    }


}
