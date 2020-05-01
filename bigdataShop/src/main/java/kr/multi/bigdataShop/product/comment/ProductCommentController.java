package kr.multi.bigdataShop.product.comment;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.bigdataShop.product.ProductDTO;


@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	//댓글 분석
		@RequestMapping("/comment/result.do")
		public ModelAndView commentAnalysis(){
			System.out.println("댓글분석페이지 기반");
		
			ModelAndView mav = new ModelAndView();
			List<CommentResultDTO> list = service.comment_result();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			mav.addObject("comment_result", list);//db에서 조회한 결과 
            //- 서블릿에서 request.setAttribute
			mav.setViewName("comment/result");
			return mav;
		}
		
	//댓글 등록
		@RequestMapping(value="/comment/write.do",method=RequestMethod.POST)
		public String insertComment(ProductCommentDTO comment,HttpServletRequest req) {
			System.out.println(comment);
			service.insert(comment);
			return "redirect:/product/read.do?prd_no="+comment.getPrd_no();
		}
}
