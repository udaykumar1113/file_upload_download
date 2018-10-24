package com.uday.fileupload.repos;

import com.uday.fileupload.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRespository extends CrudRepository<Document,Integer> {
}
