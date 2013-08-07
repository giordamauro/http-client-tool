package com.apigee.proxy;

import com.apigee.ApigeeAPI;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class GetAppConEspacio {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		DeveloperApp app = publicApi.getDeveloperApp(username, "App-con-espacio");
		System.out.println(app);

	}

}
