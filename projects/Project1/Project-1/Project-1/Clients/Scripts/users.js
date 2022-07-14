if(!principal || principal.roleId !== 1){
    window.location.href="./index.html";
}else{
    getUsers();
}
async function getUsers(){

    let response = await fetch(`${apiUrl}/users`, {
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();
        console.log(data)
        populateTable(data);
    } else{
        console.log('Please try again.')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('users-tbody');

    data.forEach(user => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdFirstname = document.createElement('td');
        let tdLastname = document.createElement('td');
        let tdUsername = document.createElement('td');
        let tdEmail = document.createElement('td');
        let tdRole = document.createElement('td');

        tdId.innerHTML = user.id;
        tdUsername.innerHTML = user.userName;
        tdFirstname.innerHTML = user.firstName;
        tdLastname.innerHTML = user.lastName;
        tdEmail.innerHTML = user.email;
        if(user.roleId == 1){
            tdRole.innerHTML = 'Manager'
        } else {
            tdRole.innerHTML = 'Employee'
        };

        tr.append(tdId);
        tr.append(tdUsername);
        tr.append(tdFirstname);
        tr.append(tdLastname);
        tr.append(tdEmail);
        tr.append(tdRole);

        tableBody.append(tr);
    });
}