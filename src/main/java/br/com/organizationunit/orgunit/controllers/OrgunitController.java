package br.com.organizationunit.orgunit.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.organizationunit.orgunit.models.OrgunitModel;
import br.com.organizationunit.orgunit.repositories.OrgunitRepository;

@RestController
@RequestMapping("/orgunit")
public class OrgunitController {
    
    //GET POST PUT DELETE PATCH
    
    @Autowired
    private OrgunitRepository orgunitRespository;

    
    @GetMapping("/{id}")
    public OrgunitModel orgunitModel(@PathVariable("id") Long id){
        Optional<OrgunitModel> orgunitFind;
        orgunitFind = this.orgunitRespository.findById(id);

        if(orgunitFind.isPresent()){
            return orgunitFind.get();
        }
        
        return null;
    }

    @PostMapping("/")
    public OrgunitModel insert(@RequestBody OrgunitModel orgunit){
        return this.orgunitRespository.save(orgunit);
    }

    @PutMapping("/")
    public OrgunitModel update(@RequestBody OrgunitModel orgunit){
        return this.orgunitRespository.save(orgunit);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.orgunitRespository.deleteById(id);
    }
    
    @GetMapping("/list")
    public List<OrgunitModel> findAll(){
        return this.orgunitRespository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<OrgunitModel> findById(@PathVariable("id") Long id){
        return this.orgunitRespository.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<OrgunitModel> findByName(@PathVariable("name") String name){
        return this.orgunitRespository.findByNameIgnoreCase(name);
    }
 
    @GetMapping("/list/{id}")
    public List<OrgunitModel> listMoreThanOrgunit(@PathVariable("id") Long id){
        return this.orgunitRespository.findByIdGreaterThan(id);
    }
}
