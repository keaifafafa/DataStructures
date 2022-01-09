package com.fafa.recurison;

/**
 * 迷宫问题
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-08 15:13
 */
public class MazeDemo {
    public static void main(String[] args) {
        // 创建二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 初始化迷宫
        initMap(map);
        // 显示迷宫
        System.out.println("    ====地图界面====");
        showMap(map);
        // 寻路
        findWay(map, 1, 1);
        System.out.println("    ====寻路路线====");
        showMap(map);
    }

    /**
     * 初始化迷宫
     *
     * @param map
     */
    public static void initMap(int[][] map) {
        // 将上下左右最外层置为1（表示墙）
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 行
                if (i == 0 || i == 7) {
                    map[i][j] = 1;
                }
                // 列
                else if (j == 0 || j == 6) {
                    map[i][j] = 1;
                }
            }
        }
        // 挡板
        map[3][1] = 1;
        map[3][2] = 1;
        /*map[1][2] = 1;
        map[2][2] = 1;*/
    }

    /**
     * 显示迷宫
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
     * 迷宫寻路
     * 说明：
     * 1、map表示地图
     * 2、i，j 表示从那个地方开始出发（默认 1，1）
     * 3、如果小球能到map[6][5]位置，则说明通路找到
     * 4、约定：0表示为未走过，1表示墙，2表示路可以走通，3表示该点已走过但是行不通
     * 5、走迷宫的策略：下->右->上->左，如果该点走不通，再回溯
     * @param map 地图
     * @param i
     * @param j
     * @return 如果找到返回true，否则，返回false
     */
    public static boolean findWay(int[][] map, int i, int j) {
        // 递归头，结束标志,通路已经找到
        if (map[6][5] == 2) {
            return true;
        } else {
            // 如果没走过
            if (map[i][j] == 0) {
                // 假设可以走通
                map[i][j] = 2;
                // 然后依次试探：下->右->上->左
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 也就是map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3
                return false;
            }
        }
    }
}
