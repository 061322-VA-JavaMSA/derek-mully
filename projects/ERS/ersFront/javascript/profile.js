if (!principal) {
    window.location.href = "./index.html";
}
async function profileLoad() {


    let response = await fetch(`${apiUrl}/users/${principal.id}`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();

        var profileData = data;
        document.getElementById('first_name').value = profileData.first_name;
        document.getElementById('last_name').value = profileData.last_name;
        document.getElementById('email').value = profileData.email;
        document.getElementById('password').value = '';
        document.getElementById("profile_form").style.display = "block";
        document.getElementById("waiting").setAttribute('class', 'd-flex justify-content-center d-none');
    } else {
    }
}
profileLoad();
let addButton = document.getElementById('submitButton');
addButton.addEventListener('click', update);

async function update() {

    let first_name = document.getElementById('first_name').value;
    let last_name = document.getElementById('last_name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/users/${principal.id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'first_name': `${first_name}`,
            'last_name': `${last_name}`,
            'email': `${email}`,
            'password': `${password}`
        })
    });

    if (response.status == 200) {

        Swal.fire({
            icon: 'success',
            text: 'Profile Saved',
            timer: 2000,
        });
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Unable to save',
            timer: 2000,
        });
    }
}