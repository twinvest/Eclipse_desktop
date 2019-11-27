import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class ObjectData  implements Serializable{


	private Object list = new ArrayList<>();

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	} 
	
}
