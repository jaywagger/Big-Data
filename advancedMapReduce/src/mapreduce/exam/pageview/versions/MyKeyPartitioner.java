package mapreduce.exam.pageview.versions;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;


public class MyKeyPartitioner
			extends Partitioner<MyKey, IntWritable>{
	//numPartitions는 파티션의 갯수 = 리듀스태스크의 갯수
	@Override
	public int getPartition(MyKey key,
					IntWritable value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions ;
	}
}
