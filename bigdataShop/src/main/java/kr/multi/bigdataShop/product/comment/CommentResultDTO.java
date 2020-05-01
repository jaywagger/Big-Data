package kr.multi.bigdataShop.product.comment;

public class CommentResultDTO {
	
	public String keyword;
	public String count;
	
	public CommentResultDTO() {
	
	}

	public CommentResultDTO(String keyword, String count) {
		super();
		this.keyword = keyword;
		this.count = count;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CommentResultDTO [keyword=" + keyword + ", count=" + count + "]";
	}
	
	
}
