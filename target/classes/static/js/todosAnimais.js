// ----------------- MOSTRA - CRIA O CARD DOS ANIMAIS ---------------//

function mostrarAnimais(){
    fetch('/animais/listar')
    .then(response => response.json())
    .then(data =>{
        const detalhesAnimais = document.getElementById('detalhesAnimais');
        detalhesAnimais.innerHTML = '';
        
        data.forEach(animal => {
            const div = document.createElement('div');
            div.innerHTML = `<section class="container">
            <div class="card">
                <div class="imgs">
                    <img src="${animal.file1}" alt="imagem do animal">
                </div>
           
                <div class="infos">
                    <input type="hidden" id="animalId">
                    <h3>Nome do Animal: ${animal.nome} </h3>
                    <p>Tipo do animal: ${animal.tipo}</p>
                    <!--<p>Idade do animal: ${animal.idade}</p>
                    <p>Vacinado: ${animal.vacinado}</p>
                    <p>Castrado: ${animal.castrado}</p>
                    <p>Descrição: ${animal.descricao}</p>-->
                    <div class="btn-adotar">
                    <a href="/infoAnimal">
                        <button class="botao-detalhes" id="animal" data-id="${animal.id}"> Mais Detalhes</button> 
                    </a>
                       
                    </div>
                </div>
        </div>
        </section>`;
        
        detalhesAnimais.appendChild(div);
      
        });
        // Adicionar eventos para o botão
        const botoesDetalhes = document.querySelectorAll('.botao-detalhes');

        botoesDetalhes.forEach(botao => {
            botao.addEventListener('click', function () {
                const id = botao.getAttribute('data-id');
                localStorage.setItem('idAnimal', id);
            });
        });

    })
    .catch(error => {
        console.error('Erro ao mostrar animais:', error);
    });
}

const animalId = document.getElementById('animal');

function mostrarAnimal() {
                                
    localStorage.setItem('animalId', animal.id); //guarda o id do animal

    // Redirecionar para a próxima página
    window.location.href = '/infoAnimais.html';
}
/*--------------------------CHAMA A FUNÇÃO PARA MOSTRAR----------------------------------- */
mostrarAnimais();


document.getElementById('addInteresse').addEventListener('click', function(){
    const nomeInput = documento.getElementById('nome');
    const cpfInput = document.getElementById('cpf');
    const emailInput = document.getElementById('email');
    const telefoneInput = document.getElementById('teleofne');
    const cepInput = document.getElementById('cep');
    const idadeInput = document.getElementById('idade');
    const msgInput = document.getElementById('msg');

    const nome = nomeInput.value;
    const cpf = cpfInput.value;
    const email = emailInput.value;
    const telefone = telefoneInput.value;
    const cep = cepInput.value;
    const msg = msgInput.value
    const idade = idadeInput.value;

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
            msg: msg,
            idade: idade

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
        idadeInput.value = '';
       
    })
    .catch(error => {
        console.error('Erro ao adicionar interesse:', error);
    });
});