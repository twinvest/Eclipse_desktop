import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling_test2
{
	 public static void main(String[] args) throws IOException 
	 {
        String URL = "https://kr.investing.com/commodities/gold";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("tr");
        String str = elem.text();
        String[] tmp = str.split("코스피지수");
        String[] tmp2 = tmp[1].trim().split(" ");
        System.out.println(tmp2[0]); 
    }
}