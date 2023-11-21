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
function mostrarAnimais(){
    fetch('/animais/listar')
    .then(response => response.json())
    .then(data =>{
        const detalhesAnimais = document.getElementById('detalhesAnimais');
        detalhesAnimais.innerHTML = '';
        
        data.forEach(animal => {
            const tr = document.createElement('tr');
            tr.innerHTML = `<section class="container">
            <div class="card">
                <div class="imgs">
                    <img src="${animal.file1}" alt="imagem do animal">
                </div>
           
                <div class="infos">
                    <h3>Nome do Animal: ${animal.nome} </h3>
                    <p>Tipo do animal:</p>
                    <p>Idade do animal:</p>
                    <p>Vacinado:</p>
                    <p>Castrado:</p>
                    <p>Descrição:</p>
                    <div class="btn-adotar">
                        <button id="abrirFormInteresse">Adotar</button>
                    </div>
                </div>
        </div>
        </section>`;
        detalhesAnimais.appendChild(tr);
        });
    })
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });
}

mostrarAnimais();

/*

const nomeInput = document.getElementById('nome');
const tipoInput = document.getElementById('tipo');
const porteInput = document.getElementById('porte');
const idadeInput = document.getElementById('idade');
const descricaoInput = document.getElementById('descricao');
const castradoInput = document.getElementById('castrado');
const vacinadoInput = document.getElementById('vacinado');
const animalIdInput = document.getElementById('animalId');
const abrirInteresse = document.getElementById('abrirFormInteresse');
const formPopup = document.getElementById('formpopup');

abrirInteresse.addEventListener('click', ()=>{
    formPopup.style.display='flex';
});*/