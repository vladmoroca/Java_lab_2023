package Java_lab_2023.lab_2;

import java.util.Arrays;


public class Lab2 {
    /* 
    variant 1121
    C5 = 1
    Транспонування
    С7 = 1
    byte
    С11 = 10
    Знайти середнє значення елементів матриці
    */

    public static void main(String[] args) throws Exception {
        byte[][] byteMatrix = {
        {115, -78, -38, 42, 19},
        {90, -52, 79, 33, -124},
        {21, -39, -53, 66, 11},
        {-83, 29, -18, 97, 5}
        };
        byte[][] trans = transponse(byteMatrix);
        double averageNum = average(trans);
    }
        
    public static byte[][] transponse(byte[][] byteMatrix) throws Exception {
        byte[][] trans = new byte[byteMatrix[0].length][byteMatrix.length];

        for (int i = 0; i < byteMatrix.length; i++) {
            if(byteMatrix[i].length != byteMatrix[0].length){
                throw new Exception("Incorrect matrix");
            }
            for (int j = 0; j < byteMatrix[0].length; j++) {
                trans[j][i] = byteMatrix[i][j];
            }
        }

        System.out.println("Transposed matrix:");
        for (byte[] row : trans) {
            System.out.println(Arrays.toString(row));
        }
        return trans;
    }

    public static double average(byte[][] trans) throws Exception{
        int sum = 0;
        int num = 0;
        double averageNum = 0;
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[0].length; j++) {
                sum += trans[i][j];
                num += 1;
            }
        }
        System.out.println(num);
        if (num == 0) {
            throw new Exception("Empty matrix");
        } else {
            averageNum = (double)sum / num;
            System.out.println("average:");
            System.out.println(averageNum);
        }
        return averageNum;
    }
}
