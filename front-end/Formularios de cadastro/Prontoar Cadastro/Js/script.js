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
        // Paciente
        document.location = "TelaFimAdmin.html";
      }else if(tipo == 2){
        // Médico
        document.location = "TelaInicialMedico.html";      
      }else if(tipo == 3){
        // Prontuário
        document.location = "TelaFimMedico.html";
      }
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log(xhr)        
        return false;  
    });    
}

function updateProntuario(dados, url, mensagem, tipo){
  $.ajax({
    url: 'http://localhost:8080/api/v1/' + url,
    method: 'PUT',      
    data: JSON.stringify(dados),
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      alert(mensagem); 
      console.log(response); 
      location.reload();
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

  strCpf = parseInt(strCpf);

  if(strCpf){
    $.ajax({          
      url: 'http://localhost:8080/api/v1/patients/find/' + strCpf,
      method: 'GET',            
      contentType: 'application/json; charset-utf-8',
      success: function(response) {
          document.getElementById("nomePaciente").style.display = "block";               
          document.getElementById("nome").value = response.name;                     
          document.location = "TelaProntuario.html?paciente=" + response.id;
      }
    }).fail(function(xhr, status, errorThrown) {
          console.log(xhr.status);
          if(xhr.status == 404){
            document.getElementById("nomePaciente").style.display = "none";               
            document.getElementById("nome").value = "";   
            alert("Paciente não encontrado!");
            return false;
          }
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

// Prontuário
function saveProntuario(){
  const codigo = document.getElementById("codigo").value;

  const pressaoArterial = document.getElementById("pressaoArterial");
  const queixas = document.getElementById("queixas");
  let date = document.getElementById("data").value;

  // Formatando a data
  date = date.replace("-", "").replace("-", "");
  date = parseInt(date);

  const idPaciente = document.getElementById("idPaciente");
  const temperatura = document.getElementById("temperatura");
  const prescricao = document.getElementById("prescricao");
  const ocorrencias = document.getElementById("ocorrencias");
  const doencas = document.getElementById("doencas");
  
  let estadoGeralElement = document.getElementsByName('estadoGeral');
  let estadoGeral = '';

  for(i = 0; i < estadoGeralElement.length; i++) {
    if(estadoGeralElement[i].checked)
    estadoGeral = estadoGeralElement[i];
  }

  let istElement = document.getElementsByName('ist');
  let ist = '';

  for(i = 0; i < istElement.length; i++) {
    if(istElement[i].checked)
    ist = istElement[i];
  }

  let deficienciaElement = document.getElementsByName('deficiencia');
  let deficiencia = '';

  for(i = 0; i < deficienciaElement.length; i++) {
    if(deficienciaElement[i].checked)
    deficiencia = deficienciaElement[i];
  }

  // Criação dos dados em um Json
  const values  = {
    "idPatient": idPaciente.value,    
    "idDoctor": 1,    
    "bloodPressure": pressaoArterial.value,    
    "plaint": queixas.value,    
    "temperature": temperatura.value,    
    "date": date,
    "prescription": prescricao.value,
    "occurrences": ocorrencias.value,
    "illnesses": doencas.value,
    "generalState": estadoGeral.value,
    "ist": ist.value,
    "deficit": deficiencia.value
  };

  
  if(codigo != "" && codigo != null){
    verificaProtuarioExistente(codigo);
    const codProntuario = document.getElementById("codigoProntuario").value;
    updateProntuario(values, "charts/" + codProntuario, "Prontuário atualizado com sucesso!", 3);
  }else{
    save(values, "charts", "Prontuário salvo com sucesso!", 3);
  }


}

function verificaProtuarioExistente(codigo){
  if(codigo){
    $.ajax({          
      url: 'http://localhost:8080/api/v1/charts/patient/' + codigo,
      method: 'GET',            
      contentType: 'application/json; charset-utf-8',
      success: function(response) {
          console.log(response);
          if(response){
            console.log(response.id);

            document.getElementById("codigoProntuario").value = response.id;

            document.getElementById("pressaoArterial").value = response.bloodPressure;
            document.getElementById("queixas").value = response.illnesses;
            document.getElementById("data").value = response.date;            
            document.getElementById("temperatura").value = response.temperature;
            document.getElementById("prescricao").value = response.prescription;
            document.getElementById("ocorrencias").value = response.occurrences;
            document.getElementById("doencas").value = response.plaint;          
                         
            // let estadoGeral = response.generalState;                       
            
            // let istElement = document.getElementsByName('ist');
            // let ist = '';

            // for(i = 0; i < istElement.length; i++) {
            //   if(istElement[i].checked)
            //   ist = istElement[i];
            // }

            // let deficienciaElement = document.getElementsByName('deficiencia');
            // let deficiencia = '';

            // for(i = 0; i < deficienciaElement.length; i++) {
            //   if(deficienciaElement[i].checked)
            //   deficiencia = deficienciaElement[i];
            // }

          }
      }
    }).fail(function(xhr, status, errorThrown) {
          console.log(xhr.status);
          if(xhr.status == 404){
           
            return false;
          }
      });   
  }
}