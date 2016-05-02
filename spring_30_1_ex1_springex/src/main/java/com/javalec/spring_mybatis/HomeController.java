package com.javalec.spring_mybatis;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.javalec.spring_mybatis.dao.IDao;
import com.javalec.spring_mybatis.dto.CommentDto;
import com.javalec.spring_mybatis.dto.ContentDto;

/**
 * Handles requests for the application home page.
 * @param <HttpRequestWithModifiableParameters>
 */
@Controller
public class HomeController<HttpRequestWithModifiableParameters> {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
/*	ContentDao dao;*/

	
	@Autowired
	private SqlSession sqlSession;
	

/*	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("home()");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		return "/list";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println(request.getParameter("searchType"));
		model.addAttribute("list", dao.searchListDao(request.getParameter("searchType") , request.getParameter("bSearch")));
		return "/list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "/write_view";
	}
	
	@RequestMapping("/write")
	public String write(MultipartHttpServletRequest request)  {
//		Map<String, MultipartFile> files = request.getFileMap();
//		CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("bFile");
//		// 경로
//		String path ="d:/upload/"+cmf.getOriginalFilename();
//
//		File file = new File(path);
//		// 파일 업로드 처리 완료.
//		
//
//		try {
//			cmf.transferTo(file);
//			System.out.println("success!");
//		} catch (Exception e) {
//			System.out.println("fall..");
//		}
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.boardWriteDao(request.getParameter("bName")
				, request.getParameter("bTitle")
				, request.getParameter("bContent").replaceAll("\r\n", "<br/>"));

		return "redirect:list";
	}
	
	@RequestMapping("/comment_write")
	public String comment_write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("id :"+request.getParameter("bId"));
		dao.commentWriteDao(request.getParameter("bId")
				,request.getParameter("cmPassword")
				,request.getParameter("cmName")
				,request.getParameter("cmContent").replaceAll("\r\n", "<br/>"));

		return "redirect:content_view?bId="+request.getParameter("bId");
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.HitUp(request.getParameter("bId"));
		model.addAttribute("content_view", dao.contentViewDao(request.getParameter("bId")));
		model.addAttribute("comment_view", dao.commentViewDao(request.getParameter("bId")));
		
		return "/content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));
		return "redirect:list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("modify_view", dao.contentViewDao(request.getParameter("bId")));
		return "/modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(ContentDto contentDto, HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println(request.getParameter("bContent"));
		dao.modifyDao(contentDto);
		return "redirect:list";
	}
	
	@RequestMapping("/comment_reply")
	public String comment_reply(CommentDto commentDto, HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("cmId :"+request.getParameter("cmId"));
		
		commentDto.setCmContent(commentDto.getCmContent().replaceAll("\r\n", "<br/>"));
//		commentDto.setCmStep(commentDto.getCmStep()+1);
		commentDto.setCmIndent(commentDto.getCmIndent()+20);
		
		System.out.println(commentDto.getCmId());
		dao.commentReplyUpdateDao(commentDto.getCmGroup(), commentDto.getCmStep());
		System.out.println(commentDto.getCmStep());
		dao.commentReplyWriteDao(commentDto);
		
		return "redirect:content_view?bId="+request.getParameter("bId");
	}
	
}
