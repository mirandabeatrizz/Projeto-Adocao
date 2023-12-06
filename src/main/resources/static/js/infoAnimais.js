function mostrarAnimais(){
   //const animalId = document.getElementById("abrirFormInteresse");
   //console.log(animalId);

   const idAnimal = localStorage.getItem('idAnimal'); //pega o id do animal 
   
    fetch(`/animais/buscar/${idAnimal}`)
    .then(response => response.json())
    .then(data =>{        
        const infoAnimais = document.getElementById('infoAnimais');
        infoAnimais.innerHTML = `
                <div class="PrincipalImagens" >
                       
                        <div class="Img1">
                            <img class="Imagem1animal" src="${data.file1}" alt="">
                        </div>
                
                        <div class="Img2">
                            <img class="Imagem2animal" src="${data.file2}" alt="">
                        </div>
                
                        <div class="Img3">
                            <img class="Imagem3animal" src="${data.file3}" alt="">
                        </div>
                </div>
    
                <div class="partetotaldapa">
                <div class="patrafdasdasdasd">
                        <div class="asaqw">
                            <div class="ParteNomeAnimalGrande">
                                <a class="a100"> ${data.nome}</a>
                            </div>
                <div class="parttedebaixoparadarcem">
                            <div class="ParteNomes">
                                    <div class="escritaTipo">
                                        <p class="escritaOpacity">Tipo</p>
                                        <a class="a8"> ${data.tipo}</a>
                                    </div>
                                    <div class="escritaNome">
                                        <p class="escritaOpacity">Porte</p>
                                        <a class="a8"> ${data.porte}</a>
                                    </div>
        
                                    <div class="escritaCastrado">
                                        <p class="escritaOpacity">Castrado</p>
                                        <a class="a8"> ${data.castrado}</a>
                                    </div>
                            </div>
        
                            <div class="ParteNomes2">
                                    <div class="escritanome">
                                        <p class="escritaOpacity2">Nome</p>
                                        <a class="a28"> ${data.nome}</a>
                                    </div>
        
                                    <div class="escritaIdade">
                                        <p class="escritaOpacity2">Idade</p>
                                        <a class="a28"> ${data.idade}</a>
                                    </div>
        
                                    <div class="escritaVacinado">
                                        <p class="escritaOpacity2">Vacinado</p>
                                        <a class="a28"> ${data.vacinado}</a>
                                    </div>
                            </div>
                            <div class="ParteDescricao">
                                <p class="escritaOpacity3">Sobre este animal</p>
                                <P class="partetextodes">${data.descricao}</P>
                            </div>
                </div>
                    </div>
                </div>
        
                <div class="ParteFormulario">
                <button class="ParteButtonParaFomes" id = "editar" data-id="${data.id}" >Acesse o Formulário</button>
                </div>
        
            </div>
        `      
        const botoesEditar = document.querySelectorAll('.ParteButtonParaFomes');

       botoesEditar.forEach(botao => {
            botao.addEventListener('click', function() {
                const id = localStorage.getItem('idAnimal');
                abrirFormularioEdicao(id);
                
            });
        });     
    })
    
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });
}
function abrirFormularioEdicao(id) {
    
    const formularioEdicao = document.getElementById('formpopup');
    formularioEdicao.style.display = 'flex';

    const nomeInput = document.getElementById('nome');
    const cpfInput = document.getElementById('cpf');
    const emailInput = document.getElementById('email');
    //const telefoneInput = document.getElementById('teleofne');
    const cepInput = document.getElementById('cep');
    const idadeInput = document.getElementById('idade');
    const msgInput = document.getElementById('msg');
    localStorage.setItem('idAnimal', id);

    const nome = nomeInput.value;
    const cpf = cpfInput.value;
    const email = emailInput.value;
    //const telefone = telefoneInput.value;
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
            cep: cep,
            msg: msg,
            idade: idade

        })  
    })
    .then(response => response.json())
    .then(data => {
        alert(`Animal com ID ${id} editado com sucesso.`);
        formularioEdicao.style.display = 'none';
       
    })
    .catch(error => {
        console.error('Erro ao adicionar interesse:', error);
    });
}


mostrarAnimais();