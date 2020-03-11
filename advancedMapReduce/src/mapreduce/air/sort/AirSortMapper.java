package mapreduce.air.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirSortMapper 
				//라인 넘버		문자전체 	커스텀
	extends Mapper<LongWritable, Text,CustomKey,IntWritable>{
	CustomKey outputKey = new CustomKey();//output key
	//output Value
	static final IntWritable one = new IntWritable(1);
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, CustomKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if(line!=null & line.length>0) {
				if(!line[15].equals("NA") && 
						
					Integer.parseInt(line[15])>0) {
					outputKey.setYear(line[0]);
					outputKey.setMonth(new Integer(line[1]));
					outputKey.setMapkey(key.get());
					context.write(outputKey, one);
				}
			}
		}
	}
}







