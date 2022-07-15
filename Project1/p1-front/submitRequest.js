if (!principal) {
    window.location.href = "homePage.html";
}

let submitButton = document.getElementById('submitButton');
submitButton.addEventListener('click', submitRequest);


async function submitRequest(){

    let type = document.getElementById('type').value;
    let amount = document.getElementById('amount').value;
    let desc = document.getElementById('description').value;
    let author_id = principal.id
    
    
      

    const newReimbursement = {
        description: `${desc}`,
        amount:`${amount}`,
        reimbursement_type_id:`${type}`,
        author_id:`${author_id}`,
        
        

    }


    let response = await fetch(`${apiUrl}/reimbursement`,{
        method: 'POST',
        
        body: JSON.stringify(newReimbursement)

    });
    if (response.status == 200) {

     console.log("can add");


    } else {
       
        console.log("cannot add");
      }

}