package com.http.tests;

import java.util.List;

import com.apigee.PublicApiPaths;
import com.google.gson.JsonObject;
import com.http.impl.httpclient.BasicAuthHttpFactory;
import com.http.model.HttpFactory;
import com.http.model.HttpMethod;
import com.http.model.HttpRequest;
import com.http.model.HttpResponse;
import com.jayway.jsonpath.JsonPath;
import com.util.JsonUtil;

public class GetDeveloperAppsTest {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";

		HttpFactory httpFactory = new BasicAuthHttpFactory(PublicApiPaths.API_GEE_HOST, username, password);
		httpFactory.setPathParam("organization", organization);

		HttpRequest devsRequest = httpFactory.newRequest(HttpMethod.GET, PublicApiPaths.DEVELOPERS_PATH);
		HttpResponse devsResponse = devsRequest.send();

		List<String> developers = JsonUtil.getJsonAsList(devsResponse);

		System.out.println(developers);

		for (String developer : developers) {

			HttpRequest appsRequest = httpFactory.newRequest(HttpMethod.GET, PublicApiPaths.DEVELOPER_APPS_PATH);
			appsRequest.setPathParam("developer", developer);
			HttpResponse appsResponse = appsRequest.send();

			List<String> apps = JsonUtil.getJsonAsList(appsResponse);

			System.out.println(apps);

			for (String app : apps) {
				HttpRequest appInfoRequest = httpFactory.newRequest(HttpMethod.GET, PublicApiPaths.DEVELOPER_APP_PATH);
				appInfoRequest.setPathParam("developer", developer);
				appInfoRequest.setPathParam("app", app);
				HttpResponse appInfoResponse = appInfoRequest.send();

				JsonObject appInfo = JsonUtil.getAsJsonObject(appInfoResponse);

				System.out.println(appInfo);

				// --- test

				String appInfoJson = appInfo.toString();

				List<String> result = JsonPath.read(appInfoJson, "$.attributes");

				System.out.println(result);
			}
		}
	}
}
