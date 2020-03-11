package mapreduce.exam.pageview.versions;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_ver2 
	extends Mapper<LongWritable, Text,MyKey,Text>{
	MyKey outputKey = new MyKey();//output key
	Text outputValue = new Text();
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, MyKey, Text>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] data = line.split("\\t");
		//data[2] = product, data[9] =userId
		outputKey.setProductId(data[2]);
		outputKey.setUserId(data[9]);
		outputValue.set(data[9]);
		context.write(outputKey, outputValue);
	}
}







