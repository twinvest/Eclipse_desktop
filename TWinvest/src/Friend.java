
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
		System.out.println("�̸� :"+name);
		System.out.println("��ȭ :"+phoneNum);
		System.out.println("�ּ� :"+addr);
	}
	
	public void showBasicInfo() {}

}
