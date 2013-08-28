package com.apigee.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.apigee.model.DeveloperAppApiProduct;
import com.util.ApiGeeUtil;

public class GetAppsForApiProduct {

	public static void main(String[] args) {

		final String organization = Org.STAPLES;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final List<String> apiProducts = Arrays.asList(new String[] { "Gold", "All Gold", "test_catalog_only", "Silver", "Catalog Browse Silver", "Experimental" });

		// final List<String> apiProducts =
		// Collections.singletonList("StaplesEasyOpenAPI");

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
