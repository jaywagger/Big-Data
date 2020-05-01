package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentService {
	List<ProductCommentDTO> select(String prd_no);
	int insert(ProductCommentDTO comment);
	//댓글 분석
		List<CommentResultDTO> comment_result();
}
