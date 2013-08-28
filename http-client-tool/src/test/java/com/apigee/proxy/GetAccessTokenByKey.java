package com.apigee.proxy;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.AccessToken;
import com.util.ApiGeeUtil;

public class GetAccessTokenByKey {

	public static void main(String[] args) {

		final String organization = Org.OANDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String accessToken = "ZkKAkbgAztZ93xS4kuDMryVPaVKU";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		AccessToken info = publicApi.getAccessToken(accessToken);

		System.out.println(info.getStatus());
	}
}