package com.uday.fileupload.service;

import com.uday.fileupload.entity.Document;

import java.util.List;

public interface DocumentService {

    public Document saveDocument(Document document);

    public List<Document> getallDocuments();

    public Document getDocument(int id);
}
