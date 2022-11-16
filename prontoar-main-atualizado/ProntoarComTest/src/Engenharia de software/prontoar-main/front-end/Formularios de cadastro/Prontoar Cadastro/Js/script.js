function save(dados, url, mensagem){
  $.ajax({
    url: 'http://localhost:8080/api/v1/' + url,
    method: 'POST',      
    data: JSON.stringify(dados),
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
        console.log(response);  
        alert(mensagem);  
        document.location.reload(true);    
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log(xhr)          
    });    
}

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
    alert("CRM estão diferentes!");
    return false;
  }

  let nomeCompleto = nome.value + " " + sobrenome.value;

  //criação dos dados em um Json
  const values  = {
    "crm": crm.value,    
    "name": nomeCompleto,    
    "age": idade.value,
    "gender": genero.value,
    "phoneNumber": tel.value,
    "address" : endereco.value
  };

  if(values){
    save(values, "doctors", "Médico salvo com sucesso!");
  }
}

function savePatient(){
  const nome = document.getElementById("first-name");
  const sobrenome = document.getElementById("last-name");
  const social = document.getElementById("social-name");
  const tel = document.getElementById("number");
  const idade = document.getElementById("idade");
  const endereco = document.getElementById("endereco");
  const cpf = document.getElementById("cpf");
  const confirmcpf = document.getElementById("confirmcpf");
  const peso = document.getElementById("peso");
  const date = document.getElementById("data");
  const altura = document.getElementById("altura");

  let nomeCompleto = nome.value + " " + sobrenome.value;

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
    "name": nomeCompleto.value,  
    "cpf": cpf.value,     
    "age": idade.value,  
    "gender": genero.value,
    "weight" : peso.value,
    "height" : altura.value,
    "phoneNumber": tel.value,
    "socialName": social.value,
    "address": endereco.value,
    "date": date.value
  };

  if(values){
    save(values, "patients", "Paciente salvo com sucesso!");
  }

}