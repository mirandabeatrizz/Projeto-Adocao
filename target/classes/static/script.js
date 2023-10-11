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
            <td>${animal.foto}</td>
            <td>${animal.castrado}</td>
            <td>${animal.vacinado}</td>
            <td>
                     
                <button class="botao-excluir flat-button" data-id="${animal.id}">Excluir</button>
            </td> `;

            listaAnimais.appendChild(tr);
        });
        const botoesExcluir = document.querySelectorAll('.botao-excluir');

        botoesExcluir.forEach(botao => {
            botao.addEventListener('click', function () {
                const id = botao.getAttribute('data-id');
                // Confirmar com o usuário antes de excluir
                const confirmacao = confirm('Tem certeza de que deseja excluir este produto?');

                if (confirmacao) {
                    // Enviar a solicitação DELETE
                    fetch(`/animais/excluir/${id}`, {
                        method: 'DELETE'
                    })
                        .then(response => {
                            if (response.ok) {
                                window.confirm(`Produto com ID ${id} excluído com sucesso.`);
                                listarAnimais();
                            } else {
                                console.error(`Erro ao excluir o produto com ID ${id}`);
                            }
                        })
                        .catch(error => {
                            console.error(`Erro ao excluir o produto com ID ${id}:`, error);
                        });
                }
            });
        });

    })
    .catch(error => {
        console.error('Erro ao listar produtos:', error);
    });
}
document.getElementById('addAnimais').addEventListener('click', function(){
    const nomeInput = document.getElementById('nome');
    const tipoInput = document.getElementById('tipo');
    const porteInput = document.getElementById('porte');
    const idadeInput = document.getElementById('idade');
    const fotoInput = document.getElementById('foto');
    const castradoInput = document.getElementById('castrado');
    const vacinadoInput = document.getElementById('vacinado');

    const nome = nomeInput.value;
    const tipo = tipoInput.value;
    const porte = porteInput.value;
    const idade = idadeInput.value;
    const foto = fotoInput.value;
    const castrado = castradoInput.value;
    const vacinado = vacinadoInput.value;

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
            foto: foto,
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
        fotoInput.value = '';
        castradoInput.value = '';
        vacinadoInput.value = '';
    })
    .catch(error => {
        console.error('Erro ao adicionar animal:', error);
    });

});

listarAnimais();