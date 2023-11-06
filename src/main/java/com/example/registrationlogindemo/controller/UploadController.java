
package com.example.registrationlogindemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.registrationlogindemo.entity.Animais;
import com.example.registrationlogindemo.entity.Imagens;

@RestController
public class UploadController {

    public static List<Imagens> listaImagems = new ArrayList<Imagens>();

    @Value("${upload.path}")
    private String uploadPath;
    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("file") List <MultipartFile> files,
            RedirectAttributes redirectAttributes) {

        for (MultipartFile file: files){
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Por favor, selecione um arquivo para fazer upload.");
           
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + file.getOriginalFilename());
            Files.write(path, bytes);
            Imagens imagem = new Imagens();
            imagem.setCaminho(uploadPath + file.getOriginalFilename());
            listaImagems.add(imagem);
            redirectAttributes.addFlashAttribute("message",
                    "Upload realizado com sucesso: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    }

    public static List<Imagens> getListaImagems(){
        return listaImagems;
    }

    public static void zerarLista(){
        listaImagems = new ArrayList<Imagens>();
    }

}
