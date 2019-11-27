
import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class ObjectData  implements Serializable{


	private ArrayList<Integer> rsList = new ArrayList<>();

	public ArrayList<Integer> getRsList() {
		return rsList;
	}

	public void setRsList(ArrayList<Integer> rsList) {
		this.rsList = rsList;
	} 
	
}
