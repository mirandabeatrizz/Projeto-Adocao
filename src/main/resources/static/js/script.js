//LISTAR ANIMAIS CADASTRADOS
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
        const botoesEditar = document.getElementById('editar');
        const popup = document.getElementById('popup');

        botoesEditar.addEventListener('click', function(){
            popup.style.display='flex';
            const nomeInput = document.getElementById('nome');
            const tipoInput = document.getElementById('tipo');
            const porteInput = document.getElementById('porte');
            const idadeInput = document.getElementById('idade');
            const castradoInput = document.querySelector('input[name="castrado"]:checked');
            const vacinadoInput = document.querySelector('input[name="vacinado"]:checked');
            const descricaoInput = document.getElementById('descricao');
            

            const nome = nomeInput.value;
            const tipo = tipoInput.value;
            const porte = porteInput.value;
            const idade = idadeInput.value;
            const castrado = castradoInput.value;
            const vacinado = vacinadoInput.value;
            const descricao = descricaoInput.value;

            fetch(`/animais/editar/${id}`, {
                method: 'UPDATE',
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
        console.error('Erro ao listar produtos:', error);
    });
}

/*document.getElementById('addImgs').addEventListener('click', function(){
    fetch('upload',{
        method: 'POST'
    })
})*/

//CADASTRAR NOVO ANIMAL
document.getElementById('addAnimais').addEventListener('click', function(){
    const nomeInput = document.getElementById('nome');
    const tipoInput = document.getElementById('tipo');
    const porteInput = document.getElementById('porte');
    const idadeInput = document.getElementById('idade');
    const castradoInput = document.querySelector('input[name="castrado"]:checked');
    const vacinadoInput = document.querySelector('input[name="vacinado"]:checked');
    const descricaoInput = document.getElementById('descricao');
    const fileInput1 = document.getElementById('file1');

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
        nomeInput.value = '';
        tipoInput.value = '';
        porteInput.value = '';
        idadeInput.value = '';
        castradoInput.value = '';
        vacinadoInput.value = '';
        descricaoInput.value = '';
    })
    .catch(error => {
        console.error('Erro ao adicionar animal:', error);
    });

});


const abrirBtn = document.getElementById('btnAbrir');
const popup = document.getElementById('popup');
const fecharBtn = document.getElementById('addAnimais');

abrirBtn.addEventListener('click', ()=>{
    popup.style.display='flex';
});

fecharBtn.addEventListener('click', ()=>{
    popup.style.display='none';
});

listarAnimais();