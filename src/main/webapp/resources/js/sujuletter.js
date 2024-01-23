$(function(){
	
	//발행 클릭 시 실행
	$("#send").on("click", function(){
		
		let bno = $("#bno").val(); // 주문번호 거래처
		let bname = $("#bname").val(); // 주문번호 거래처
		let bnumber = $("#bnumber").val(); // 주문번호 거래처
		//함수 tissuance_close 호출
		issuance(bno,bname,bnumber)
	
		
	})
	
	
	
	
	
})

// 프린트
	//프린트 함수 선언
	function prints(){
		// 함수 호출 될 경우 프린트 객체 실행하게 되면  1. window.onbeforeprint = beforePrint;를 실행
		window.print();
	}
	
	function beforePrint() { // 2.  프린트 화면에서 필요없는 버튼들을 삭제
		$("#print").css("display", "none");
		$("#close").css("display", "none");
		$("#send").css("display", "none");
	}
	
	function afterPrint() { //3.window.onafterprint = afterPrint; 언급으로 실행 
		//프린트 취소 or 출력 누른 이후 페이지 새로고침
		location.reload()
	}
 
	window.onbeforeprint = beforePrint;  //프린트 하기 전 실행 객체
	window.onafterprint = afterPrint; // 프린트 후 실행 객체
	
function issuance(bno,bname,bnumber){
	
	//인수 bno값으로 json 타입으로 만듦
	let bnos = {"bno":bno}
	
	$.ajax({
		type : "GET", // method 타입 get
		url : "issuance", // url value
		data : bnos, //  jsno 타입의 bnos를 컨트롤러로 값을 전달
		dataType: 'json',
		async : false,
		success : function(data) {
			
			// 업데이트가 성공해서 1의 값이 반환되면 
			if(data == 1){
			//알림 문구
					alert("발행 되었습니다.");
					//pdf파일 함수 호출
					dopdf(bname,bnumber)
			//부모 페이지 화면을 새로고침 (order 화면)		
			opener.parent.location.reload();
				
			
				
			}
		}
			
	})
	
}

//입퇴원 확인서 다운로드
function dopdf(bname,bnumber) {
	const pdf = document.getElementById('print_page');
	file = bname +'.'+bnumber;
		// 변수 pdf에 div의 경로 지정
		html2canvas(pdf, { scale: 2 }).then(canvas => {
		const imgData = canvas.toDataURL('image/png');
		const doc = new jsPDF('p', 'mm', 'a4');
		doc.addImage(imgData, 'PNG', 0, 0, 210, 297);
		const fileName = ""+file+"";
		const options = {
			orientation: 'portrait',
			unit: 'mm',
			format: 'a4',
		};
		doc.save(fileName, options);
	});
		//pdf파일 만들고 난 후 3초 경과 후 widnow.closes를 호출
		setInterval(closes, 3000);
			
}




//팝업창 닫기
let closes = function (){
	//호출 되면 팝업창 닫기.
	window.close();
}