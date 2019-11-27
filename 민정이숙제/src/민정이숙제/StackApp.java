package �����̼���;
import java.util.Scanner;

interface Stack {
   int length(); //���� ���ÿ� ����� ���� ����
   int capacity(); //������ ��ü ���� ������ ���� ����
   String pop(); //������ top�� �Ǽ� ����
   boolean push(String val); //������ top�� ����� �Ǽ� ����
}

class StringStack implements Stack {
   int num; //������ ����
   int len; //���尡���� ����
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
      if(num < 0) //stack�� �������
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
      System.out.print("�� ���� ���� ������ ũ�� �Է�>>");
      int size = sc.nextInt();
      
      StringStack st = new StringStack(size);

      while(true) {
         System.out.print("���ڿ� �Է� >> ");
         String str = sc.next();
         
         if(str.equals("�׸�"))
            break;
         if(!st.push(str))
            System.out.println("������ �� ���� Ǫ�� �Ұ�!");
      }
      System.out.print("���ÿ� ����� ��� ���ڿ� �� : ");
      int len = st.length();
      for(int i=0;i<len;i++) {
         String str = st.pop();
         System.out.print(str+" ");
      }
      sc.close();
   }

}