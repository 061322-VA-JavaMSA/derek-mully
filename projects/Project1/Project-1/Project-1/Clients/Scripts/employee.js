let submitTicketButton = document.getElementById('submitButton');
submitTicketButton.addEventListener('click', submitTicket);

let data = sessionStorage.getItem('principal');
let userData = JSON.parse(data);


async function submitTicket() {
    let reimbursmentAmount = document.getElementById('reimbursementAmount').value;
    let rt = document.getElementById('reimbursementType').value;
    
    let description = document.getElementById('description').value;
    userId = userData.id;
    
    let response = await fetch(`${apiUrl}/employee`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'reimbTypeId': `${rt}`,
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