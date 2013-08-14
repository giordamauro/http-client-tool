package com.apigee.proxy;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetApiRevisionDeployments {

	public static void main(String[] args) {

		final String organization = Org.MARKSANDSPENCER;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String apiName = "search";
		final int revision = 41;

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String deployments = publicApi.getApiRevisionDeployments(apiName, revision);

		System.out.println(deployments);

	}
}
