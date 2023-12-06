
package com.example.registrationlogindemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpHeaders;

import com.example.registrationlogindemo.entity.Animais;
import com.example.registrationlogindemo.entity.Imagens;

//@RestController
@Controller
public class UploadController {

    public static List<Imagens> listaImagems = new ArrayList<Imagens>();

    @Value("${upload.path}")
    private String uploadPath;
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") List <MultipartFile> files,
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
            imagem.setCaminho("/img/animais/" + file.getOriginalFilename());
            listaImagems.add(imagem);
            redirectAttributes.addFlashAttribute("message",
                    "Upload realizado com sucesso: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        return "upload";
      
    }

    public static List<Imagens> getListaImagems(){
        return listaImagems;
    }

    public static void zerarLista(){
        listaImagems = new ArrayList<Imagens>();
    }
     @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        Path filePath = Paths.get(uploadPath).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static void limparListaImagems(){
        listaImagems.clear();
    }

}
