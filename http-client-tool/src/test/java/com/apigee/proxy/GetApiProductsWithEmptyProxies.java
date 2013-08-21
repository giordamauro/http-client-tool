package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.model.ApiProduct;
import com.util.ApiGeeUtil;

public class GetApiProductsWithEmptyProxies {

	public static void main(String[] args) {

		final String organization = "ecollege";
		final String username = "mgiorda@apigee.com";
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = publicApi.getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = publicApi.getApiProduct(apiProduct);
			List<String> proxies = apiProductInfo.getProxies();
			if (proxies.size() == 0) {
				products.add(apiProduct);
			}

		}
		System.out.println(products);

	}

}
