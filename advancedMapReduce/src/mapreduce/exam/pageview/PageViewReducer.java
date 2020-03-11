package mapreduce.exam.pageview;

import java.io.IOException; 

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class PageViewReducer
	extends Reducer<MyKey, IntWritable,MyKey,IntWritable>{
	IntWritable resultVal = new IntWritable();
	MyKey resultKey = new MyKey();
	
	@Override
	protected void reduce(MyKey key,
			Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, MyKey, IntWritable>.Context context) throws IOException, InterruptedException {
		int clickSum = 0;
		int userSum = 1;
				
		String beforeUserId = key.getUserId();
		
		for (IntWritable value:values) {
			//오름차순 정리된 데이터가 if 밖으로 먼저 쌓인다.
			if(!beforeUserId.equals(key.getUserId())) { //유저 데이터가 바뀌는 시점
				userSum = userSum+1;
			}
			clickSum = clickSum+value.get(); //클릭 수 더하기 (데이터가 몇개있는지)
			beforeUserId = key.getUserId();
			
		}     
			resultKey.setProductId(key.getProductId());
			resultKey.setUserId(Integer.toString(userSum));
			resultVal.set(clickSum);//결과값 마지막에 붙는 숫자
			context.write(resultKey, resultVal);	
			
	}
}







