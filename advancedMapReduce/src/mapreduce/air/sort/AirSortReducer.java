package mapreduce.air.sort;

import java.io.IOException; 

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class AirSortReducer
	extends Reducer<CustomKey, IntWritable,CustomKey,IntWritable>{
	IntWritable resultVal = new IntWritable();
	CustomKey resultKey = new CustomKey();
	Text appenddata = new Text();
	String data ="";
	
	@Override
	protected void reduce(CustomKey key,
			Iterable<IntWritable> values,
			Reducer<CustomKey, IntWritable, CustomKey, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum = 0;
		//month 데이터를 추출
		data = data + "reduce 호출";
		appenddata.set(data);
		int count = 0;
		
		Integer beforeMonth = key.getMonth();
		for (IntWritable value:values) {
			if(count<10) {
				System.out.println("reduce=>"+key);
				count++;
			}
			if(beforeMonth!=key.getMonth()) {
				resultKey.setYear(key.getYear()
						+","+appenddata+"(테스트 문자열),"+
						key.hashCode()+"(해쉬코드)"+
						key.getMapkey()+"(map에서 전달한 키)");
				resultKey.setMonth(beforeMonth);
				resultVal.set(sum);
				context.write(resultKey, resultVal);	
				sum=0;
			}//월데이터가 바뀌는 시점
			sum = sum+value.get(); //같으면 더하기
			beforeMonth = key.getMonth();
		}     
		//values에 전달된 값들을 반복작업하여 마지막에 같은 키를
		//갖고 있는 값을 한번에 출력 - 키(year and month)가 모두 같은 경우
		if(key.getMonth()==beforeMonth) {
			resultKey.setYear(key.getYear());
			resultKey.setMonth(key.getMonth());
			resultVal.set(sum);
			context.write(resultKey, resultVal);	
		}
			
	}
}







