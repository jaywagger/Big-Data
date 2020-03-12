package CommentWordCount;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.hsqldb.Tokenizer;

import PatternAPI.PatternAPITest;

public class CommentWordCountMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable> {	
	
	static final IntWritable outputVal 
							= new IntWritable(1);
	
	Text outputKey = new Text();
	
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
						//한줄이 txt형식이므로 String으로 바꾸고 ,< 기준으로 짜른다. 그게 line 배열로 들어간다. 
		String[] line = value.toString().split(",");
		
													//2번 댓글만 남겨야 한다.
		StringTokenizer cutWord = new StringTokenizer(line[2]);
		String patternStr = "은|에|의|는|이|가|서|요|나";
		String replace ="";
		
		//단어를 차례대로 밑으로 내리기
		while(cutWord.hasMoreTokens()) {
			String word = cutWord.nextToken();
			replace = equalPattern(word,patternStr);
			outputKey.set(replace); 
			context.write(outputKey, outputVal);
		}
		
	}
	
	public static String equalPattern(String word, String patternStr) {
		Pattern pattern =Pattern.compile(patternStr);
		Matcher m = pattern.matcher(word);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
}








