package recursion;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n^2)
 * @SpaceComplexity O(n^2)
 * @Since 2020-09-11
 * @TimeOver    100%
 * @SpaceOver   52.76%
 */
public class LastStoneWeight$1046 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Recursion\\LastStoneWeight_1046_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Recursion\\LastStoneWeight_1046_Output"));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int ans = so.nextInt();
            so.nextLine();
            int stones[] = ArrayInputUtils.stringTransToArray(inputStr);
            int res = s.lastStoneWeight(stones);
            System.out.print(res==ans);
            System.out.print("------");
            System.out.print(" "+inputStr);
            System.out.println(" "+res);
        }
    }
    private static class Solution {
        public int lastStoneWeight(int[] stones) {
            if(stones.length==1)    return stones[0];
            if(stones.length==2){
                return stones[1]==stones[0]?0:Math.abs(stones[1]-stones[0]);
            }
            int x=0,y=0,index=0,index2=0;
            for(int i=0;i<stones.length;i++){
                if(stones[i]>=x){
                    x = stones[i];
                    index = i;
                }
            }
            for(int i=0;i<stones.length;i++){
                if(i!=index&&stones[i]>=y){
                    y = stones[i];
                    index2 = i;
                }
            }
            /*System.out.println("最重石子："+x);
            System.out.println("次重石子："+y);*/
            int j=0,lastStones[];
            if(x==y){
                //System.out.println("双子相等");
                lastStones = new int[stones.length-2];
                for(int i=0;i<stones.length;i++){
                    if(i == index || i == index2)  continue;
                    lastStones[j++] = stones[i];
                    //System.out.println(stones[i]);
                }
            }else{
                //System.out.println("双子不等");
                lastStones = new int[stones.length-1];
                for(int i=0;i<stones.length;i++){
                    if(index == i)  continue;
                    if(index2 == i){
                        lastStones[j++] = Math.abs(x-y);
                        continue;
                    }
                    lastStones[j++] = stones[i];
                    //System.out.println(stones[i]);
                }
            }
            /*System.out.println(lastStones.length);
            for(int i : lastStones){
                System.out.println(i);
            }*/
            return lastStoneWeight(lastStones);
        }
    }
}
