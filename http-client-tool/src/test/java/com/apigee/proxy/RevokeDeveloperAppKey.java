package com.apigee.proxy;

import com.apigee.ApigeeAPI;
import com.util.ApiGeeUtil;

public class RevokeDeveloperAppKey {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";

		final String appName = "NewBrokenApp";
		final String apiKey = "NL17oxnaPYcu4LaW5DmLuyuhEzRkMKvA";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.editDeveloperAppKey(username, appName, apiKey, "revoke");
	}
}
