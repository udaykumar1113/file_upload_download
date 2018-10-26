package com.uday.fileupload.repos;

import com.uday.fileupload.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRespository extends JpaRepository<Document,Integer> {
}
