/*import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

public class crawling_test{
    public String result() throws Exception{
        String URL = "https://kr.investing.com/commodities/gold";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("tr");
        String str = elem.text();
        String[] tmp = str.split("코스피지수");
        String[] tmp2 = tmp[1].trim().split(" ");
        return tmp2[0];
    }
}*/