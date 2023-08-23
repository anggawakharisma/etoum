package com.tabeldata.etoum.service;

import com.tabeldata.etoum.dao.ExampleDao;
import com.tabeldata.etoum.dto.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleDao dao;

    public List<Example> findAll(){
        return this.dao.findAll();
    }

}
