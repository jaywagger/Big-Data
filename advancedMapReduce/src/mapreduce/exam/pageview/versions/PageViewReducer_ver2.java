package mapreduce.exam.pageview.versions;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class PageViewReducer_ver2
	extends Reducer<MyKey, Text,Text,Text>{
	Text resultKey = new Text();
	Text resultValue = new Text();
	@Override
	protected void reduce(MyKey key,
			Iterable<Text> values,
			Reducer<MyKey, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		int sum = 0;//하나의 상품이 클릭된 총 횟수
		int user_count=0;//클릭한 사용자 수
		String beforeUser = "";
		for (Text value:values) {
			String currentUser = value.toString();
			if(!beforeUser.equals(currentUser)) {
				user_count++;//사용자가 다른 경우
			}
			sum++;//하나의 상품에 접속한 모든 횟수
			beforeUser =currentUser;
		}  
		//상품코드가 바뀔때마다 출력
		resultKey.set(key.getProductId());
		StringBuffer data = new StringBuffer();
		data.append(user_count).append("\t")
			.append(sum);
		resultValue.set(data.toString());
		context.write(resultKey, resultValue);				
	}
}







