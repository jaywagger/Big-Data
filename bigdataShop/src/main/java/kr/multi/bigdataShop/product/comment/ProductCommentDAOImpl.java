package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ProductCommentDAO")
public class ProductCommentDAOImpl implements ProductCommentDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductCommentDTO> select(String prd_no) {                //매퍼의 ID와 동일해야 함
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.select",prd_no);
	}

	@Override
	public int insert(ProductCommentDTO comment ) {						//매퍼의 ID와 동일해야 함
		int result =sqlSession.insert("kr.multi.bigdataShop.product.comment.insert",comment);
		return result;
	}

	@Override
	public List<CommentResultDTO> comment_result() {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.comment_result");
	}

}
