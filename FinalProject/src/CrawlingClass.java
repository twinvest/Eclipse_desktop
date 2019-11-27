import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingClass {
	private final String gold = "8830"; // 8830골드
	private final String oil = "8849"; // 8849오일
	private final String sandp = "8839"; // 8839에센피
	private final String euro = "1"; // 1유로

	private String client = null;
	private String URL = "https://kr.investing.com/";

	public void setGold(String gold) {
		client = gold;
	}

	public void setOil(String oil) {
		client = oil;
	}

	public void setSandp(String sandp) {
		client = sandp;
	}

	public void setEuro(String euro) {
		client = euro; // URL = this.URL + euro;
	}

	public void result() throws Exception {
		LinkedList<String> list = new LinkedList<String>();
		DataFuturesClass test2 = new DataFuturesClass();

		// String client_choice= test2.getGold();

		// String URL = "https://kr.investing.com/commodities/"+client_choice;

		// System.out.println(URL);
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("div.tabsBoxBottom tr td.lastNum.pid-" + client + "-last");
		String str = elem.text(); //여기까지 해서 잘 받아온다. 그런데, 문제는 반올림해서 해당 단위로 10개의 값을 만들어야 한다.
		//try {
		double value = Double.parseDouble(str);
		System.out.println(value);
		/*}catch(NumberFormatException e)
		{
			System.out.println(e);
		}*/
		//System.out.println(str);
		// System.out.println(str);
		// String[] tmp = str.split("코스피지수");
		// String[] tmp2 = tmp[1].trim().split(" ");
		
		
		//return value;

	}
}