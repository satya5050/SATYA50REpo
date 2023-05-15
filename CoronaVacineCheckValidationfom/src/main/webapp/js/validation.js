function validate(frm){
	document.getElementById("pnameErr").innerHTML ="";
	document.getElementById("paddErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	let name=frm.pname.value;
	let addrs=frm.padd.value;
	let age=frm.page.value;
	let flag=true;
if(name==""){
document.getElementById("pnameErr").innerHTML ="PERSON NAME IS REQUIRED";
frm.pname.focus();
flag=false;
}	
if(addrs==""){
	document.getElementById("paddErr").innerHTML ="PERSON ADRESS IS REQUIRED";
	frm.padd.focus();
	flag=false;
}
if(age==""){
	document.getElementById("pageErr").innerHTML ="PERSON AGE IS REQUIRED";
	frm.page.focus();
	flag=false;
}
else if(isNaN(age)){
	document.getElementById("pageErr").innerHTML ="PERSON AGE MUST BE NUMERIC VALUE";
	frm.page.focus();
	flag=false;
}
else if(age<=0||age>=125){
	document.getElementById("pageErr").innerHTML ="PERSON AGE BE THERE BETWEEN 1 TO 125";
	frm.page.focus();
	flag=false;
}
return flag;
}