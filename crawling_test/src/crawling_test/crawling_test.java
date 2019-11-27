package crawling_test;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class crawling_test {
    public static String getSource(String url) throws MalformedURLException, IOException {                               //�̺κ��� �ǵ帱 �ʿ� ����
        String output = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        String line;
        while ((line = br.readLine()) != null) {
            output += line;
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String saveDir = "D:\\img";
        System.out.print("ũ�Ѹ� �� URL�Է�(https://www.xxx.xxx)>>> ");
        String downUrl = sc.nextLine();
        String typeRgx = "(jpg|png|gif)";

        crawling_test.getTypedFileDown(downUrl, saveDir, typeRgx);
    }

    public static ArrayList<String> getTypedFile(String text, String typeRegex) {
        String regex = "\"(http|https)[:][/][/][^<>\"]+[.]" + typeRegex + "\"";
        Matcher m = Pattern.compile(regex).matcher(text);
        ArrayList<String> output = new ArrayList<>();
        while (m.find()) {
            output.add(m.group().replace("\"", ""));
        }
        return output;
    }

    public static void FileDownload(String address, String saveDir) {
        try {
            URL u = new URL(address);
            FileOutputStream fos = new FileOutputStream(saveDir);
            InputStream is = u.openStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWebFileName(String filePath) {
        String[] parts = filePath.split("[/]");
        return parts[parts.length - 1];
    }

    public static void getTypedFileDown(String url, String saveDir, String typeRegex) throws IOException {
        String source = getSource(url);
        ArrayList<String> urls = getTypedFile(source, typeRegex);
        System.out.println("----------------------------------------");
        System.out.println("�ٿ�ε带 �����մϴ�.");
        System.out.println("----------------------------------------");
        int size = urls.size();
        int k = 1;
        for (String i : urls) {
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("++   �ٿ���� �̹��� URL : " + i);
            String save = saveDir + "\\" + getWebFileName(i);
            System.out.println("++   ���� �ٿ�ε� ���    : " + save);
            FileDownload(i, save);
            System.out.println("++   �ٿ�ε� �����     : " + (k * 100 / size) + "%");
            System.out.println("----------------------------------------");
            System.out.println();
            k++;
        }
        System.out.println("----------------------------------------");
        System.out.println("�� " + urls.size() + "���� ������ �ٿ�ε��Ͽ����ϴ�.");
        System.out.println("----------------------------------------");
    }
}