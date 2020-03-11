package mapreduce.exam.pageview;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

//복합키를 정의: 사용자 정의 키 (정렬할 기준을 컬럼으로 갖고 있는 객체)
//맵리듀스 프레임워크 내부에서 키와 value는 네트워크에서 주고 받는 값이므로
//네트워크 전송을 하기 위해 제공되는 Writable타입이어야 하므로
//WritableComparable을 상속받아 작성한다.

public class MyKey
		implements WritableComparable<MyKey>{
	
	//비교할 변수
	private String productId;
	private String userId;
	
	//기본생성자
	public MyKey() {
	}
	
	public MyKey(String productId, String userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		productId = WritableUtils.readString(in);
		userId = WritableUtils.readString(in);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, productId);
		WritableUtils.writeString(out, userId);
	}

	//MyKeyComparator에 명시되어 있음
	@Override
	public int compareTo(MyKey obj) {
		int result = productId.compareTo(obj.productId);
		if(result==0) { //productId가 같은 경우
			result = userId.compareTo(obj.userId);
		}
		return result;
	}

	@Override
	public String toString() {
		return 
				(new StringBuffer()).append(productId).append(" ")
				.append(userId).toString();
		//차이점: 하나의 객체만 생성된다. 기본 형태는 +를 기준으로 각각 객체가 형성된다.
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
