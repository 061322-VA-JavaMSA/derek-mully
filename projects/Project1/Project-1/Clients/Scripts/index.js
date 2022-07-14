let welcomeH1 = document.getElementById('welcome');

if(principal){
    welcomeH1.innerHTML = `Once again, welcome ${principal.userName}!`
} else{
    welcomeH1.innerHTML = `Project 1`
}