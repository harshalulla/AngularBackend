package com.example.InsurancePolicyManagement.utils;

import com.example.InsurancePolicyManagement.datamodel.Policies;
import com.example.InsurancePolicyManagement.datamodel.PolicyConfiguration;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

	public static PolicyConfiguration convert(Policies policies, PolicyConfiguration configuration) {
		
		BeanUtils.copyProperties(policies, configuration);
		return configuration;
	}
	public static List<PolicyConfiguration> convertAll(Iterable<String> configList) {

		List<PolicyConfiguration> list = new ArrayList<PolicyConfiguration>();
		for (String config : configList) {
			String[] split = config.split(",");
			if (split.length > 1) {

				PolicyConfiguration policyConfig = new PolicyConfiguration();
				policyConfig.setAmount(split[2]);
				policyConfig.setPolicynumber(split[1]);
				policyConfig.setId(Long.valueOf(split[0]));
				list.add(policyConfig);
			} else {
				list.add(new PolicyConfiguration());
			}
		}
		return list;
	}

}
