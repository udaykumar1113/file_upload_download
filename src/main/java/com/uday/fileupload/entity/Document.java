package com.uday.fileupload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Arrays;

@Entity
public class Document {

    @Id
    private int id;
    @Column(name="file_name")
    private String documentName;
    @Lob
    @Column(name="file_data")
    private byte[] document;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", document=" + Arrays.toString(document) +
                '}';
    }
}
