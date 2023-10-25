document.getElementById('fzrLogin').addEventListener('click', function(){
    const nomeInput = document.getElementById('nome');
    const emailInput = document.getElementById('email');
    const senhaInput = document.getElementById('senha');

    const nome = nomeInput.value;
    const email = emailInput.value;
    const senha = senhaInput.value;

    fetch('/adm/adicionar',{
        method: 'POST',
        headers:{
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome,
            email: email,
            senha: senha
        })
    })
    .then(response => response.json())
    .then(data =>{
        window.confirm(`Usuário ${data.nome} adicionado com sucesso`);
        nomeInput.value ='';
        emailInput.value ='';
        senhaInput.value = '';
    })
    .catch(error=>{
        console.error('erro ao adicionar usuário:', error);
    })
});

function listarUsers(){
    fetch('/adm/listar')
    .then(response => response.json())
    .then (data =>{
        const listaUsers = document.getElementById('listaUsers');
        listaUsers.innerHTML ='';

        data.forEach(user =>{
            const tr = document.createElement('tr');
            tr.innerHTML = ` 
            <td> ${user.id}</td>
            <td> ${user.nome}</td>
            <td> ${user.email}</td>
            <td> ${user.senha}</td>
            <td> <button class="btn-excluir" data-id="${user.id}">  Excluir </buttom>
            </td>`;
            listaUsers.appendChild(tr);
        });
    })
    .catch(error => {
        console.error('Erro ao listar usuários:', error);
    });
}
listarUsers();
