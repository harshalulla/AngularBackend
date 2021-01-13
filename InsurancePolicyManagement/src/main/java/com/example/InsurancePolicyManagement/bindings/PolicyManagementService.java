package com.example.InsurancePolicyManagement.bindings;

import com.example.InsurancePolicyManagement.datamodel.Policies;
import com.example.InsurancePolicyManagement.datamodel.PolicyConfiguration;
import com.example.InsurancePolicyManagement.service.ConfigurationRepository;
import com.example.InsurancePolicyManagement.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PolicyManagementService {
    @Autowired
    private ConfigurationRepository configRepository;

    public PolicyConfiguration savePolicy(Policies policies) {
        PolicyConfiguration master = CommonUtils.convert(policies, new PolicyConfiguration());
        PolicyConfiguration save = configRepository.save(master);
        return save;
    }

    public PolicyConfiguration getPolicybynumber(Policies policies) {
        PolicyConfiguration master = CommonUtils.convert(policies, new PolicyConfiguration());
        //PolicyConfiguration master1 = configRepository.findOneByNumber(master.getPolicynumber());
        //PolicyConfiguration convert = CommonUtils.convert(policies, new PolicyConfiguration());
        return master;

    }

    public List<PolicyConfiguration> getAllPolicy() {
        Iterable<String> allPolicy = configRepository.findAllCategory();
        List<PolicyConfiguration> master = CommonUtils.convertAll(allPolicy);
        return master;

    }


    public Boolean deletePolicy(String policies) {
       configRepository.deleteById(Long.valueOf(policies));
        return true;
    }


    public PolicyConfiguration updatePolicy(Policies policies) {
        PolicyConfiguration master = CommonUtils.convert(policies, new PolicyConfiguration());
      //  PolicyConfiguration save = configRepository.save(master);
		PolicyConfiguration onebyID = configRepository.findById(Long.valueOf(policies.getId()));
        onebyID.setPolicynumber(policies.getPolicynumber());
        onebyID.setAmount(policies.getAmount());
        configRepository.save(onebyID);
		return onebyID;
    }

}
