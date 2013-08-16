package com.bundle.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bundle.model.policy.Policy;
import com.util.BundleUtils;
import com.util.ZipUtils;

public class Bundle {

	private final ApiProxy apiProxy;

	private final Map<String, ProxyEndpoint> proxies;

	private final Map<String, TargetEndpoint> targets;

	private final Map<String, Policy> policies;

	private Bundle(ApiProxy apiProxy, Map<String, ProxyEndpoint> proxies, Map<String, TargetEndpoint> targets, Map<String, Policy> policies) {
		this.apiProxy = apiProxy;
		this.proxies = proxies;
		this.targets = targets;
		this.policies = policies;
	}

	public static Bundle loadFromZip(String zipFilePath) {
		ZipUtils.unZipFile(zipFilePath, BundleUtils.TEMP_BUNDLE_PATH);

		ApiProxy apiProxy = BundleUtils.getApiProxyInfo();

		Map<String, ProxyEndpoint> proxies = new HashMap<String, ProxyEndpoint>();

		List<String> proxyEndpoints = apiProxy.getProxyEndpoints();
		for (String proxyEndpoint : proxyEndpoints) {
			ProxyEndpoint endpoint = BundleUtils.getProxyEndpoint(proxyEndpoint);
			proxies.put(proxyEndpoint, endpoint);
		}

		Map<String, TargetEndpoint> targets = new HashMap<String, TargetEndpoint>();

		List<String> targetEndpoints = apiProxy.getTargetEndpoints();
		for (String targetEndpoint : targetEndpoints) {
			TargetEndpoint endpoint = BundleUtils.getTargetEndpoint(targetEndpoint);
			targets.put(targetEndpoint, endpoint);
		}

		Map<String, Policy> policies = new HashMap<String, Policy>();

		List<String> policiesList = apiProxy.getPolicies();
		for (String policy : policiesList) {
			Class<Policy> policyType = BundleUtils.getPolicyType(policy);
			Policy thePolicy = BundleUtils.getPolicy(policy, policyType);
			thePolicy.setType(policyType);
			policies.put(policy, thePolicy);
		}

		Bundle bundle = new Bundle(apiProxy, proxies, targets, policies);

		return bundle;
	}

	public ApiProxy getApiProxy() {
		return apiProxy;
	}

	public Map<String, ProxyEndpoint> getProxies() {
		return proxies;
	}

	public Map<String, TargetEndpoint> getTargets() {
		return targets;
	}

	public Map<String, Policy> getPolicies() {
		return policies;
	}

	public <T extends Policy> T getPolicy(String name) {
		if (!policies.containsKey(name)) {
			throw new IllegalStateException(String.format("Policy named '%s' does not exist in the bundle", name));
		}

		@SuppressWarnings("unchecked")
		T policy = (T) policies.get(name);

		return policy;
	}
}
