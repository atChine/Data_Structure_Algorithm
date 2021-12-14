package Data_Structure.atgao.Sparse;

/**
 * @ClassName: SparseArray
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/12/14 22:28
 * @URL：https://github.com/GaoHaiNB
 */
public class SparseArray {
    public static void main(String[] args) {
            int[][] chessArr1 = new int[11][11];
            chessArr1[1][2] = 1;
            chessArr1[2][3] = 2;
            int sum = 0;

            int count;
            for(int i = 0; i < chessArr1.length; ++i) {
                for(count = 0; count < chessArr1.length; ++count) {
                    if (chessArr1[i][count] != 0) {
                        ++sum;
                    }
                }
            }

            System.out.println("sum = " + sum);
            int[][] sparseArr = new int[sum + 1][3];
            sparseArr[0][0] = chessArr1.length;
            sparseArr[0][1] = chessArr1.length;
            sparseArr[0][2] = sum;
            count = 0;

            int i;
            for(i = 0; i < chessArr1.length; ++i) {
                for(i = 0; i < chessArr1.length; ++i) {
                    if (chessArr1[i][i] != 0) {
                        ++count;
                        sparseArr[count][0] = i;
                        sparseArr[count][1] = i;
                        sparseArr[count][2] = chessArr1[i][i];
                    }
                }
            }

            System.out.println("输出稀疏数组");

            for(i = 0; i < sparseArr.length; ++i) {
                System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            }

            int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

            for(i = 1; i < sparseArr.length; ++i) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }

            int[][] var16 = chessArr2;
            int var7 = chessArr2.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                int[] row = var16[var8];
                int[] var10 = row;
                int var11 = row.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    int data = var10[var12];
                    System.out.printf("%d\t", data);
                }

                System.out.println();
            }

        }
    }
