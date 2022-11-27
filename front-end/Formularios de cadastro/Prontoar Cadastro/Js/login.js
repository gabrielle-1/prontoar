// Código para pegar dados do Login e preparar para o Back

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

  
// Médico
function loginDoctor(){
    const login = document.getElementById("login").value;
    const password = document.getElementById("password").value;
  
    if(login == '' || password == ''){
      alert("Login ou senha não podem estar vazios.");
      return false;
    }
    
    // Criação dos dados em um Json
    const values  = {
      "email": login,  
      "crm": password
    };
    
    console.log(values);
  
    $.ajax({
      url: 'http://localhost:8080/api/v1/doctors/login',
      method: 'POST',      
      data: JSON.stringify(values),
      contentType: 'application/json; charset-utf-8',
      success: function(response) {   
        if(response){
          // Login correto!        
          console.log(response);
          document.location = "TelaInicialMedico.html?doctor=" + response.id;
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