package com.college.library;

import com.college.library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFile {

    @Autowired
    RepositoryFile rf;

    String forInsert(Library l)
    {
        rf.save(l);
        return "done";
    }

    Library getIdr(int id)
    {
        return rf.getReferenceById(id);
    }
    Library getIdf(int id)
    {
        return rf.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND "));
    }

    List<Library> getAll()
    {
        return rf.findAll();
    }

    String deleteRow(int id)
    {
        rf.deleteById(id);
        return "DELETION DONE";
    }

    Library update(Library l)
    {
        return rf.save(l);
    }

}
