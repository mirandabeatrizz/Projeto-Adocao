function listarUsers(){
    fetch('/user/listar')
    .then(response => response.json())
    .then (data =>{
        const listaUsers = document.getElementById('listaUsers');
        listaUsers.innerHTML ='';

        data.forEach(user =>{
            const tr = document.createElement('tr');
            tr.innerHTML = ` 
            <td> ${user.nome}</td>
            <td> ${user.email}</td>
            <td> 
            <button class="btn-excluir" data-id="${user.id}">  Excluir </buttom>
            <button class="btn-editar" data-id="${user.id}">  Editar </buttom>
            </td>`;
            listaUsers.appendChild(tr);
        });
    })
    .catch(error => {
        console.error('Erro ao listar usuários:', error);
    });
}
listarUsers();
