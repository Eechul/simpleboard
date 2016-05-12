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
import com.javalec.spring_mybatis.dto.FileInfoDto;
import com.javalec.spring_mybatis.util.CommonUtils;

/**
 * Handles requests for the application home page.
 * 
 * @param <HttpRequestWithModifiableParameters>
 */
@Controller
public class HomeController<HttpRequestWithModifiableParameters> {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/* ContentDao dao; */

	@Autowired
	private SqlSession sqlSession;

	/*
	 * @Autowired public void setDao(ContentDao dao) { this.dao = dao; }
	 */

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("home()");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

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
		model.addAttribute(
				"list",
				dao.searchListDao(request.getParameter("searchType"),
						request.getParameter("bSearch")));
		return "/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		return "/write_view";
	}

	@RequestMapping("/write")
	public String write(MultipartHttpServletRequest request) {
		int bId;
		Map<String, MultipartFile> files = request.getFileMap();
		
		IDao dao = sqlSession.getMapper(IDao.class);
		bId = dao.boardWriteDao(request.getParameter("bName"), request
				.getParameter("bTitle"), request.getParameter("bContent")
				.replaceAll("\r\n", "<br/>"));
		System.out.println(bId);
		// 게시글을 insert 한 후의 키값을 fileinfo 테이블에 insert해야하기 때문에 
		// 게시글 insert를 먼저 수행.
		//CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("bFile");
		
//		// 오리지널 파일이름
//		String originalFileName = cmf.getOriginalFilename();
//		// 파일의 확장자 (.xx)
//		String originalFileExtension = cmf.getOriginalFilename().substring(
//				originalFileName.lastIndexOf("."));
//		// 저장될 파일이름 문자+숫자 = 무작위 문자열 로 구성
//		String storedFileName = CommonUtils.getRandomString()
//				+ originalFileExtension;
//		// 파일 크기
//		int fileSize = (int) cmf.getSize(); 
//		
//		System.out.println("원래 파일이름" + originalFileName);
//		System.out.println("확장자:" + originalFileExtension);
//		System.out.println("저장될 이름:" + storedFileName);
//		System.out.println("fsize:" + fileSize);
//
//		FileInfoDto finfoDto = new FileInfoDto();
//		// 파일 정보 값 set 
//		
//		finfoDto.setfOriginal_Name(originalFileName); 
//		finfoDto.setfStored_Name(storedFileName);
//		finfoDto.setfSize(fileSize);
//		
//		// 트랜잭션 단위로 처리할때 오류날수 있음! 
//		// 이유 : (시나리오) A라는 사람이 게시판에 글 작성과 파일업로드를 함.
//		// A라는 사람과 동시에 B라는 사람이 게시판에 글 작성과 파일 업로드를 함.
//		// A 가 현재 게시판 시퀀스(BOARD_SEQ)를 FILEINFO 테이블에 삽입하려 할때
//		// B 가 그전에 게시판을 작성하여 시퀀스가 카운터 된 상황.
//		// 그럼 A는 FILEINFO테이블의 BID가 BOARD테이블 BID와 다른 상황 발생.
//		// 치명적 오류!
//		
//		dao.insertFileInfoDao(finfoDto);
//		
//		// 경로
//		String path = "d:/upload/" + storedFileName;
//
//		
//		File file = new File(path);
//		// 파일 업로드 처리 완료.
//
//		try {
//			cmf.transferTo(file);
//			System.out.println("success!");
//		} catch (Exception e) {
//			System.out.println("fall..");
//		}
		return "redirect:list";
	}

	@RequestMapping("/comment_write")
	public String comment_write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("id :" + request.getParameter("bId"));
		dao.commentWriteDao(request.getParameter("bId"),
				request.getParameter("cmPassword"),
				request.getParameter("cmName"),
				request.getParameter("cmContent").replaceAll("\r\n", "<br/>"));

		return "redirect:content_view?bId=" + request.getParameter("bId");
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.HitUp(request.getParameter("bId"));
		model.addAttribute("content_view",
				dao.contentViewDao(request.getParameter("bId")));
		model.addAttribute("comment_view",
				dao.commentViewDao(request.getParameter("bId")));

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
		model.addAttribute("modify_view",
				dao.contentViewDao(request.getParameter("bId")));
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
	public String comment_reply(CommentDto commentDto,
			HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("cmId :" + request.getParameter("cmId"));

		int flag = dao.commentReplyFlagDao(commentDto.getCmGroup(),
				commentDto.getCmStep(), commentDto.getCmIndent());
		// select 쿼리에서 값을(flag) 가져온다 이값은 step 값
		commentDto.setCmStep(flag); // 셋 해주고
		if (flag != 0) // 크게 step이 0일때와 0이 아닐때로 구분이된다.
		{
			dao.commentReplyUpdateDao(commentDto);
			dao.commentReplyWriteDao(commentDto);
			// 0이 아니라면 업데이트를 해주고 글을 쓰게되고
		} else {
			System.out.println(commentDto.getCmIndent());
			dao.commentReplyWriteDao(commentDto);
			// 0이 라면 그냥 글을 쓰게된다.(여기선 안보이지만 2개이상의 쿼리를 쓴 것이다.
			// 위에 0이 아닐때에서 update문을 한 뒤 insert를 할 수 있는 쿼리가 없을까
			// 찾아보다가 결국엔 따로 쓴 소스들이라고 할 수 있다.)
		}
		return "redirect:content_view?bId=" + request.getParameter("bId");
		// 원래 게시판 페이지로 이동.
	}

}
