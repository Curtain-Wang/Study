package com.study.core.algorithm;

import tk.mybatis.mapper.util.StringUtil;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/4 11:29
 * @description：编辑距离的动态规划算法
 */
public class BjjlDtgh {

    public static int getBjjl(String A, String B){
        int bjjl = 0;
        char A1[] = A.toCharArray();
        char B1[] = B.toCharArray();
        int[][] C = new int[A.length()+1][B.length()+1];

        for (int i = 0; i <= A.length(); i++)
            C[i][0] = i;

        for (int i = 1; i <= B.length(); i++)                  // 这个嵌套for循环就是填表的过程
        {
            C[0][i] = i;
            for (int j = 1; j <= A.length(); j++)
            {
                if (A1[j-1] == B1[i-1])
                    C[j][i] = C[j - 1][i - 1];
                else
                    C[j][i] = min(C[j-1][i], C[j-1][i-1], C[j][i-1]) + 1;
            }
        }
        //打印二维数组
//        for (int i = 0; i <= A.length(); i++){
//            for (int j = 0; j <= B.length(); j++){
//                System.out.print(C[i][j] + "    ");
//            }
//            System.out.println();
//        }
        bjjl = C[A.length()][B.length()];// 最后输出右下角的值
        return bjjl;
    }

    private static int min(int i, int j, int k) {
        // TODO Auto-generated method stub
        if (i < j)
            j = i;
        if (k < j)
            j = k;
        return j;
    }

    public static void main(String[] args) {
        getBjjl("sout", "stous");
    }
}
