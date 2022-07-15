if (!principal) {
    window.location.href = "./index.html";
}
async function usersList() {


    console.log(`${apiUrl}/users`);
    let response = await fetch(`${apiUrl}/users`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();

        var list = data;
        document.getElementById("waiting").setAttribute('class', 'd-flex justify-content-center d-none');


        tableReim(list);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    } else if (response.status == 401) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Not Authorized',
        });
    }
}
usersList();
function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');
        td = createTableData(x);
        tr.appendChild(td);
        td = createTableData(list[i].first_name);
        tr.appendChild(td);
        td = createTableData(list[i].last_name);
        tr.appendChild(td);
        td = createTableData(list[i].email);
        tr.appendChild(td);
        td = createTableData(list[i].username);
        tr.appendChild(td);
        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}