package com.marcin.controllers;

import com.marcin.exceptions.StorageFileNotFoundException;
import com.marcin.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final StorageService storageservice;


    @Autowired
    public FileUploadController(StorageService storageservice) {
        this.storageservice = storageservice;
    }

    @GetMapping("/file")
    public String listUploadedFiles(Model model) throws IOException{

        model.addAttribute("files", storageservice.loadAll().map(
                    path ->
                            MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"serveFile"
                                    ,path.getFileName().toString()).build().toUri().toString())
                                    .collect(Collectors.toList()));

        return "login-form2";
    }

    @GetMapping("/file/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageservice.loadAsResource(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + file.getFilename() +
                        "\"").body(file);
    }

    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {

        storageservice.store(file);
        redirectAttributes.addFlashAttribute("message", "You sucessFully uploaded " +
                    file.getOriginalFilename() + "!");

        return "redirect:/file";

    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
