package com.fafa.sparsearray;

import com.fafa.sparsearray.utils.MyArrayUtils;

/**
 * ϡ������ʵ��
 * @author Sire
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		// ʵ������������� ���ٴ�������
		MyArrayUtils utils = new MyArrayUtils();
		/** 
		 * ����һ��11*11�Ķ�ά���� 
		 * 
		 ***/ 
		// 0����ʾû�����ӣ�1�����ӣ�2������
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][4] = 2;
		chessArr1[5][4] = 1;
		chessArr1[6][4] = 2;
		chessArr1[7][4] = 1;
		// ѭ������(���ԭʼ�Ķ�ά����)
		System.out.println("====ԭʼ��ά����====");
		utils.queryAll(chessArr1);
		/** 
		 * ����ά���� ת ϡ�������˼· 
		 * 
		 ***/ 
		// 1���ȱ�����ά���� �õ���0���ݵĸ���
		int sum = 0;
		sum = utils.valueNum(chessArr1);
		System.out.println("sum = " + sum);
		
		// 2��������Ӧ��ϡ������
		int[][] sparseArr = new int[sum + 1][3];
		// ��
		sparseArr[0][0] = 11;
		// ��
		sparseArr[0][1] = 11;
		// ֵ
		sparseArr[0][2] = sum;
		// �������ã���Ե�������
		int count = 1;
		/**
		 * ˼·��
		 * ѭ������  chessArr1 ���飬ֻҪ������0���ͽ�ֵ���� ϡ��������
		 */
		for(int i = 0; i < chessArr1.length; i++){
			for(int j = 0; j < chessArr1[i].length; j++){
				if(chessArr1[i][j] != 0){
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
					// �����ۼ�
					count++;
				}
			}
		}
		
		System.out.println("====ϡ������====");
		utils.queryAll(sparseArr);
		// �洢ϡ�����鵽������
		utils.saveToFile(sparseArr);
		
		/** 
		 * ��ϡ�����黹ԭ
		 * 
		 ***/
		// 1������һ��ͬ�ȴ�С������
		int [][] transform = new int [sparseArr[0][0]][sparseArr[0][1]];
		// 2������ ѭ�� ��ϡ������ֵ�����Ƶ���Ӧ�� ��ԭ������ȥ
		for(int i = 1; i < sparseArr.length; i++){
			transform[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println("====��ԭ�������====");
		utils.queryAll(transform);
		
	}
}
