package hdfs.exam;
//저장된 파일을 읽어서 콘솔에 출력하기
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSExam02 {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		FileSystem hdfs = null;
		FSDataInputStream hdfsin = null;
		try {
			hdfs = FileSystem.get(conf);
			Path path = new Path(args[0]);
			hdfsin = hdfs.open(path);
			System.out.println(hdfsin.readUTF()); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
