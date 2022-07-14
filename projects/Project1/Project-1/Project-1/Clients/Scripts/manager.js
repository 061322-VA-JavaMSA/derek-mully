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
        let time2;
        if(result.reimbTypeId == 1) {
            type = 'lodging'
        } else if (result.reimbTypeId == 2) {
            type = 'travel'
        } else if (result.reimbTypeId == 3) {
            type = 'food'
        } else if (result.reimbTypeId == 4) {
            type = 'other'
        }

        
        time = result.reimbSubmitted.toString().slice(0,10)
        if(result.reimbResolved){
            time2 = result.reimbResolved.toString().slice(0,10)
        } else {
            time2 = "not resolved yet"
        }
        let resolver = "";
        if(result.reimbResolver == 1) {
            resolver = "alex"
        }
        
        tdId.innerHTML = result.reimbId;
        tdAmount.innerHTML = result.reimbAmount;
        tdType.innerHTML = type;
        tdTimeSubmitted.innerHTML = time;
        tdTimeResolved.innerHTML = time2;
        tdResolver.innerHTML = resolver;
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



    let updateButton = document.getElementById('submitButton');
    updateButton.addEventListener('click', updateStatus);
    
   
    async function updateStatus(){
        let reimbId = document.getElementById('updateId').value;
        let table = document.getElementById('employer-tbody');
        let rowLen = table.rows.length
        let select;
        for(let i = 0; i < rowLen; i++){ 
            if(table.rows[i].cells[0].innerHTML == reimbId){
                select = table.rows[i].cells[7].querySelector('#statusSelect').value;
                let response = await fetch(`${apiUrl}/manager`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        'reimbId': reimbId,
                        'reimbStatusId': `${select}`
                    })
                })
                if(response.status == 202) {
                    window.location.href="./manager.html";
                }
            
            }
        }
        
    }


    searchBox_1.addEventListener("click", function(){
        var keyword = this.value;
        var table_1 = document.getElementById("employer-tbody");
        var all_tr = table_1.getElementsByTagName("tr");
        for(var i=0; i<all_tr.length; i++){
            var name_column = all_tr[i].getElementsByTagName("td")[7].querySelector('#statusSelect').value;
            if(name_column === keyword) {
                all_tr[i].style.display = ""; // show
            } else {
                all_tr[i].style.display = "none"; // hide
            }
        }
        
        
    });      