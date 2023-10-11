document.getElementById('addAnimais').addEventListener('click', function(){
    const nomeInput = document.getElementById('nome');
    const tipoInput = document.getElementById('tipo');
    const porteInput = document.getElementById('porte');
    const idadeInput = document.getElementById('idade');
    const fotoInput = document.getElementById('foto');
    const castradorInput = document.getElementById('castrado');
    const vacinadoInput = document.getElementById('vacinado');

    const nome = nomeInput.value;
    const tipo = tipoInput.value;
    const porte = porteInput.value;
    const idade = idadeInput.value;
    const foto = fotoInput.value;
    const castrado = castradorInput.value;
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
        castradorInput.value = '';
        vacinadoInput.value = '';
    })
    .catch(error => {
        console.error('Erro ao adicionar livro:', error);
    });



});