package mapreduce.exam.pageview.versions;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class MyKeyPartitioner2
			extends Partitioner<MyKey, Text>{
	//numPartitions는 파티션의 갯수 = 리듀스태스크의 갯수
	@Override
	public int getPartition(MyKey key,
					Text value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions ;
	}
}
