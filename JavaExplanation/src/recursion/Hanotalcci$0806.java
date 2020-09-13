package recursion;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n+nlogn)
 * @SpaceComplexity O(n)
 * @Since 2020-09-11
 * @TimeOver    83.86%
 * @SpaceOver   87.98%
 */
public class Hanotalcci$0806 {
    public static void main(String[] args) throws Exception{
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Recursion\\HanotaIcci_0806_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Recursion\\HanotaIcci_0806_Output"));
        while(sc.hasNext()){
            String firstStr = sc.nextLine();
            String secondStr = sc.nextLine();
            String thirdStr = sc.nextLine();
            String resStr = so.nextLine();
            List<Integer> A = new ArrayList<Integer>();
            List<Integer> B = new ArrayList<Integer>();
            List<Integer> C = new ArrayList<Integer>();
            String first = firstStr.substring(1,firstStr.length()-1);
            String second = secondStr.substring(1,secondStr.length()-1);
            String third = thirdStr.substring(1,thirdStr.length()-1);
            /*System.out.println(firstStr);
            System.out.println(secondStr);
            System.out.println(thirdStr);*/
            filledList(A,first);
            filledList(B,second);
            filledList(C,third);
            /*System.out.println(A);
            System.out.println(B);
            System.out.println(C);*/
            s.hanota(A,B,C);
            System.out.print(resStr.equals(C.toString()));
            System.out.print("------");
            System.out.println(firstStr+"\t"+secondStr+"\t"+thirdStr+"\t"+C.toString());
        }
    }
    private static class Solution {
        /**
         * 将 A 上的所有盘子，借助 B，移动到C 上
         * @param A 原柱子
         * @param B 辅助柱子
         * @param C 目标柱子
         */
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            movePlate(A.size(), A, B, C);
        }

        private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
            if (num == 1) {    // 只剩一个盘子时，直接移动即可
                target.add(original.remove(original.size() - 1));
                return;
            }

            movePlate(num - 1, original, target, auxiliary);   // 将 size-1 个盘子，从 original 移动到 auxiliary
            target.add(original.remove(original.size() - 1));   // 将 第size个盘子，从 original 移动到 target
            movePlate(num - 1, auxiliary, original, target);   // 将 size-1 个盘子，从 auxiliary 移动到 target
        }
    }
    private static void filledList(List<Integer> list,String str){
        if(str.length()<1&&!str.contains(","))
            return;
        String[] strs = str.split(",");
        for(String intStr:strs){
            list.add(new Integer(intStr));
        }
    }
}
