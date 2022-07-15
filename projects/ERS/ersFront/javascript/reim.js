if (!principal) {
    window.location.href = "./index.html";
}
async function reimbursement() {


    console.log(`${apiUrl}/users/${principal.id}/reim`);
    let response = await fetch(`${apiUrl}/users/${principal.id}/reim`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        document.getElementById("waiting").setAttribute('class', 'd-flex justify-content-center d-none');
        tableReim(list);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    }
}
reimbursement();
function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');

        tr.appendChild(createTableData(x));
        tr.appendChild(createTableData(list[i].amount));
        tr.appendChild(createTableData(list[i].description));
        tr.appendChild(createTableData(list[i].submitted.substring(0, 16)));
        tr.appendChild(createTableData((list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "&nbsp;"));
        tr.appendChild(createTableData((list[i].resolver != null) ? list[i].resolver.username : "&nbsp;"));
        tr.appendChild(createTableData(list[i].reim_status.reimb_status));
        tr.appendChild(createTableData(list[i].reim_type.reimb_type));

        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}