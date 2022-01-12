package com.fafa.sparsearray;

import com.fafa.sparsearray.utils.MyArrayUtils;

/**
 * 稀疏数组实现
 * @author Sire
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		// 实例化工具类对象 减少代码冗余
		MyArrayUtils utils = new MyArrayUtils();
		/** 
		 * 创建一个11*11的二维数组 
		 * 
		 ***/ 
		// 0：表示没有棋子，1：黑子，2：蓝子
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][4] = 2;
		chessArr1[5][4] = 1;
		chessArr1[6][4] = 2;
		chessArr1[7][4] = 1;
		// 循环遍历(输出原始的二维数组)
		System.out.println("====原始二维数组====");
		utils.queryAll(chessArr1);
		/** 
		 * 将二维数组 转 稀疏数组的思路 
		 * 
		 ***/ 
		// 1、先遍历二维数组 得到非0数据的个数
		int sum = 0;
		sum = utils.valueNum(chessArr1);
		System.out.println("sum = " + sum);
		
		// 2、创建对应的稀疏数组
		int[][] sparseArr = new int[sum + 1][3];
		// 行
		sparseArr[0][0] = 11;
		// 列
		sparseArr[0][1] = 11;
		// 值
		sparseArr[0][2] = sum;
		// 基数所用，针对的是行数
		int count = 1;
		/**
		 * 思路：
		 * 循环遍历  chessArr1 数组，只要不等于0，就将值赋到 稀疏数组中
		 */
		for(int i = 0; i < chessArr1.length; i++){
			for(int j = 0; j < chessArr1[i].length; j++){
				if(chessArr1[i][j] != 0){
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
					// 进行累加
					count++;
				}
			}
		}
		
		System.out.println("====稀疏数组====");
		utils.queryAll(sparseArr);
		// 存储稀疏数组到磁盘里
		utils.saveToFile(sparseArr);
		
		/** 
		 * 将稀疏数组还原
		 * 
		 ***/
		// 1、创建一个同等大小的数组
		int [][] transform = new int [sparseArr[0][0]][sparseArr[0][1]];
		// 2、利用 循环 将稀疏数组值，复制到对应的 还原数组中去
		for(int i = 1; i < sparseArr.length; i++){
			transform[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println("====还原后的数组====");
		utils.queryAll(transform);
		
	}
}
