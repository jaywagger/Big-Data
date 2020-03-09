package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSFileCopy {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		
		FileSystem hdfs = null;
		FSDataInputStream hdfsIn = null;
		FSDataOutputStream hdfsOut = null;
		try {
			hdfs = FileSystem.get(conf);
			
			Path inPath = new Path(args[0]);
			Path outPath = new Path(args[1]);
			
			hdfsIn = hdfs.open(inPath);
			hdfsOut = hdfs.create(outPath);
			
			while(true) {
				int data = hdfsIn.read();
				System.out.println((char)data);
				if(data==-1) {
					break;
				}
				hdfsOut.write((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}








