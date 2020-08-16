const sendButton = document.getElementById('submit');
const url = 'http://localhost:8080/finances/finance';
let accNo;
let amount;

accNo = document.querySelector('#tAccNo').value;
amount = document.querySelector('#tAmount').value;

const form = document.querySelector('form');
const postData = new FormData(form);

//const postData = `${accNo}+${amount}`

function sendData(){
    fetch(url,{
        method: 'POST',
        body: `${postData}`,
        headers: {
            'Content-type': 'application/x-www-form-urlencoded',

        }
    }).then(function (response) {
        if (response.ok) {
            return response.text();
        }
        return Promise.reject(response);
    }).then(function (data) {
        console.log(accNo,amount);
        console.log(data);
    }).catch(function (error) {
        console.warn('Something went wrong.', error);
    });
}


sendButton.addEventListener('click',event =>{
    event.preventDefault();
    //alert("its working yaay");
    sendData();
});