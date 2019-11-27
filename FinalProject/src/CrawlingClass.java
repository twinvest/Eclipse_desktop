import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingClass {
	private final String gold = "8830"; // 8830���
	private final String oil = "8849"; // 8849����
	private final String sandp = "8839"; // 8839������
	private final String euro = "1"; // 1����

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
		String str = elem.text(); //������� �ؼ� �� �޾ƿ´�. �׷���, ������ �ݿø��ؼ� �ش� ������ 10���� ���� ������ �Ѵ�.
		//try {
		double value = Double.parseDouble(str);
		System.out.println(value);
		/*}catch(NumberFormatException e)
		{
			System.out.println(e);
		}*/
		//System.out.println(str);
		// System.out.println(str);
		// String[] tmp = str.split("�ڽ�������");
		// String[] tmp2 = tmp[1].trim().split(" ");
		
		
		//return value;

	}
}