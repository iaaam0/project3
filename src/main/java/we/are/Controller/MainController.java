package we.are.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import we.are.Model.LoginDTO;
import we.are.Service.LoginService;

@Controller
public class MainController {
	
	@Autowired
	LoginService joins;
	
	
	@RequestMapping("/")
	public String mainLogin() {		
		return "main";
	}
	
	// 로그인버튼 누르면 로그인창으로 이동
	@RequestMapping("main")
	public String loginpage(LoginDTO joindto, Model model, HttpSession session) {	
		
		return "main";
	}
	
	// 로그인하면 수주관리 페이지로 이동
	@RequestMapping("login")
	public String login(LoginDTO joindto, Model model, HttpSession session) {	
		joins.login(joindto); // 로그인을 하면 DB에 있는 값과 입력한 값 비교해서 일치하면
		session.setAttribute("login", joins.login(joindto)); // session객체 변수login에 저장
		return "redirect:/order";
	}	
	
	// 회원가입 페이지
	@RequestMapping("join")
	public String join() {		
		return "join";
	}
	
	// 회원가입 INSERT
	@RequestMapping("login_insert")
	public String login_insert(LoginDTO logindto) {
		joins.login_insert(logindto);
		return "main";
	}
	
	// 로그아웃버튼 누르면 메인으로 이동
	@RequestMapping("logout")
	public String logout (HttpSession session) {
		session.invalidate(); //invalidate > 세션 데이터 무효
		return "redirect:/";
	}
	

		
	}

	
	
