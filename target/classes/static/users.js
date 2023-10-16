document.getElementById('fzrLogin').addEventListener('click', function(){
    const loginInput = document.getElementById('login');
    const senhaInput = document.getElementById('senha');

    const login = loginInput.value;
    const senha = senhaInput.value;

    fetch('/adm/adicionar',{
        method: 'POST',
        headers:{
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            login: login,
            senha: senha
        })
    })
    .then(response => response.json())
    .then(data =>{
        window.confirm(`Usuário ${data.login} adicionado com sucesso`);
        loginInput.value ='';
        senhaInput.value = '';
    })
    .catch(error=>{
        console.error('erro ao adicionar usuário:', error);
    })
});

function listarUsers(){
    fetch('adm/listar')
    .then(response => response.json())
    .then (data => {
        const listaUsers = document.getElementById('listaUsers');
        listaUsers.innerHTML ='';

        data.forEach(user =>{
            const tr = document.createElement('tr');
            tr.innerHTML = ` <td> ${user.login}</td>
            <td> ${user.senha}</td>
            <td> <button class="btn-excluir" data-id="${user.id}">  Excluir </buttom>
            </td>`;
            listaUsers.appendChild(tr);
        });
    })
}

listarUsers();