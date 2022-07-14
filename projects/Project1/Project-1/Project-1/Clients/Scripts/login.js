
if(principal){
    window.location.href="./index.html";
}
let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

async function login(){

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/auth`,{
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'username': `${username}`,
            'password': `${password}`
        })
    });

    if(response.status == 200){
        let data = await response.json();

         sessionStorage.setItem('principal', JSON.stringify(data));
        window.location.href="./index.html";
    } else{
        console.log('Please try logging in again.')
    }
}