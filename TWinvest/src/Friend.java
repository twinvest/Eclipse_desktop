
public class Friend {
	String name;
	String phoneNum;
	String addr;
	
	public Friend(String name, String phone, String addr)
	{
		this.name=name;
		this.phoneNum=phone;
		this.addr=addr;
	}
	
	public void showData()
	{
		System.out.println("이름 :"+name);
		System.out.println("전화 :"+phoneNum);
		System.out.println("주소 :"+addr);
	}
	
	public void showBasicInfo() {}

}
