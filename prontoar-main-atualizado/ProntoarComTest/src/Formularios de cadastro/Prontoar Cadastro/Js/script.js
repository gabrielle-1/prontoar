const formulario_geral = document.querySelector("form");

const nome1 = document.querySelector(".nome1");
const nome2 = document.querySelector(".nome2");
const social = document.querySelector(".nomeExtra");
const email = document.querySelector(".e-mail");
const tel = document.querySelector("telefone");
const chave = document.querySelector("chave");
const chave2 = document.querySelector("chave2");
const genero = document.querySelector("gender-groups");

formulario_geral.addEventListener("submit", function (event) {
  event.preventDefault();
  //criação dos dados em um Json
  const dados = {
    nome1: nome1.value,
    nome2: nome2.value,
    social: social.value,
    email: email.value,
    tel: tel.value,
    chave: chave.value,
    chave2: chave2.value,
    genero: genero.value,
  };
  console.log(dados);
  console.log("teste");
});
