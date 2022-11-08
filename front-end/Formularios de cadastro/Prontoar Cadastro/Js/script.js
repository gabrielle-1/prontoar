
function saveDoctor(){
  const nome = document.getElementById("first-name");
  const sobrenome = document.getElementById("last-name");
  const tel = document.getElementById("number");
  const idade = document.getElementById("idade");
  const endereco = document.getElementById("endereco");
  const crm = document.getElementById("crm");
  const confirmCrm = document.getElementById("confirmcrm");

  var generoElement = document.getElementsByName('gender');
  let genero = '';

  for(i = 0; i < generoElement.length; i++) {
      if(generoElement[i].checked)
        genero = generoElement[i];
  }

  if(crm.value != confirmCrm.value){    
    alert("Seu CRM estão diferentes!");
    return false;
  }

  let nomeCompleto = nome.value + " " + sobrenome.value;

  console.log(crm.value, nomeCompleto, idade.value, genero.value, tel.value, endereco.value);

  //criação dos dados em um Json
  const values  = {
    "crm": crm.value,    
    "name": nomeCompleto,    
    "age": idade.value,
    "gender": genero.value,
    "phoneNumber": tel.value,
    "address" : endereco.value
    // "social": social.value,
    // "email": email.value,    
    // "endereco": endereco.value,
  };

  if(values){
    
    $.ajax({
      url: 'http://localhost:8080/api/v1/doctors',
      type: 'POST',      
      data: values,
      dataType: 'jsonp',
      success: function(response) {
          console.log("funfou: ");          
          console.log(response);          
      },
      error: function(response) {
          console.log(response)          
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
  const peso = document.getElementById("peso");
  const date = document.getElementById("date");
  const altura = document.getElementById("altura");

  var generoElement = document.getElementsByName('gender');
  let genero = '';

  for(i = 0; i < generoElement.length; i++) {
      if(generoElement[i].checked)
        genero = generoElement[i];
  }
  
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