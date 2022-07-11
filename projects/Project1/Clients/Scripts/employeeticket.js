let user = sessionStorage.getItem('principal');
let userData = JSON.parse(user);
let userId = userData.id;

async function getEmployeeList() {
    let response = await fetch(`${apiUrl}/employee`, {
    });

 
    let data = await response.json();

    let result = [];
    for(let obj of data){
        if(obj.reimbAuthor == userId){
            result.push(obj);
        }
    }
    console.log(result);
    populateTable(result);
    
}

getEmployeeList();

function populateTable(results){
    let tableBody = document.getElementById('employee-tbody');

    results.forEach(result => {
        let tr = document.createElement('tr');

        let tdId = document.createElement('td');
        let tdAmount= document.createElement('td');
        let tdType = document.createElement('td');
        let tdTimeSubmitted = document.createElement('td');
        let tdTimeResolved = document.createElement('td');
        let tdResolver = document.createElement('td');
        let tdDescription = document.createElement('td');
        let tdStatus = document.createElement('td');

        let type;
        let status;
        let time;
        if(result.reimbTypeId == 1) {
            type = 'lodging'
        } else if (result.reimbTypeId == 2) {
            type = 'travel'
        } else if (result.reimbTypeId == 3) {
            type = 'food'
        } else if (result.reimbTypeId == 4) {
            type = 'other'
        }

        if(result.reimbStatusId == 1) {
            status = 'pending'
        } else if (result.reimbStatusId == 2) {
            status = 'accepted'
        } else {
            status = 'rejected'
        }
        time = `${result.reimbSubmitted[0]}-${result.reimbSubmitted[1]}-${result.reimbSubmitted[2]}`

        tdId.innerHTML = result.reimbId;
        tdAmount.innerHTML = result.reimbAmount;
        tdType.innerHTML = type
        tdTimeSubmitted.innerHTML = time;
        tdTimeResolved.innerHTML = result.reimbResolved;
        tdResolver.innerHTML = result.reimbResolver;
        tdDescription.innerHTML = result.reimbDescription;
        tdStatus.innerHTML = status

        tr.append(tdId);
        tr.append(tdAmount);
        tr.append(tdType);
        tr.append(tdTimeSubmitted);
        tr.append(tdTimeResolved);
        tr.append(tdResolver);
        tr.append(tdDescription);
        tr.append(tdStatus);

        tableBody.append(tr);
    });
}