function checkFirstNameLength() {
	var input = document.getElementById('firstName').value;
	var em = document.getElementById('firstnameMessage');
	
	if(input.length < 3) {
		em.innerHTML = "Too short!";
		return false;
	} else {
		em.innerHTML = "";
		return true;
	}
	console.log("no");
}

function checkLastNameLength() {
	var input = document.getElementById('lastName').value;
	var em = document.getElementById('lastnameMessage');
	
	if(input.length < 3) {
		em.innerHTML = "Too short!";
		return false;
	} else {
		em.innerHTML = "";
		return true;
	}
	console.log("no");
}

function checkPhone() {
	var input = parseInt(document.getElementById('phone').value);
	var em = document.getElementById('phoneMessage');
	
	if(input.toString().length === 10) {
		em.innerHTML = "";
		return true;
	} else {
		em.innerHTML = "Too short or too long!";
		return false;
	}
}

function checkPassword() {
	var input = document.getElementById('password').value;
	var em = document.getElementById('passwordMessage');
	var pattern = /^[A-Za-z]\w{7,14}$/;
	
	if(!input.match(pattern)) {
		em.innerHTML = "Bad password!";
		return false;
	} else {
		em.innerHTML = "";
		return true;
	}
}

function validate() {
	if(checkPassword() && checkPhone() && checkFirstNameLength() && checkLastNameLength()) {
		return true;
	}
	
	alert("Fill in all fields marked with '*'!");
	
	return false;
}