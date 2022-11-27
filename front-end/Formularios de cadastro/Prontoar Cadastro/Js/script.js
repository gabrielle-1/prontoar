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
function update(dados, url, mensagem, tipo, id){
  $.ajax({
    url: 'http://localhost:8080/api/v1/' + url + "/" + id,
    method: 'PUT',      
    data: JSON.stringify(dados),
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      alert(mensagem); 
      console.log(response); 
      if(tipo == 3){
        // Prontuário
        location.reload();
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

function loadDoctor(codigo){
  $.ajax({          
    url: 'http://localhost:8080/api/v1/doctors/' + codigo,
    method: 'GET',            
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      document.getElementById("divDoctorName").style.display = "block";
      document.getElementById("nameDoctor").innerHTML = "Olá, " + response.name + "!";
    }
  }).fail(function(xhr, status, errorThrown) {
        if(xhr.status == 404){
          console.log("Medico não existe." + xhr.status);
        }
        
    });  
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

// Prontuário
function loadProntuario(){
  const idPaciente = document.getElementById("codigoPaciente");
  
  $.ajax({          
    url: 'http://localhost:8080/api/v1/charts/patient/' + idPaciente.value,
    method: 'GET',            
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      console.log(response);
      verificaProntuarioExiste = true;

      if(verificaProntuarioExiste){
        const pressaoArterial = document.getElementById("pressaoArterial").value = response.bloodPressure;
        const queixas = document.getElementById("queixas").value = response.plaint;
        let date = document.getElementById("data").value =  response.date;
             
        const temperatura = document.getElementById("temperatura").value = response.temperature;
        const prescricao = document.getElementById("prescricao").value = response.prescription;
        const ocorrencias = document.getElementById("ocorrencias").value = response.occurrences;
        const doencas = document.getElementById("doencas").value = response.illnesses;
        
        let estadoGeral = response.generalState;
        let ist = response.ist;
        let deficiencia = response.deficit;

        if(estadoGeral != "") $("#" + estadoGeral).prop("checked", true);
        if(ist != "") $("#ist-" + ist).prop("checked", true);        
        if(deficiencia != "")$("#def-" + deficiencia).prop("checked", true);
          
      }
      
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log("xhr:" + xhr);
        console.log(xhr.status);
        if(xhr.status == 404){
          verificaProntuarioExiste = false;          
        }
        
    });  
}

function saveProntuario(){
  const idPaciente = document.getElementById("codigoPaciente");

  let verificaProntuarioExiste = false;

  const pressaoArterial = document.getElementById("pressaoArterial");
  const queixas = document.getElementById("queixas");
  let date = document.getElementById("data").value;

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


  $.ajax({          
    url: 'http://localhost:8080/api/v1/charts/patient/' + idPaciente.value,
    method: 'GET',            
    contentType: 'application/json; charset-utf-8',
    success: function(response) {
      console.log(response);
      verificaProntuarioExiste = true;

      if(verificaProntuarioExiste){
        update(values, "charts", "Prontuário atualizado com sucesso!", 3, response.id);
      }
      
    }
  }).fail(function(xhr, status, errorThrown) {
        console.log("xhr:" + xhr);
        console.log(xhr.status);
        if(xhr.status == 404){
          verificaProntuarioExiste = false;
          save(values, "charts", "Prontuário salvo com sucesso!", 3);
        }
        
    });   
}
