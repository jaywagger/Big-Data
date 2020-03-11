package mapreduce.exam.pageview;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator 
			extends WritableComparator {

	protected GroupKeyComparator() {
		super(MyKey.class,true);
	}

	@SuppressWarnings("rawtypes") 
	@Override
	public int compare(WritableComparable obj1, 
							WritableComparable obj2) {
		MyKey key1 = (MyKey)obj1;
		MyKey key2 = (MyKey)obj2;
						//그룹을 무엇으로 묶어줄 것 이냐.  
		return key1.getProductId().compareTo(key2.getProductId());
	}
	
	

}
