function mostrarAnimais(){
   const animalId = document.getElementById("abrirFormInteresse");
   console.log(animalId);

   const idAnimal = localStorage.getItem('idAnimal');
   

    fetch(`/animais/buscar/${idAnimal}`)
    .then(response => response.json())
    .then(data =>{        
        const infoAnimais = document.getElementById('infoAnimais');
        infoAnimais.innerHTML = `<div class="PrincipalImagens" data-id="${data.id}>
            <div class="Img1">
                <img class="Imagem1animal" src="${data.file1}" alt="">
            </div>
    
            <div class="Img2">
                <img class="Imagem2animal" src="${data.file2}" alt="">
            </div>
    
            <div class="Img3">
                <img class="Imagem3animal" src="${data.file2}" alt="">
            </div>
    
           </div>
    
            <div class="ParteFormulario">
                <a href=""><button class="ParteButtonParaFomes">Acesse o Formulário</button></a>
            </div>
    
        </div>`           
    })
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });
}
mostrarAnimais();