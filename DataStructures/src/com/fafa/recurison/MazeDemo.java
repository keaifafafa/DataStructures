package com.fafa.recurison;

/**
 * �Թ�����
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-08 15:13
 */
public class MazeDemo {
    public static void main(String[] args) {
        // ������ά���飬ģ���Թ�
        // ��ͼ
        int[][] map = new int[8][7];
        // ��ʼ���Թ�
        initMap(map);
        // ��ʾ�Թ�
        System.out.println("    ====��ͼ����====");
        showMap(map);
        // Ѱ·
        findWay(map, 1, 1);
        System.out.println("    ====Ѱ··��====");
        showMap(map);
    }

    /**
     * ��ʼ���Թ�
     *
     * @param map
     */
    public static void initMap(int[][] map) {
        // �����������������Ϊ1����ʾǽ��
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // ��
                if (i == 0 || i == 7) {
                    map[i][j] = 1;
                }
                // ��
                else if (j == 0 || j == 6) {
                    map[i][j] = 1;
                }
            }
        }
        // ����
        map[3][1] = 1;
        map[3][2] = 1;
        /*map[1][2] = 1;
        map[2][2] = 1;*/
    }

    /**
     * ��ʾ�Թ�
     *
     * @param map
     */
    public static void showMap(int[][] map) {
        for (int[] row : map) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }

    /**
     * �Թ�Ѱ·
     * ˵����
     * 1��map��ʾ��ͼ
     * 2��i��j ��ʾ���Ǹ��ط���ʼ������Ĭ�� 1��1��
     * 3�����С���ܵ�map[6][5]λ�ã���˵��ͨ·�ҵ�
     * 4��Լ����0��ʾΪδ�߹���1��ʾǽ��2��ʾ·������ͨ��3��ʾ�õ����߹������в�ͨ
     * 5�����Թ��Ĳ��ԣ���->��->��->������õ��߲�ͨ���ٻ���
     * @param map ��ͼ
     * @param i
     * @param j
     * @return ����ҵ�����true�����򣬷���false
     */
    public static boolean findWay(int[][] map, int i, int j) {
        // �ݹ�ͷ��������־,ͨ·�Ѿ��ҵ�
        if (map[6][5] == 2) {
            return true;
        } else {
            // ���û�߹�
            if (map[i][j] == 0) {
                // ���������ͨ
                map[i][j] = 2;
                // Ȼ��������̽����->��->��->��
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    // ��·
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // Ҳ����map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3
                return false;
            }
        }
    }
}
