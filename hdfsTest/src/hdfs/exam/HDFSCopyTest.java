package hdfs.exam;
//저장된 파일을 읽어서 콘솔에 출력하기
import java.io.IOException; 

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSCopyTest {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		FileSystem hdfs = null;
/*		hdfs = FileSystem.get(conf);
 * 		지금까지 리룩스에서 hdfs 명령어로 실행을 했다면, 자바에서 그 같은 기능을 사용하기 위해
 * 		하둡에서 제공하는 api를 활용한다.
 * */
		
		FSDataInputStream hdfsread = null;
		FSDataOutputStream hdfscopy = null;
		try {
			hdfs = FileSystem.get(conf); //이러면 hdfs 사용할 준비가 끝났고, 
			Path path = new Path(args[0]); // 먼저 읽을 파일의 경로를 지정하고,
			// 읽기
			hdfsread = hdfs.open(path); //그 경로로 들어가서 파일을 연다.
			/*System.out.println(hdfsread.readUTF());*/
			
			//복제하기
			Path path2 = new Path(args[1]);
			hdfscopy = hdfs.create(path2);// 연 파일을 새로 만들고
			hdfscopy.writeUTF(hdfsread.readUTF()); // 그 내용을 다시 쓴다. 결국 복제가 된 것 이다. 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
