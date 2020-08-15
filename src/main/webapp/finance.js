let postData = '';

//    me.form.items.forEach(field => {
//         postData += `${field.name}=` + encodeURIComponent(document.getElementById(field.id).value) + `&`;
//    });

const id = document.getElementById('tid').value;
const accNo = document.getElementById('tAccNo').value;
const amount = document.getElementById('tAmount').value;

postData += `${accNo} ${encodeURIComponent(id)} ${amount}`;
   let xhr = new XMLHttpRequest();

   xhr.onreadystatechange = function(){
    if (xhr.readyState == XMLHttpRequest.DONE){
        if (xhr.status == 200){
            alert(xhr.responseText);
            TracomAcademy.Grid.call(me);

        }else{
            alert('Error occurred ' + xhr.status);

        }

    }

   xhr.open('post', 'finance', true);
   xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
   xhr.send(postData);
   console.log(postData);
}
