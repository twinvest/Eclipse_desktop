
import java.io.File;
import java.util.List;

// System.out.println("Working Directory = " + System.getProperty("user.dir"));
// 현재 프로그램 위치

public class main {
   // 해당 컴뷰터의 바탕화면
   private static String desktopPath = System.getProperty("user.home") + "\\Desktop"; // 컴퓨터 마다의 바탕화면

   private static String filePath = desktopPath + "\\receiveFile"; // 받을 폴더

   private static String filename = filePath + "\\receiveFile.zip"; // 전송 받은 파일의 경로와 이름을 지정

   private static File[] fileList; // 받을 파일들

   private static int port = 2018;
      
   private static String MasterServerIP = "10.10.39.37";

   /*
    * 각자의 mysql 보안 폴더에 존재
    * 그 위치는 SHOW VARIABLES LIKE "secure_file_priv"; 로 검색
    * 선재는 C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\
    */
   
   private static String securitySQLFolder = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads";
   private static String outputFile = securitySQLFolder + "/mini_word_count.txt"; 
   

   public static void main(String[] args) throws Throwable {
      
            
      //sender.sender("192.168.0.13", port, outputFile);
      ObjectData od = new ObjectData(); // 아래의 Data.java 객체 생성(직렬화)
      od.setRsList(spDAO.SelectWordCountTable());
      System.out.println("Main 부분에서 select를 찍어볼게요");
      for (WordCountBean wcb : od.getRsList()) {
         System.out.println(wcb.getWord() +"_"+ wcb.getAmount());
      }
      
      ObjectSend send = new ObjectSend();
      System.out.println("계산 결과를 Master Server("+MasterServerIP+")로 보내겠습니다...");
      System.out.println("port : " + port);
      send.sender(MasterServerIP, port, od);
      System.out.println("send 성공!!");
      
      Timer.end();

      spDAO.disconnect(); // 사용 종료
      
      // }

   }
   // 여기서는 list 받고 make text class 에서 이 return 을 받아 DB에 기입하기 좋게 csv로 작성하는 클래스 필요
}