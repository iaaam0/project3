
const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
let result = "";
const charactersLength = characters.length;
for (let i = 0; i < 6; i++){
	result += characters.charAt(Math.floor(Math.random() * charactersLength));
	}
console.log(result);

$(document).ready(function(){
	
	$("#randomcode").val(result);
	
	
})