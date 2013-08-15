package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.ApiProxy;
import com.apigee.model.ApiRevision;
import com.util.ApiGeeUtil;

public class GetApiProxiesEndpoint {

	public static void main(String[] args) {

		final String organization = Org.LIVE_NATION;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> proxiesPaths = new ArrayList<String>();

		List<String> proxies = publicApi.getApiProxies();

		for (String proxy : proxies) {
			ApiRevision apiRevision = publicApi.getApiRevisions(proxy);
			List<Integer> revisions = apiRevision.getRevision();
			if (!revisions.isEmpty()) {
				int lastRev = revisions.get(revisions.size() - 1);
				ApiProxy apiProxy = publicApi.getApiProxyRevision(proxy, lastRev);
				// TODO
			}
		}

		System.out.println(proxiesPaths);

	}
}
