package linecoding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
   
   static Queue<Integer> queueConi = new LinkedList<>();
   static Queue<Integer> queuebrown = new LinkedList<>();
   static Queue<Integer> queueTime = new LinkedList<>();

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int coni = sc.nextInt();
      int brown = sc.nextInt();
      int time = 0;
      sc.close();
      while(true) {
         if (coni == brown) {
            System.out.println(time);
            System.exit(0);
         }
         
         queueConi.add(coni + (time + 1));
         queuebrown.add(brown - 1);
         queueTime.add(time + 1);
         
         queueConi.add(coni + (time + 1));
         queuebrown.add(brown + 1);
         queueTime.add(time + 1);
         
         queueConi.add(coni + (time + 1));
         queuebrown.add(brown * 2);
         queueTime.add(time + 1);
         
         coni = queueConi.poll();
         brown = queuebrown.poll();
         time = queueTime.poll();
      }
   }
}