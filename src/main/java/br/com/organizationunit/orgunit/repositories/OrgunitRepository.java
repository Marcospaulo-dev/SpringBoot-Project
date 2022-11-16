package br.com.organizationunit.orgunit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.organizationunit.orgunit.models.OrgunitModel;


public interface OrgunitRepository extends JpaRepository<OrgunitModel, Long>{

    public List<OrgunitModel> findByIdGreaterThan(Long id);

    public List<OrgunitModel> findByNameIgnoreCase(String name);

    public Optional<OrgunitModel> findById(Long id);

    public void deleteById(Long id);
    
}
