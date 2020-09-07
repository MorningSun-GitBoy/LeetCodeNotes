package stack;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

/**
 * @TimeComplexity  O(n)
 * @SpaceComplexity O(1)
 * @Since 2020-09-07
 * @TimeOver    10.72%
 * @SpaceOver   89.90%
 */
public class ValidParentheses$20 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new FileInputStream("CaseFiles/Stack/ValidParentheses_20_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles/Stack/ValidParentheses_20_Output"));
        Solution s = new Solution();
        while(sc.hasNext()){
            String str = sc.nextLine();
            boolean ans = s.isValid(str);
            String res = so.nextLine();
            boolean result = true;
            if (res.equals("true")) result = true;
            else if (res.equals("false")) result = false;
            else System.out.println("奇怪的输出标准");
            System.out.print(ans == result);
            System.out.print("------------");
            System.out.print(str+"\t");
            System.out.println(ans);
        }
    }
    private static class Solution{
        public boolean isValid(String s){
            int n = s.length();
            if(n % 2 == 1)  return false;//如果长度是奇数一定不是完整括号
            Map<Character,Character> pairs = new HashMap<Character,Character>();
            pairs.put(')','(');
            pairs.put(']','[');
            pairs.put('}','{');
            Deque<Character> stack = new LinkedList<Character>();
            for(int i=0;i<n;i++){
                char ch = s.charAt(i);
                if(pairs.containsKey(ch)){//判断是否是后括号
                    if(stack.isEmpty() || stack.peek()!=pairs.get(ch))//不等或无值说明括号不完整
                        return false;
                    stack.pop();//相等出栈
                }else {
                    stack.push(ch);//前括号压入栈
                }
            }
            return stack.isEmpty();//全部遍历完后，如果栈不为空说明有部分没匹配，括号不完整
        }
    }
}