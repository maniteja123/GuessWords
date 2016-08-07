package guesswords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		for(int i=0; i<10;i++) a.add(i);
		Iterator<Integer> iter = a.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			if(i%5==0) iter.remove();
		}
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
}
