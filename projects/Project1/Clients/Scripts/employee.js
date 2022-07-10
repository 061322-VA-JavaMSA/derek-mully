let submitTicketButton = document.getElementById('submitButton');
submitTicketButton.addEventListener('click', submitTicket);

let data = sessionStorage.getItem('principal');
let userData = JSON.parse(data);


async function submitTicket() {
    let reimbursmentAmount = document.getElementById('reimbursementAmount').value;
    let rt = document.getElementById('reimbursementType').value;
    let reimbursmentType;
    if(rt == 'lodging') {
        reimbursmentType = 1;
    } else if (rt == 'travel') {
        reimbursmentType = 2;
    } else if (rt == 'food'){
        reimbursmentType = 3;
    } else {
        reimbursmentType = 4;
    }
    let description = document.getElementById('description').value;
    userId = userData.id;
    
    let response = await fetch(`${apiUrl}/employee`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'reimbTypeId': `${reimbursmentType}`,
            'reimbAmount': `${reimbursmentAmount}`,
            'reimbDescription': `${description}`,
            'reimbAuthor': `${userId}`,
            'reimbResolver': `${1}`,
            'reimbStatusId': `${1}`
        })
    })

    if(response.status == 201) {
        window.location.href="./index.html";
    }

    
}