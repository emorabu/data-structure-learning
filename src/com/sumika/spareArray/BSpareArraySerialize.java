package com.sumika.spareArray;

import java.io.*;

/**
 * 数组序列化与反序列化
 * @auther emorabu
 * @date 2019/9/14
 * @version 1.0
 */
public class BSpareArraySerialize {
    public static void main(String[] args) {
        int[][] dimensionArrSrc = ASpareArrayTransform.construct2DimensionArr();
        int[][] spareArr = ASpareArrayTransform.toSpareArr(dimensionArrSrc);

        String filePath = "f:/temp/6/map.data";
        arr2File(spareArr, filePath);

        int[][] spareArr2 = file2Arr(filePath);
        ASpareArrayTransform.print2DimensionArr(spareArr2);
    }

    /**
     * 文件还原为数组
     * @param filePath 文件路径
     * @return 二维数组
     */
    private static int[][] file2Arr(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (int[][]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new int[0][];
    }

    /**
     * 数组序列化到文件
     * @param arr 数组
     * @param filePath 文件路径
     */
    private static void arr2File(int[][] arr, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
