package com.apigee.proxy;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.model.DeveloperApp;
import com.apigee.model.DeveloperAppApiProduct;
import com.util.ApiGeeUtil;

public class GetAppsForApiProduct {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";
		final String apiProductName = "betami";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> apps = new ArrayList<String>();

		List<String> develperApps = publicApi.getApps();

		for (String app : develperApps) {
			DeveloperApp appInfo = publicApi.getApp(app);
			List<DeveloperAppApiProduct> appProducts = appInfo.getApiProducts();
			for (DeveloperAppApiProduct appProduct : appProducts) {
				if (appProduct.getApiproduct().equalsIgnoreCase(apiProductName)) {
					apps.add(app);
				}
			}

		}
		System.out.println(apps);

	}

}
