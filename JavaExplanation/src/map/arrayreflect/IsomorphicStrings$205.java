package map.arrayreflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n) n 字符串长度
 * @SpaceComplexity O(1)
 * @Since 2020-12-27
 * @TimeOver    94.33%
 * @SpaceOver   96.71%
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
    private static class Solution{
        public boolean isIsomorphic(String s, String t) {
            if(s.length()!=t.length())  return false;
            int sm[] = new int[128];
            int tm[] = new int[128];
            char sc[] = s.toCharArray();
            char tc[] = t.toCharArray();
            for(int i=0;i<s.length();i++){
                if(sm[sc[i]]!=tm[tc[i]])
                    return false;
                sm[sc[i]] = tm[tc[i]] = i+1;
            }
            return true;
        }
    }
}
