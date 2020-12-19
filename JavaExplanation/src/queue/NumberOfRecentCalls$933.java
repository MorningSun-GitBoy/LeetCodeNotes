package queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfRecentCalls$933 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Queue\\NumberOfRecentCalls_933_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Queue\\NumberOfRecentCalls_933_Output"));
        RecentCounter rc = null;
        while(sc.hasNext()){
            String commendStr = sc.nextLine();
            String paramStr = sc.nextLine();
            String resStr = so.nextLine();
            String comArr[] = commendStr.substring(1,commendStr.length()-1).split(", ");
            String paramArr[] = paramStr.substring(1,paramStr.length()-1).split(", ");
            String resArr[] = resStr.substring(1,resStr.length()-1).split(", ");
            StringBuilder resuStr = new StringBuilder();
            resuStr.append("[");
            boolean isEquals = true;
            int res;
            for(int i=0;i<comArr.length;i++){
                if(comArr[i].substring(1,comArr[i].length()-1).equals("RecentCounter")) {
                    rc = new RecentCounter();
                    resuStr.append("null,");
                }
                if(comArr[i].substring(1,comArr[i].length()-1).equals("ping")){
                    res = rc.ping(Integer.valueOf(paramArr[i].substring(1,paramArr[i].length()-1)));
                    isEquals = isEquals && (res==Integer.valueOf(resArr[i]));
                    resuStr.append(res);
                    resuStr.append(",");
                }
            }
            resuStr.deleteCharAt(resuStr.length()-1);
            resuStr.append("]");
            System.out.println(isEquals);
            System.out.println("输入：");
            System.out.println(commendStr);
            System.out.println(paramStr);
            System.out.println("输出：");
            System.out.println(resuStr.toString());
        }
    }
    private static class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<Integer>();
        }

        public int ping(int t) {
            q.add(t);
            while(q.peek()<t-3000){
                q.poll();
            }
            return q.size();
        }
    }
}
