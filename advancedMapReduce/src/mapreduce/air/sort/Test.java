package mapreduce.air.sort;

public class Test {
	public static void main(String[] args) {
		//문자열비교 - compareTo
		/*
		 * 아스키 코드로 변환하여 비교
		 * 
			동일: 0
			compareTo의 결과
			0: 기준문자열, 매개변수 문자열이 같은 경우
			-1: 기준문자열 < 매개변수 문자열
			1: 기준문자열 > 매개변수 문자열
			
			
		*/
		String data1 ="a";
		String data2 ="b";
		System.out.println((int)'a');
		System.out.println((int)'b');
		System.out.println(data1.compareTo(data2));
		
		//hashcode
		//해시코드 객체는 구분할 수 있는 정수값
		// => 정수값은 객체가 할당된 주소를 가지고 생성한다.
		//=> hashcode메소드를 이용하면 이 정수값이 리턴된다.
		CustomKey key1 = new CustomKey();
		CustomKey key2 = new CustomKey();
		System.out.println(key1); //참조값
		System.out.println(key1.hashCode());
		System.out.println(key2); //참조값
		System.out.println(key2.hashCode());
		System.out.println();
		
		key1.setYear("1987");
		key2.setYear("1987");
		//문자열에서 호출하는 해시코드는 object의 hashcode 메소드가
		//오버라이딩되어 주소를 가지고 정수값을 만들지 않고 문자열을 이용
		//해서 구분 정수값을 만들어서 리턴한다.
		//따라서 문자열이 같으면 hashcode가 같다.
		System.out.println(key1.getYear().hashCode()); //문자열+해쉬코드
		System.out.println(key2.getYear().hashCode()); //문자열+해쉬코드
		
		System.out.println(key2.getYear().hashCode()%1);
	}

}
