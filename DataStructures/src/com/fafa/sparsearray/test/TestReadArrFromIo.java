package com.fafa.sparsearray.test;

import com.fafa.sparsearray.utils.MyArrayUtils;

/**
 * 测试从IO文件中读取稀疏数组
 * @author Sire
 * @version 1.0
 * @date 2021-12-28 21:29
 */
public class TestReadArrFromIo {

    public static void main(String[] args) {
        MyArrayUtils utils = new MyArrayUtils();
        int[][] sparseArr = utils.readFromFile();
        utils.queryAll(sparseArr);
    }

}
