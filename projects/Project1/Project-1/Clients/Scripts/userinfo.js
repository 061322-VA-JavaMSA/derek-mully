let user = sessionStorage.getItem('principal');
let userData = JSON.parse(user);
let userId = userData.id;

var userObj = {
    'userId': null,
    'userName': null,
    'email': null,
    'firstName': null,
    'lastName': null,
}

getUser()
async function getUser(){

    let response = await fetch(`${apiUrl}/userinfo?name=${userData.userName}`, {
    });
    
    if(response.status == 200){
        let data = await response.json();
        
        userObj.userId = data.id;
        userObj.userName = data.username;
        userObj.email = data.email;
        userObj.firstName = data.firstName;
        userObj.lastName = data.lastName;
        populateData(userObj)
    } else{
        console.log('Unable to retrieve users.')
    }
}



function populateData(userObj) {
    id = document.getElementById('userId');
    id.value = `${userObj.userId}`;
    
    userName = document.getElementById('userName');
    userName.value = `${userObj.userName}`;
    
    email = document.getElementById('email');
    email.value = `${userObj.email}`;
    
    firstName = document.getElementById('firstName');
    firstName.value = `${userObj.firstName}`;
    
    lastName = document.getElementById('lastName');
    lastName.value = `${userObj.lastName}`; 
    
}
let updateButton = document.getElementById('submitButton');
updateButton.addEventListener('click', updateUserInfo);
    

async function updateUserInfo() {
    let newEmail = document.getElementById('email').value;
    let newFirstName = document.getElementById('firstName').value;
    let newLastName = document.getElementById('lastName').value;

    let response = await fetch(`${apiUrl}/userinfo`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'id': `${userId}`,
            'email': `${newEmail}`,
            'firstName': `${newFirstName}`,
            'lastName': `${newLastName}`,
        })
    })
    if(response.status == 200) {
        window.location.href="./userinfo.html";
    }
}