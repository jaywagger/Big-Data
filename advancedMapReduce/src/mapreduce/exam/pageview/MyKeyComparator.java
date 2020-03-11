package mapreduce.exam.pageview;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyKeyComparator 
			extends WritableComparator {

	protected MyKeyComparator() {
		super(MyKey.class,true);
	}

	//WritableComparable의 타입이 불분명하기 때문에 경고가 떴음
	@SuppressWarnings("rawtypes")//경고를 무시하겠다는 뜻
	@Override
	public int compare(WritableComparable obj1, 
							WritableComparable obj2) {
		MyKey key1 = (MyKey)obj1;
		MyKey key2 = (MyKey)obj2;
		
		return key1.compareTo(key2);
	}
	
	

}
