package 민정이숙제;
import java.util.Scanner;

interface Stack {
   int length(); //현재 스택에 저장된 개수 리턴
   int capacity(); //스택의 전체 저장 가능한 개수 리턴
   String pop(); //스택의 top에 실수 저장
   boolean push(String val); //스택의 top에 저장된 실수 리턴
}

class StringStack implements Stack {
   int num; //저장한 개수
   int len; //저장가능한 개수
   String [] stack;
   
   public StringStack(int len) {
      this.num = 0;
      this.len = len;
      stack = new String[len];
   }
   public int length() {
      return num;
   }
   public int capacity() {
      return len;
   }
   public String pop() {
      if(num < 0) //stack이 비어있음
         return null;
      //num--;
      String key = stack[--num];
      return key;
   }
   public boolean push(String val) {
      if(num < len) {
         stack[num] = val;
         num++;
         return true;
      }
      else 
         return false;

   }
}
public class StackApp {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("총 스택 저장 공간의 크기 입력>>");
      int size = sc.nextInt();
      
      StringStack st = new StringStack(size);

      while(true) {
         System.out.print("문자열 입력 >> ");
         String str = sc.next();
         
         if(str.equals("그만"))
            break;
         if(!st.push(str))
            System.out.println("스택이 꽉 차서 푸시 불가!");
      }
      System.out.print("스택에 저장된 모든 문자열 팝 : ");
      int len = st.length();
      for(int i=0;i<len;i++) {
         String str = st.pop();
         System.out.print(str+" ");
      }
      sc.close();
   }

}