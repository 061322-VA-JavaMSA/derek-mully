let welcomeH1 = document.getElementById('welcome');

if(principal){
    welcomeH1.innerHTML = `Welcome back ${principal.userName}!`
} else{
    welcomeH1.innerHTML = `Project 1`
}