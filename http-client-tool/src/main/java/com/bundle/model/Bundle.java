package com.bundle.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.BundleUtils;
import com.util.ZipUtils;

public class Bundle {

	private final ApiProxy apiProxy;

	private final Map<String, ProxyEndpoint> proxies;

	private final Map<String, TargetEndpoint> targets;

	private Bundle(ApiProxy apiProxy, Map<String, ProxyEndpoint> proxies, Map<String, TargetEndpoint> targets) {
		this.apiProxy = apiProxy;
		this.proxies = proxies;
		this.targets = targets;
	}

	public static Bundle loadFromZip(String zipFilePath) {
		ZipUtils.unZipFile(zipFilePath, BundleUtils.TEMP_BUNDLE_PATH);

		ApiProxy apiProxy = BundleUtils.getApiProxyInfo();

		Map<String, ProxyEndpoint> proxies = new HashMap<String, ProxyEndpoint>();

		List<String> proxyEndpoints = apiProxy.getProxyEndpoints();
		for (String proxyEndpoint : proxyEndpoints) {
			ProxyEndpoint endpoint = BundleUtils.getProxyEndpoint(proxyEndpoint + ".xml");
			proxies.put(proxyEndpoint, endpoint);
		}

		Map<String, TargetEndpoint> targets = new HashMap<String, TargetEndpoint>();

		List<String> targetEndpoints = apiProxy.getTargetEndpoints();
		for (String targetEndpoint : targetEndpoints) {
			TargetEndpoint endpoint = BundleUtils.getTargetEndpoint(targetEndpoint + ".xml");
			targets.put(targetEndpoint, endpoint);
		}

		Bundle bundle = new Bundle(apiProxy, proxies, targets);

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
}
