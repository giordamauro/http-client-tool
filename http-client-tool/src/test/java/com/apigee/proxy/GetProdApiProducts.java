package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.model.ApiProduct;
import com.apigee.model.Attribute;
import com.util.ApiGeeUtil;

public class GetProdApiProducts {

	public static void main(String[] args) {

		final String organization = "ecollege";
		final String username = "mgiorda@apigee.com";
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> apiProductsProd = new ArrayList<String>();

		List<String> apiProducts = publicApi.getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProd = publicApi.getApiProduct(apiProduct);
			List<Attribute> attributes = apiProd.getAttributes();
			for (Attribute att : attributes) {
				if (att.getName().equals("apisDeployedIn") && att.getValue().equals("prod")) {
					apiProductsProd.add(apiProduct);
				}
			}

		}
		System.out.println(apiProductsProd);

	}

}
