package com.kodcu.controller;
/*
 * Created by hakdogan on 28/11/2017
 */

import com.kodcu.dao.QueryDAO;
import com.kodcu.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class RestRequestController {

    @Autowired
    private QueryDAO dao;

    /**
     *
     * @param document
     * @return
     */
    @PostMapping(value = "/api/create", consumes = "application/json; charset=utf-8")
    public String create(@RequestBody Document document) {
        return dao.createIndex(document);
    }

    @GetMapping(value = "/api/delete")
    public void delete(String id){
        dao.deleteDocument(id);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/api/all", produces = "application/json; charset=utf-8")
    public List<Document> getAllDocuments() {
        return dao.matchAllQuery();
    }

    /**
     *
     * @param query
     * @return
     */
    @GetMapping("/api/search")
    public List<Document> search(@RequestParam("query") String query) {
        return dao.wildcardQuery(query);
    }
}
