function save(dados, url, mensagem, tipo){
  $.ajax({
    url: 'http://localhost:8080/api/v1/' + url,
    method: 'POST',      
    data: JSON.stringify(dados),
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      alert(mensagem); 
      console.log(response); 
      if(tipo == 1){
        document.location = "TelaFimAdmin.html";
      }else if(tipo == 2){
        document.location = "TelaInicialMedico.html";
      }
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log(xhr)        
        return false;  
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
  const email = document.getElementById("email");

  let generoElement = document.getElementsByName('gender');
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

  // Criação dos dados em um Json
  const values  = {
    "crm": crm.value,    
    "name": nomeCompleto,    
    "age": idade.value,
    "gender": genero.value,
    "phoneNumber": tel.value,
    "address" : endereco.value,
    "email": email.value
  };

  if(values){
    save(values, "doctors", "Médico salvo com sucesso!", 2);
  }
}

function savePatient(){
  const nome = document.getElementById("first-name");
  const sobrenome = document.getElementById("last-name");
  const social = document.getElementById("social-name");
  const tel = document.getElementById("number");
  const idade = document.getElementById("idade");
  const endereco = document.getElementById("endereco");
  let date = document.getElementById("data").value;
  const email = document.getElementById("email");

  const cpf = document.getElementById("cpf").value;
  var strCpf = cpf.replace("-", "").replace(".", "").replace(".", "");

  const confirmcpf = document.getElementById("confirmcpf");
  let peso = document.getElementById("peso").value;
  peso = peso.replace("Kg", "");
  
  let altura = document.getElementById("altura").value;
  altura = altura.replace("CM", "");

  let nomeCompleto = nome.value + " " + sobrenome.value;
  let generoElement = document.getElementsByName('gender');
  let genero = '';

  for(i = 0; i < generoElement.length; i++) {
      if(generoElement[i].checked)
        genero = generoElement[i];
  }
  
  if(cpf != confirmcpf.value){    
    alert("CPFs estão diferentes!");
    return false;
  }

  // Formatando a data
  date = date.replace("-", "").replace("-", "");
  date = parseInt(date);

  // Criação dos dados em um Json
  const values  = {
    "name": nomeCompleto,  
    "cpf": strCpf,     
    "age": idade.value,  
    "gender": genero.value,
    "weight" : peso,
    "height" : altura,
    "phoneNumber": tel.value,
    "socialName": social.value,
    "address": endereco.value,
    "birthDate": date,
    "email": email.value
  };

  if(values){
    save(values, "patients", "Paciente salvo com sucesso!", 1);
  }

}

function findPatient(){
  
  const cpf = document.getElementById("cpf").value;
  var strCpf = cpf.replace("-", "").replace(".", "").replace(".", "");

  if(strCpf){
    $.ajax({    
      url: 'http://localhost:8080/api/v1/patients=?' + strCpf,
      method: 'GET',            
      contentType: 'application/json; charset-utf-8',
      success: function(response) {
          console.log(response);  
          alert(mensagem);  
          document.location = "TelaMenuMedico.html";
      }
    }).fail(function(xhr, status, errorThrown) {
          console.log(xhr)          
      });   
  }
  
}

// Admin
function loginAdmin(){  
  const login = document.getElementById("login").value;
  const password = document.getElementById("password").value;

  if(login == '' || password == ''){
    alert("Login ou senha não podem estar vazios.");
    return false;
  }
  
  // Criação dos dados em um Json
  const values  = {
    "user": login,  
    "password": password
  };
  
  $.ajax({
    url: 'http://localhost:8080/api/v1/admin/login',
    method: 'POST',      
    data: JSON.stringify(values),
    contentType: 'application/json; charset-utf-8',
    success: function(response) {   
      if(response){
        // Login correto!
        document.location = "TelaInicialAdmin.html";
      }      
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log(xhr.status);
        if(xhr.status == 401){
          alert("Login ou senha incorretos. Tente novamente!");          
          return false;
        }      
        return false;  
  }); 
}