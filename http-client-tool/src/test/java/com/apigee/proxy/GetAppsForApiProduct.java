package com.apigee.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apigee.ApigeeAPI;
import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.apigee.model.DeveloperAppApiProduct;
import com.util.ApiGeeUtil;

public class GetAppsForApiProduct {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";
		// final List<String> apiProducts = Arrays.asList(new String[] {
		// "beta2", "NORMAL1", "Normal", "betapm", "testapiproduct", "sandbox",
		// "Silver", "Gold", "piapi_poc_2", "piapi_poc_4", "HIGH",
		// "MI_Unlimited", "rumbapi", "Beta" });

		final List<String> apiProducts = Collections.singletonList("product_without_attribute");

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		Map<String, List<String>> apps = new HashMap<String, List<String>>();

		List<String> develperApps = publicApi.getApps();

		for (String app : develperApps) {
			DeveloperApp appInfo = publicApi.getApp(app);
			List<Credential> credentials = appInfo.getCredentials();
			for (Credential credential : credentials) {
				List<DeveloperAppApiProduct> developerApiProducts = credential.getApiProducts();
				for (DeveloperAppApiProduct apiProduct : developerApiProducts) {

					for (String product : apiProducts) {
						if (apiProduct.getApiproduct().equalsIgnoreCase(product)) {

							List<String> productApps = apps.get(product);
							if (productApps == null) {
								productApps = new ArrayList<String>();
							}
							productApps.add(appInfo.getName());
							apps.put(product, productApps);
						}
					}
				}
			}

		}
		System.out.println(apps);

	}
}
