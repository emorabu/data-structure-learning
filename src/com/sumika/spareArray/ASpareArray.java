package com.sumika.spareArray;

/**
 * @auther emorabu
 * @date 2019/9/14
 * @version 1.0
 */
public class ASpareArray {
    public static void main(String[] args) {
        int[][] chessArrSrc = construct2DimensionArr();
        System.out.println("原始的二维数组: ");
        print2DimensionArr(chessArrSrc);

        int[][] spareArr = toSpareArr(chessArrSrc);
        System.out.println("稀疏数组:");
        print2DimensionArr(spareArr);

        int[][] chessArrDest = toOriginArr(spareArr);
        System.out.println("恢复后的二维数组");
        print2DimensionArr(chessArrDest);

    }

    /**
     * 稀疏数组转二维数组
     * @param spareArr 稀疏数组
     * @return 原始二维数组
     */
    private static int[][] toOriginArr(int[][] spareArr) {
        // 读取稀疏数组第一行, 生成二维数组
        int[][] chessArrDest = new int[spareArr[0][0]][spareArr[0][1]];
        // 读取稀疏数组第二行至最后一行
        for (int i = 1; i < spareArr.length; i++) {
            chessArrDest[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        return chessArrDest;
    }

    /**
     * 将二维数组转为稀疏数组
     *
     * @param chessArrSrc 原始二维数组
     * @return 稀疏数组
     */
    private static int[][] toSpareArr(int[][] chessArrSrc) {
        // 1. 遍历二维数组, 得到非 0 数据的个数
        int sum = 0;
        for (int[] row : chessArrSrc) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }

        // 创建对应的稀疏数组
        int[][] spareArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        // 第一行: 第一列为原始行数, 第二行为原始列数, 第三行为非 0 值(相同值)个数
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = 2;
        // 编历二维数组, 非 0 值放入
        int index = 0; // 非 0 值计数
        for (int i = 0; i < chessArrSrc.length; i++) {
            for (int j = 0; j < chessArrSrc[i].length; j++) {
                if (chessArrSrc[i][j] != 0) {
                    index++;
                    spareArr[index][0] = i;
                    spareArr[index][1] = j;
                    spareArr[index][2] = chessArrSrc[i][j];
                }
            }
        }

        return spareArr;
    }

    /**
     * 生成原始二维数组
     * @return 原始二维数组
     */
    private static int[][] construct2DimensionArr() {
        // 创建原始的二维数组, 0 表示没有棋子, 1 表示黑子, 2 表示白子
        int[][] chessArrSrc = new int[11][11];
        chessArrSrc[1][2] = 1;
        chessArrSrc[2][3] = 2;
        chessArrSrc[4][5] = 2;

        return chessArrSrc;
    }

    /**
     * 打印二维数组
     * @param arr
     *          要打印的数组
     */
    private static void print2DimensionArr(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
