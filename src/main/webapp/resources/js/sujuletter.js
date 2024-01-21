$(function(){
	
	
	
	
})

//입퇴원 확인서 다운로드
	function HdownloadPdf() {
		const divToPrint = document.getElementById('printpage');
		html2canvas(divToPrint, { scale: 2 }).then(canvas => {
			const imgData = canvas.toDataURL('image/png');
			const doc = new jsPDF('p', 'mm', 'a4');
			doc.addImage(imgData, 'PNG', 0, 0, 210, 297);
			const fileName = '입퇴원확인서.pdf';
			const options = {
				orientation: 'portrait',
				unit: 'mm',
				format: 'a4',
			};
			doc.save(fileName, options);
		});
	}
// 프린트
let initBody = document.body;
	//프린트 함수 선언
	function prints(){
		// 함수 호출 될 경우 프린트 객체 실행하게 되면  1. window.onbeforeprint = beforePrint;를 실행
		window.print();
	}
	
	function beforePrint() { // 2.  프린트 화면에서 필요없는 버튼들을 삭제
		$("#print").css("display", "none");
		$("#close").css("display", "none");
		$("#send").css("display", "none");
		document.body = document.querySelector('#print_page');
	}
	
	function afterPrint() { //3.window.onafterprint = afterPrint; 언급으로 실행 
		//프린트 취소 or 출력 누른 이후 페이지에 버튼들 다시 생성
		$("#print").css("display", "inline-block;");
		$("#close").css("display", "inline-block;");
		$("#send").css("display:", "inline-block");
		document.body = initBody;
	}
 
	window.onbeforeprint = beforePrint;  //프린트 하기 전 실행 객체
	window.onafterprint = afterPrint; // 프린트 후 실행 객체
	
// 팝업창 닫기
function closes(){
	window.close();
}
