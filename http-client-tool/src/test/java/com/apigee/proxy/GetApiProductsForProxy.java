package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.ApiProduct;
import com.util.ApiGeeUtil;

public class GetApiProductsForProxy {

	public static void main(String[] args) {

		final String organization = Org.STAPLES;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final String proxyName = "StaplesEasyOpenAPI";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = publicApi.getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = publicApi.getApiProduct(apiProduct);
			List<String> proxies = apiProductInfo.getProxies();
			for (String proxy : proxies) {
				if (proxy.equalsIgnoreCase(proxyName)) {
					products.add(apiProductInfo.getName());
				}
			}

		}
		System.out.println(products);

	}

}
