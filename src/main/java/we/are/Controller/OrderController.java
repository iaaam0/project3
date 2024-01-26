package we.are.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import we.are.Model.CriteriaDTO;
import we.are.Model.InventoryDTO;
import we.are.Model.JoinDTO;
import we.are.Model.OrderDTO;
import we.are.Model.PageDTO;
import we.are.Service.OrderService;


@Controller
public class OrderController {

	@Autowired
	OrderService os;


	// 수주등록 버튼을 누르면
	@RequestMapping("order_insert")
	public String order_insert(OrderDTO od) {
		os.order_insert(od);
		return "redirect:/order";
	}


	// 수주 목록 select
	@RequestMapping("order")
	public String order_list (OrderDTO od, CriteriaDTO cd, Model model, JoinDTO jd) {

		System.out.println(cd);

		// order.jsp 실행할때 select된 결과를 "olist"에 저장해서 가져와
		model.addAttribute("olist", os.order_select(cd));

		// 수주 테이블에 전체 건수(total select해서)를 아래 190대신 대입
		int total = os.total(cd);
		// order.jsp 실행할때 PageDTO에 저장되있는 데이터를 가져와
									// 생성자 호출(매개변수가 2개인 생성자)
									// new PageDTO(cdto, 190));
		model.addAttribute("paging", new PageDTO(cd, total));

		//model.addAttribute("use",os.)

		return "order";
	}

	// 발주 등록 제품 ajax !
	@RequestMapping("product_select.json")
	public ResponseEntity<?> product_select(InventoryDTO id, Model model, HttpSession session) {		
		return new ResponseEntity<>(os.product_select(),HttpStatus.OK);
	}


	/*	//임시등록 수주서1
	@GetMapping("sujuletter1")
	public void sujuletter1(OrderDTO od, CompanyDTO cd, HttpSession session, @RequestParam("bno") int bno, Model model) {

		OrderDTO ood = new OrderDTO();//다른 주소의 OrderDTO타입 ood변수 생성		
		od.setOno(bno);	//parameter로 bno값을 받고 OrderDTO od bno변수에 저장		
		ood = os.sujuletter_select(od); // od변수에 있는 값을 이용해서 DB의 orders 테이블에서 셀렉하고 결과값을 ood에 저장
		model.addAttribute("sujuletter", os.sujuletter_select(od)); //셀렉한 값을 model 객체 "sujuletter"변수에 저장
		cd.setCnumber(ood.getOnumber()); // ood의 저장된 값중 bnumber를 CompanyDTO cd변수 안의 number에 저장
		model.addAttribute("company", os.sujucom_select(cd.getCnumber())); // 저장받은 number값을 이용해서 DB company에서 결과값을 model 객체 "company"에 저장
	}



	//임시등록 수주서 발행
	@GetMapping("issuance")
	public ResponseEntity<?> issuance(OrderDTO od, Model model, HttpSession session,@RequestParam("bno") int bno) {		
		// order dto bno에 bno값을 저장
		od.setBno(bno); // 반환 값 1 or 0
		//bno값으로 업데이트. 
		return new ResponseEntity<>(os.suju_update(od),HttpStatus.OK);
	}*/


}
