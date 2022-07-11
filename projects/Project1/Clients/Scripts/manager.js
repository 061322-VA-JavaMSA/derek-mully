let user = sessionStorage.getItem('principal');
let userData = JSON.parse(user);
let userId = userData.id;

async function getEmployeeList() {
    let response = await fetch(`${apiUrl}/manager`, {
    });

 
    let data = await response.json();
    
    console.log(data);
    populateTable(data);
    
}

getEmployeeList();

function populateTable(results){
    let tableBody = document.getElementById('employer-tbody');

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

        let sel = document.createElement('select');
        sel.id = "statusSelect";
        let option1 = document.createElement("option");
        let option2 = document.createElement("option");
        let option3 = document.createElement("option");
        option1.value = 1;
        option1.text = "pending";
        option2.value = 2;
        option2.text = "accepted";
        option3.value = 3;
        option3.text = "rejected";
        sel.appendChild(option1);
        sel.appendChild(option2);
        sel.appendChild(option3);

        let type;
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

        time = `${result.reimbSubmitted[0]}-${result.reimbSubmitted[1]}-${result.reimbSubmitted[2]}`

        tdId.innerHTML = result.reimbId;
        tdAmount.innerHTML = result.reimbAmount;
        tdType.innerHTML = type
        tdTimeSubmitted.innerHTML = time;
        tdTimeResolved.innerHTML = result.reimbResolved;
        tdResolver.innerHTML = result.reimbResolver;
        tdDescription.innerHTML = result.reimbDescription;
        
        sel.value = result.reimbStatusId;
        
        tdStatus.append(sel);

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