package mapreduce.air.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class CustomKeyComparator 
			extends WritableComparator {

	protected CustomKeyComparator() {
		super(CustomKey.class,true);
	}

	//WritableComparable의 타입이 불분명하기 때문에 경고가 떴음
	@SuppressWarnings("rawtypes")//경고를 무시하겠다는 뜻
	@Override
	public int compare(WritableComparable obj1, 
							WritableComparable obj2) {
		CustomKey key1 = (CustomKey)obj1;
		CustomKey key2 = (CustomKey)obj2;
		
		return key1.compareTo(key2);
	}
	
	

}
