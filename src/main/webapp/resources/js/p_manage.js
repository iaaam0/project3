const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
let result = "";
const charactersLength = characters.length;
for (let i = 0; i < 6; i++){
	result += characters.charAt(Math.floor(Math.random() * charactersLength));
	}
console.log(result);


function insert_info(code, name, price, pmc, pstock, pmi){
	
	$("#pcodei").text(code);
	$("#pnamei").text(name);
	$("#ppricei").text(price);
	$("#pmci").text(pmc);
	$("#pstocki").text(pstock);
	$("#pmii").text(pmi);
}

//제이쿼리 시작구문
$(document).ready(function(){
	$("#randomcode").val(result);
	
	var getData = function() {
		  $.ajax({
		    url: 'w_temple',
		    dataType: 'json',
		    type: 'get',
		    async : false, 
		    success: function(data) {
		    	console.log(data);
		    	$("#wtemple").html(data);
	
		    }
		  })
	

	}
	setInterval(getData, 5000);
})