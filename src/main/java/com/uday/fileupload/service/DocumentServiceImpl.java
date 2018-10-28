package com.uday.fileupload.service;

import com.uday.fileupload.entity.Document;
import com.uday.fileupload.repos.DocumentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRespository documentRespository;

    @Override
    public Document saveDocument(Document document) {
        return documentRespository.save(document);
    }

    @Override
    public List<Document> getallDocuments() {
        return documentRespository.findAll();
    }

    @Override
    public Document getDocument(int id) {
        return documentRespository.getOne(id);
    }
}
