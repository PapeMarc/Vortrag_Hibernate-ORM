import com.pape.hibernate.data.*;

public class Main {
	public static void main(String[] args) {
		DatabaseAccess db = new DatabaseAccess();
		
		db.createFactory();
		
		db.createUser("Tim", "TimSeinSehrSicheresPasswort,!");
		
		db.disposeFactory();
		
	}
}
