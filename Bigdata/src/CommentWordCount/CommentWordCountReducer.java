package CommentWordCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CommentWordCountReducer
	extends Reducer<Text, IntWritable,Text,IntWritable>{
	
	IntWritable resultVal = new IntWritable();
	
	
	@Override
	protected void reduce(Text key,
			Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
		/*for (int value = 0; value < values.length; value++) {
			
		}*/
		//안 이쁨 ={1,1,1,1,1}
		
		int sum = 0;
		System.out.println(key);
		System.out.println(values);
		
		for (IntWritable value : values) {
			sum = sum+value.get();
		} 
		resultVal.set(sum);
		context.write(key, resultVal);
		
	}
}







