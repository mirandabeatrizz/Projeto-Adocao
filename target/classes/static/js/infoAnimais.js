function mostrarAnimais(){
   const animalId = document.getElementById("abrirFormInteresse");
   console.log(animalId);

    fetch(`/animais/buscar/${id}`)
    .then(response => response.json())
    .then(data =>{
        const infoAnimais = document.getElementById('infoAnimais');
        infoAnimais.innerHTML = '';
        
        data.forEach(animal => {
            const div = document.createElement('div');
            div.innerHTML = `<div class="PrincipalImagens" data-id="${animal.id}>
            <div class="Img1">
                <img class="Imagem1animal" src="${animal.file1}" alt="">
            </div>
    
            <div class="Img2">
                <img class="Imagem2animal" src="" alt="">
            </div>
    
            <div class="Img3">
                <img class="Imagem3animal" src="" alt="">
            </div>
    
           </div>
    
            <div class="ParteFormulario">
                <a href=""><button class="ParteButtonParaFomes">Acesse o Formulário</button></a>
            </div>
    
        </div>`;
            infoAnimais.appendChild(div);
        });
    })
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });
}
mostrarAnimais();