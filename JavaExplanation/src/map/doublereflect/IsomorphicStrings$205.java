package map.doublereflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n) n 字符串长度
 * @SpaceComplexity O(m) m 字符集长度
 * @Since 2020-12-27
 * @TimeOver    70.00%
 * @SpaceOver   46.02%
 */
public class IsomorphicStrings$205 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Map\\IsomorphicStrings_205_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Map\\IsomorphicStrings_205_Output"));
        Solution solution = new Solution();
        while(sc.hasNext()){
            String inStr = sc.nextLine();
            String resStr = so.nextLine();
            String[] params = inStr.replace("\"","").split(",");
            boolean res = Boolean.valueOf(resStr);
            System.out.print(res==solution.isIsomorphic(params[0],params[1]));
            System.out.print("------");
            System.out.println(inStr+"  "+resStr);
        }
    }
    private static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length()!=t.length())  return false;
            Map<Character,Character> reflect = new HashMap<Character,Character>();//正向映射
            Map<Character,Character> reflect2 = new HashMap<Character,Character>();//反向映射
            boolean flag = true;
            int i = 0;
            Character c = null;
            while(flag&&(i<s.length())){
                if((c = reflect.get(s.charAt(i)))==null){//检查正向映射
                    if(null == reflect2.get(t.charAt(i))){//检查反向映射
                        reflect.put(s.charAt(i),t.charAt(i));
                        reflect2.put(t.charAt(i),s.charAt(i));
                    }else return false;
                }else{
                    flag = c.equals(Character.valueOf(t.charAt(i)));
                }
                i++;
            }
            return flag;
        }
    }
}
