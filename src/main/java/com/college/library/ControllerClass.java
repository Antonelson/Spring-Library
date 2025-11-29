package com.college.library;

import com.college.library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/api")
public class ControllerClass {

    @Autowired
    ServiceFile s1;


    @PostMapping("/create")
    String create(@RequestBody Library l)
    {
        return s1.forInsert(l);
    }

    @GetMapping("/getr/{id}")
    ResponseEntity<Library> getir(@PathVariable int id)
    {
        try{
            return new ResponseEntity<>(s1.getIdr(id),HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>((HttpHeaders) null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get/{id}")
    ResponseEntity<Library> geti(@PathVariable int id)
    {
        try{
            Library l= s1.getIdf(id);
            System.out.println("d");
            return new ResponseEntity<>(l,HttpStatus.FOUND);
        }
        catch(RuntimeException e)
        {
            return new ResponseEntity<>((HttpHeaders) null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    ResponseEntity<List<Library>> geta()
    {
        return new ResponseEntity<>(s1.getAll(),HttpStatus.FOUND);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Library>> allByPage(@RequestParam int p,@RequestParam int s)
    {
        return new ResponseEntity<>(s1.getPage(p,s),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam int id)
    {
        return s1.deleteRow(id);
    }

    @PutMapping("/update")
    ResponseEntity<Library> update(@RequestBody Library rb)
    {
        return new ResponseEntity<>(s1.update(rb),HttpStatus.ACCEPTED);
    }


}
