import java.util.HashMap;
import java.util.Map;

public class test {
public static void main(String[] args) {
	Map<String, int[]> a = new HashMap<String, int[]>();
	a.put("sibal", new int[] {11,12});
	
	int[] temp = a.get("sibal");
	
	temp[1] = 515;
	
	System.out.println(a.get("sibal")[1]);
}
}
