/*document.getElementById('addInteresse').addEventListener('click', function(){
    const nomeInput = documento.getElementById('nome');
    const cpfInput = document.getElementById('cpf');
    const emailInput = document.getElementById('email');
    const telefoneInput = document.getElementById('teleofne');
    const cepInput = document.getElementById('cep');
    const msgInput = document.getElementById('msg');

    const nome = nomeInput.value;
    const cpf = cpfInput.value;
    const email = emailInput.value;
    const telefone = telefoneInput.value;
    const cep = cepInput.value;
    const msg = msgInput.value

    fetch('/interesse/add',{
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome,
            cpf: cpf,
            email: email,
            telefone: telefone,
            cep: cep,
            msg: msg

        })  
    })
    .then(response => response.json())
    .then(data => {
        window.confirm(`Interesse ${data.nome} adicionado com sucesso`);
        nomeInput.value = '';
        cpfInput.value = '';
        emailInput.value = '';
        telefoneInput.value = '';
        cepInput.value = '';
        msgInput.value = '';
       
    })
    .catch(error => {
        console.error('Erro ao adicionar interesse:', error);
    });
});*/

const abrirFormInteresse = document.getElementById('abrirFormInteresse');
const formpopup = document.getElementById('formpopup');

abrirFormInteresse.addEventListener('click', ()=>{
    formpopup.style.display='flex';
});