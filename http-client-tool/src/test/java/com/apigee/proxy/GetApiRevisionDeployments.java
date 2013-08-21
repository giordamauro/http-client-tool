package com.apigee.proxy;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.util.ApiGeeUtil;

public class GetApiRevisionDeployments {

	public static void main(String[] args) {

		final String organization = "staples";
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String apiName = "StaplesEasyOpenAPI";
		final int revision = 25;

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String deployments = publicApi.getApiRevisionDeployments(apiName, revision);

		System.out.println(deployments);

	}
}
