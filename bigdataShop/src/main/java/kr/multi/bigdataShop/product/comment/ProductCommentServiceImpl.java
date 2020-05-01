package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.multi.bigdataShop.product.comment.ProductCommentDAO;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{
	@Autowired
	@Qualifier("ProductCommentDAO")
	ProductCommentDAO dao;

	@Override
	public List<ProductCommentDTO> select(String prd_no) {

		return dao.select(prd_no);
	}

	@Override
	public int insert(ProductCommentDTO comment) {

		return dao.insert(comment);
	}

	@Override
	public List<CommentResultDTO> comment_result() {
		 
		return dao.comment_result();
	}
}
