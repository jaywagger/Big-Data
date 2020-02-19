package mapred.basic;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//하둡 맵리듀서에서 mapper역할
//1. mapper 클래스를 상속한다
//	=> mapper에 전달될 input 데이터의 key, value 타입과
// mapper의 실행결과로 출력되는 outout 데이터의 key, value 타입을 정의

//전표 분류작업이다.
// 각각 하나씩 분류하기 때문에 1 즉 output은 int 로 표현이 가능하다
// input data: LongWritable 데이터 타입 & text 내용
public class WordCountMapper 
			extends Mapper<LongWritable, Text, Text, IntWritable>{
	
/*2. map메소드를 오버라이딩해서 map작업을 수행하면서 처리할 내용을 구현
	=> 입력된 값을 분석하기 위한 메서드 : 입력된 데이터에 조건을 적용해서 원하는 데이터를
								추출하기 위해서 반복작업 수행
 	map 메소드의 매개변수: 입력 데이터키, 입력값 Context
									-------맵리듀스 작업을 수행하며
									맵메서드의 실행결과 즉,	출력데이터를 기록하고
									shuffle하고 리듀서로 내보내는 작업을 수행하는 객체
									프레임워크 내부에서 기본 작업을 처리하는 객체
									내부에서 머신들끼리 통신할 떄 필요한 여러가지 정보를
									갖고 있다.

*/
	//output데이터를 mapper의 실행결과로 내보낼 수 있도록, 키와 value을 저장하는 변수
	//output데이터의 value는 무족건 1이므로 상수로 정의
	static final IntWritable outputVal =new IntWritable(1);
	Text outputKey = new Text();
	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//key는 LineNumber: ex) 1 
		//value는 입력데이터의 한 라인에 해당하는 문장 ex) read a book. 각 단어가 토큰
		//StringTokenizer: 공백을 기준으로 문자를 짤라준다.   value의 text 타입을 string으로 변경
		StringTokenizer st = new StringTokenizer(value.toString());
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			outputKey.set(token);//output데이터의 기를 셋팅
			//Context객체의 write메서드를 통해서 output으로내보낼 데이터의 key의 value를 정의
			context.write(outputKey, outputVal);
			
		}
			
	}
}














