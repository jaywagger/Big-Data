package mapreduce.exam.pageview;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper 
				//라인 넘버		문자전체 	커스텀
	extends Mapper<LongWritable, Text,MyKey,IntWritable>{
	MyKey outputKey = new MyKey();//output key
	
	//output Value
	static final IntWritable one = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, MyKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
			
			String[] data = value.toString().split("\\t");
			//data[2] = productId, data[9] = userId
			
			outputKey.setProductId(data[2]);
			outputKey.setUserId(data[9]);
			context.write(outputKey, one);
			
		
	}
}







