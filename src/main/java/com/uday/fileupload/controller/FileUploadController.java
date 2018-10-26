package com.uday.fileupload.controller;

import com.uday.fileupload.entity.Document;
import com.uday.fileupload.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private DocumentService documentService;

    private static final Logger LOGGER= LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value="/showUpload")
    public String showUpload(ModelMap map){

        LOGGER.info("Redirecting request to file upload UI");
        map.addAttribute("documents",documentService.getallDocuments());
        return "documentUpload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadDocument(@RequestParam("id") int id,
                                 @RequestParam("document") MultipartFile document,
                                 ModelMap map){

        LOGGER.info("Inside document upload controller with id: "+id);
        Document doc=new Document();
        doc.setId(id);
        try {
            doc.setDocument(document.getBytes());
            doc.setDocumentName(document.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document savedDocument= documentService.saveDocument(doc);
        LOGGER.info("Document saved for id "+savedDocument.getId());
        map.addAttribute("documents",documentService.getallDocuments());
        return "documentUpload";
    }
}
