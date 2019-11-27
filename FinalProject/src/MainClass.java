
public class MainClass{

	public static void main(String[] args) throws Exception {
		DataFuturesClass data = new DataFuturesClass();
		CrawlingClass crawling = new CrawlingClass();
		
		String client_input="8830";
		crawling.setGold(client_input);          //선재의 입력.
		
		//double result = 
		crawling.result();	
		//System.out.println(result);
			
	}

}
