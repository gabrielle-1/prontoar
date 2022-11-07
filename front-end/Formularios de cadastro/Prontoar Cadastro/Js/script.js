
function saveDoctor(){
  const nome = document.getElementById("first-name");
  const sobrenome = document.getElementById("last-name");
  // const social = document.querySelector(".nomeExtra");
  const email = document.getElementById("email");
  const tel = document.getElementById("number");
  const idade = document.getElementById("idade");
  const endereco = document.getElementById("endereco");
  const crm = document.getElementById("crm");
  const confirmCrm = document.getElementById("confirmcrm");
  const genero = document.getElementsByName("gender");

  if(crm.value != confirmCrm.value){    
    alert("Seu CRM estão diferentes!");
    return false;
  }

  //criação dos dados em um Json
  const values  = {
    "crm": crm.value,    
    "name": nome.value + sobrenome.value,    
    "age": idade.value,
    "gender": genero.value,
    "phoneNumber": tel.value,
    // "social": social.value,
    // "email": email.value,    
    // "endereco": endereco.value,
  };

  if(values){
    
    $.ajax({
      url: 'http://localhost:8080/api/v1/doctors',
      type: 'POST',
      dataType: 'JSON',
      data: values,
      dataType: 'jsonp',
      success: function(response) {
          console.log(response.status);          
      },
      error: function(response) {
          console.log(response.status)          
      }

    });
  }
}

function savePatient(){
  const nome = document.getElementById("first-name");
  const sobrenome = document.getElementById("last-name");
  const social = document.getElementById("social-name");
  // const email = document.getElementById("email");
  const tel = document.getElementById("number");
  const idade = document.getElementById("idade");
  const endereco = document.getElementById("endereco");
  const cpf = document.getElementById("cpf");
  const confirmcpf = document.getElementById("confirmcpf");
  const genero = document.getElementsByName("gender");
  const peso = document.getElementById("peso");
  const date = document.getElementById("date");
  const altura = document.getElementById("altura");

  if(cpf.value != confirmcpf.value){    
    alert("CPFs estão diferentes!");
    return false;
  }

  //criação dos dados em um Json
  const values  = {
    "weight" : peso.value,
    "height" : altura.value,
    "name": nome.value + sobrenome.value,    
    "cpf": cpf.value,    
    "age": idade.value,
    "birthDate": date.value,
    "gender": genero.value,
    "phoneNumber": tel.value,
    "socialName": social.value,
    "endereco": endereco.value,
  };

  if(values){
    
    $.ajax({
      url: 'http://localhost:8080/api/v1/patients',
      type: 'POST',
      dataType: 'JSON',
      data: values,
      dataType: 'jsonp',
      success: function(response) {
          console.log(response.status);          
      },
      error: function(response) {
          console.log(response.status)          
      }

    });

  }

  console.log(values)
}