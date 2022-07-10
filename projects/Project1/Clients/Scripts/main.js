
let apiUrl = 'http://localhost:8080/p1';


let principalString = sessionStorage.getItem('principal');
let principal = null;

let nav_right = document.getElementById("nav-right");
let nav_left = document.getElementById("nav-left");


if (principalString) {

    principal = JSON.parse(principalString);
    console.log(principal)
    if (principal.roleId === 1) {
        createNavElement('Users', nav_left, './users.html', null);
        createNavElement('Reimbursement List', nav_left, './manager.html', null);
    } else if (principal.roleId === 2) {
        createNavElement('Submit a ticket', nav_left, './employee.html', null);
        createNavElement('Check my reimbursement', nav_left, './employeeticket.html', null);
    }

    createNavElement('Logout', nav_right, null, logout);
} else {
    createNavElement('Login', nav_right, './login.html', null);
}

async function logout() {


    let response = await fetch(`${apiUrl}/auth`, {
        method: 'DELETE',
        credentials: 'include'
    });

    if (response.status == 200) {

        sessionStorage.clear();

        principal = null;
        window.location.href="./index.html";
    } else {
        console.log('Unable to logout.')
    }
}


function createNavElement(innerHTML, parentElement, link, callback) {
    let li = document.createElement('li');
    li.setAttribute('class', 'nav-item');
    let a = document.createElement('a');
    a.setAttribute('class', 'nav-link');

    if (link) {
        a.setAttribute('href', link);
    } else {
        a.setAttribute('href', '#');
    }

    if (callback) {
        a.addEventListener('click', callback);
    }

    a.innerHTML = innerHTML;

    li.appendChild(a);

    parentElement.appendChild(li);
}