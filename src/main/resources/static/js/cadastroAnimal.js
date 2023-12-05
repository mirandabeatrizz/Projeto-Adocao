/*----------------------------LISTA ANIMAIS------------------------------------- */
function listarAnimais(){
    fetch('/animais/listar')
    .then(response => response.json())
    .then(data =>{
        const listaAnimais = document.getElementById('listaAnimais');
        listaAnimais.innerHTML = '';
        
        data.forEach(animal => {
            const tr = document.createElement('tr');
            tr.innerHTML = ` <td>${animal.nome}</td>
            <td>${animal.tipo}</td>
            <td>${animal.porte}</td>
            <td>${animal.idade}</td>
            <td>${animal.descricao}</td>
            <td>${animal.castrado}</td>
            <td>${animal.vacinado}</td>
            <td> 
                <button class="botao-excluir flat-button" data-id="${animal.id}">Excluir</button>
                <button class="botao-editar flat-button" id = "editar" data-id="${animal.id}">Editar</button>
            </td> `;

            listaAnimais.appendChild(tr);
        });
        //BOTÃO PRA CHAMAR O EXCLUIR
        const botoesExcluir = document.querySelectorAll('.botao-excluir');
        const botoesEditar = document.querySelectorAll('.botao-editar');

        botoesEditar.forEach(botao => {
            botao.addEventListener('click', function() {
                const id = botao.getAttribute('data-id');
                abrirFormularioEdicao(id);
            });
        });

        botoesExcluir.forEach(botao => {
            botao.addEventListener('click', function () {
                const id = botao.getAttribute('data-id');
                // Confirmar com o usuário antes de excluir
                const confirmacao = confirm('Tem certeza de que deseja excluir este animal?');
               

                if (confirmacao) {
                    // Enviar a solicitação DELETE
                    fetch(`/animais/excluir/${id}`, {
                        method: 'DELETE'
                    })
                        .then(response => {
                            if (response.ok) {
                                window.confirm(`Animal com ID ${id} excluído com sucesso.`);
                                listarAnimais();
                            } else {
                                console.error(`Erro ao excluir o animal com ID ${id}`);
                            }
                        })
                        .catch(error => {
                            console.error(`Erro ao excluir o animal com ID ${id}:`, error);
                        });
                }
            });
        })

    })
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });

}

