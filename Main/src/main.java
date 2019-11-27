
import java.io.File;
import java.util.List;

// System.out.println("Working Directory = " + System.getProperty("user.dir"));
// ���� ���α׷� ��ġ

public class main {
   // �ش� �ĺ����� ����ȭ��
   private static String desktopPath = System.getProperty("user.home") + "\\Desktop"; // ��ǻ�� ������ ����ȭ��

   private static String filePath = desktopPath + "\\receiveFile"; // ���� ����

   private static String filename = filePath + "\\receiveFile.zip"; // ���� ���� ������ ��ο� �̸��� ����

   private static File[] fileList; // ���� ���ϵ�

   private static int port = 2018;
      
   private static String MasterServerIP = "10.10.39.37";

   /*
    * ������ mysql ���� ������ ����
    * �� ��ġ�� SHOW VARIABLES LIKE "secure_file_priv"; �� �˻�
    * ����� C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\
    */
   
   private static String securitySQLFolder = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads";
   private static String outputFile = securitySQLFolder + "/mini_word_count.txt"; 
   

   public static void main(String[] args) throws Throwable {
      
            
      //sender.sender("192.168.0.13", port, outputFile);
      ObjectData od = new ObjectData(); // �Ʒ��� Data.java ��ü ����(����ȭ)
      od.setRsList(spDAO.SelectWordCountTable());
      System.out.println("Main �κп��� select�� ���Կ�");
      for (WordCountBean wcb : od.getRsList()) {
         System.out.println(wcb.getWord() +"_"+ wcb.getAmount());
      }
      
      ObjectSend send = new ObjectSend();
      System.out.println("��� ����� Master Server("+MasterServerIP+")�� �����ڽ��ϴ�...");
      System.out.println("port : " + port);
      send.sender(MasterServerIP, port, od);
      System.out.println("send ����!!");
      
      Timer.end();

      spDAO.disconnect(); // ��� ����
      
      // }

   }
   // ���⼭�� list �ް� make text class ���� �� return �� �޾� DB�� �����ϱ� ���� csv�� �ۼ��ϴ� Ŭ���� �ʿ�
}