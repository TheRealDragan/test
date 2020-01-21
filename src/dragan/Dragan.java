package dragan;

import java.util.*;
public class Dragan {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,2,3,2,4,1,6,1,23};
		Set<Integer> result = new LinkedHashSet<Integer>();
		for (int i=0; i<arr.length; i++) {
			result.add(arr[i]);
		}
		result.forEach(r->System.out.println(r));
		
	}
	
	public static void removeOddItems(List<String> list) {
		
		if (list== null || list.isEmpty()) {
			return;
		}
		
		 Iterator i = list.iterator();
	      String str = "";
	      while (i.hasNext()) {
	         str = (String) i.next();
	         if ("Odd".equals(str)) {
	            i.remove();
	         }
	      }		
		
//		  for (String str:list) {
//		    if (str.equals("Odd")){
//		      list.remove(str);
//		    }
//		  }
		}

}
