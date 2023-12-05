function mostrarAnimais(){
   //const animalId = document.getElementById("abrirFormInteresse");
   //console.log(animalId);

   const idAnimal = localStorage.getItem('idAnimal'); //pega o id do animal 
   
    fetch(`/animais/buscar/${idAnimal}`)
    .then(response => response.json())
    .then(data =>{        
        const infoAnimais = document.getElementById('infoAnimais');
        infoAnimais.innerHTML = `
                <div class="PrincipalImagens" data-id="${data.id}>
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
                                <p class="escritaOpacity3">Sobre esté animal</p>
                                <P class="partetextodes">${data.descricao}</P>
                            </div>
                </div>
                    </div>
                </div>
        
                <div class="ParteFormulario">
                    <a href="/formInteresse"><button class="ParteButtonParaFomes">Acesse o Formulário</button></a>
                </div>
        
            </div>
        `           
    })
    .catch(error => {
        console.error('Erro ao listar animais:', error);
    });
}

mostrarAnimais();