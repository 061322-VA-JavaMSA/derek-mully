getReimbursements();

async function getReimbursements(){

    let response = await fetch(`${apiUrl}/reimbursement`, {
       
        credentials: 'include',

    });

    if(response.status == 200){
        let data = await response.json();
            populateTable(data);
    } else{
        console.log('Unable to retrieve users.')
    }
}


function populateTable(data){
    let tableBody = document.getElementById('reimbursement-tbody');

    data.forEach(reimbursement => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdAmount = document.createElement('td');
        let tdSubmitted = document.createElement('td');
        let tdDescription = document.createElement('td');
        let tdAuthor = document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdType = document.createElement('td');
       
        
        
        tdId.innerHTML = reimbursement.id;
        tdAmount.innerHTML = reimbursement.amount;
        tdSubmitted.innerHTML = reimbursement.submitted;
        tdDescription.innerHTML = reimbursement.description;
        tdAuthor.innerHTML = reimbursement.author.username;
        tdStatus.innerHTML = reimbursement.reimbursementStatus.reim_status;
        tdType.innerHTML = reimbursement.reimbursementType.type;
        if(tdStatus.innerHTML == 'pending' && tdAuthor.innerHTML == principal.username){
        tr.append(tdId);
        tr.append(tdAmount);
        tr.append(tdSubmitted);
        tr.append(tdDescription);
        tr.append(tdAuthor);
        tr.append(tdStatus);
        tr.append(tdType);

        tableBody.append(tr);

        }
    });
}