/*----------------------------MOSTRAR DADOS DO ANIMAL NO EDITAR------------------------------------- */
function abrirFormularioEdicao(id) {
    // Aqui, você deve obter as informações do animal com o ID fornecido
    fetch(`/animais/buscar/${id}`)
    .then(response => response.json())
    .then(animal => {
        
        const formularioEdicao = document.getElementById('formularioEdicao');
        formularioEdicao.style.display = 'flex';
        
        const nomeInput = document.getElementById('nome');
        const tipoInput = document.getElementById('tipo');
        const porteInput = document.getElementById('porte');
        const idadeInput = document.getElementById('idade');
        const descricaoInput = document.getElementById('descricao');
        const castradoInput = document.getElementById('castrado');
        const vacinadoInput = document.getElementById('vacinado');
        
        document.getElementById('animalId').value = id;
        
        // Preencha os campos do formulário com as informações do animal
        nomeInput.value = animal.nome;
        tipoInput.value = animal.tipo;
        porteInput.value = animal.porte;
        idadeInput.value = animal.idade;
        descricaoInput.value = animal.descricao;
        castradoInput.checked = animal.castrado;
        vacinadoInput.checked = animal.vacinado;
        
    })
    .catch(error => {
        console.error(`Erro ao obter informações do animal com ID ${id}:`, error);
    });
}
/*----------------------------SALVAR EDIÇÃO ANIMAIS------------------------------------- */
const botaoSalvar = document.getElementById('botaoSalvar');
botaoSalvar.addEventListener('click', function() {
    // Aqui você deve enviar a solicitação de atualização para o servidor
    const id = animalIdInput.value;
    const novoNome = nomeInput.value;
    const novoTipo = tipoInput.value;
    const novoPorte = porteInput.value;
    const novaIdade = idadeInput.value;
    const novaDescricao = descricaoInput.value;
    const novoCastrado = castradoInput.checked;
    const novoVacinado = vacinadoInput.checked;
    
    fetch(`/animais/editar/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: novoNome,
            tipo: novoTipo,
            porte: novoPorte,
            idade: novaIdade,
            descricao: novaDescricao,
            castrado: novoCastrado,
            vacinado: novoVacinado
        })
    })
    .then(response => {
        if (response.ok) {
            alert(`Animal com ID ${id} editado com sucesso.`);
            formularioEdicao.style.display = 'none'; // Feche o formulário de edição
            listarAnimais();// Atualize a lista de animais após a edição
        } else {
            console.error(`Erro ao editar o animal com ID ${id}`);
        }
    })
    .catch(error => {
        console.error(`Erro ao editar o animal com ID ${id}:`, error);
    });
});

/*----------------------------ABRIR FORM CADASTRO NOVO ANIMAIS------------------------------------- */

const abrirBtn = document.getElementById('btnAbrir');
const popup = document.getElementById('popup');
const fecharBtn = document.getElementById('addAnimais');

abrirBtn.addEventListener('click', ()=>{
    popup.style.display='flex';
    localStorage.setItem('visited', 'true');
});

fecharBtn.addEventListener('click', ()=>{
    popup.style.display='none';
});


/*----------------------------SALVA O CADASTRAR NOVO ANIMAIS------------------------------------- */

const nomeInput = document.getElementById('nome');
const tipoInput = document.getElementById('tipo');
const porteInput = document.getElementById('porte');
const idadeInput = document.getElementById('idade');
const descricaoInput = document.getElementById('descricao');
const castradoInput = document.getElementById('castrado');
const vacinadoInput = document.getElementById('vacinado');
const animalIdInput = document.getElementById('animalId');

document.getElementById('addAnimais').addEventListener('click', function(){
    const nomeInput = document.getElementById('nomeAdd');
    const tipoInput = document.getElementById('tipoAdd');
    const porteInput = document.getElementById('porteAdd');
    const idadeInput = document.getElementById('idadeAdd');
    const castradoInput = document.querySelector('input[name="castrado"]:checked');
    const vacinadoInput = document.querySelector('input[name="vacinado"]:checked');
    const descricaoInput = document.getElementById('descricaoAdd');
    const imagemInput = document.getElementById('file1');
    
    const nome = nomeInput.value;
    const tipo = tipoInput.value;
    const porte = porteInput.value;
    const idade = idadeInput.value;
    const castrado = castradoInput.value;
    const vacinado = vacinadoInput.value;
    const descricao = descricaoInput.value;

    fetch('/animais/adicionar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome,
            tipo: tipo,
            porte: porte,
            idade: idade,
            descricao: descricao,
            castrado: castrado,
            vacinado: vacinado
        })
    })
    .then(response => response.json())
    .then(data => {
        window.confirm(`Animal ${data.nome} adicionado com sucesso`);
        console
        nomeInput.value = '';
        tipoInput.value = '';
        porteInput.value = '';
        idadeInput.value = '';
        castradoInput.value = '';
        vacinadoInput.value = '';
        descricaoInput.value = '';
        imagemInput.value = '';
        
        listarAnimais();

        localStorage.setItem('visited', 'false');
    })
    .catch(error => {
        console.error('Erro ao adicionar animal:', error);
    });

});

/*----------------------------CHAMA A LISTA ANIMAIS------------------------------------- */
listarAnimais();

/*
function limitarQtdArquivos(files){
    var maximoArq = 3;

    if(files.length > maximoArq){
        document.getElementById('file1').value = '';
        document.getElementById('mensagemErro').innerText = 'O máximo de imagens permitidas é de até' + maximoArq;
    } else{
        document.getElementById('mensagemErro').innerText = '';
    }
}
*/