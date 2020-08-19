package com.study.core.algorithm;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/4 15:02
 * @description：编辑距离动态规划的滚动数组优化
 */
public class BjjlGdsz {

    public static int getBjjl(String A, String B){
         int bjjl = 0;
        char A1[] = A.toCharArray();
        char B1[] = B.toCharArray();
        int[] C_OLD = new int[B.length() + 1]; //存储表格的第i-1行
        int[] C_NEW = new int[B.length() + 1]; //存储表格的第i行

        for (int i = 0; i <=B.length(); i++){
            C_OLD[i] = i;
            //System.out.print(C_OLD[i] + "   ");
        }
        //System.out.println();
        for (int i = 1; i <= A.length(); i++){
            C_NEW[0] = i;
            //System.out.print(C_NEW[0] + "   ");
            for (int j = 1; j <= B.length(); j++){
                if (A1[i-1] == B1[j-1])
                    C_NEW[j] = C_OLD[j-1];
                else
                    C_NEW[j] = min(C_NEW[j-1], C_OLD[j], C_OLD[j-1]) + 1;
                //System.out.print(C_NEW[j] + "   ");
            }
            C_OLD = C_NEW.clone(); //将第i行的数据给OLD 然后继续填写NEW的数据
            //System.out.println();
        }
        bjjl = C_NEW[B.length()];
         return bjjl;
    }

    private static int min(int a, int b, int c) {
        if (a < b)
            b = a;
        if (c < b)
            b = c;
        return b;
    }

    public static void main(String[] args) {
        getBjjl("math", "mouth");
    }
}
