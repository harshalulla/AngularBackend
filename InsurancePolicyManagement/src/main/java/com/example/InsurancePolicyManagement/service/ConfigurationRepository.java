package com.example.InsurancePolicyManagement.service;

import com.example.InsurancePolicyManagement.datamodel.PolicyConfiguration;
import com.example.InsurancePolicyManagement.datamodel.Policies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends CrudRepository<PolicyConfiguration, String> {

    @Query(value = " SELECT c.id||','|| c.policynumber||','|| c.amount FROM policies c",nativeQuery=true)
    public Iterable<String> findAllCategory();


    @Query(value = " update policies c  SET c.policynumber=?,c.amount=?,c.id=? where c.id=?",nativeQuery=true)
    public PolicyConfiguration updatePolicybyid(Policies policies);


    public PolicyConfiguration findById(Long  id);

    public void deleteById(Long  id);

}
