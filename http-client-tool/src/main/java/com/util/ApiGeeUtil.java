package com.util;

import com.apigee.ApigeeAPI;
import com.apigee.PublicApiPaths;
import com.http.impl.httpclient.BasicAuthHttpFactory;
import com.http.model.HttpFactory;
import com.http.proxy.ApiMetadataHandler;
import com.http.proxy.ApiMethodHandler;
import com.http.proxy.ApiProxyFactory;
import com.http.proxy.ApiResultHandler;
import com.http.proxy.impl.ApiMetadataHandlerImpl;
import com.http.proxy.impl.ApiMethodHandlerImpl;
import com.http.proxy.impl.ApiResultHandlerImpl;

public final class ApiGeeUtil {

	public static final String BUNDLE_FORMAT = "bundle";

	private static final ApiMetadataHandler metadataHandler = new ApiMetadataHandlerImpl();

	private static final ApiResultHandler resultHandler = new ApiResultHandlerImpl();

	public static ApigeeAPI getPublicApi(String organization, String username, String password) {

		HttpFactory httpFactory = new BasicAuthHttpFactory(PublicApiPaths.API_GEE_HOST, username, password);
		httpFactory.setPathParam("organization", organization);

		ApiMethodHandler apiHandler = new ApiMethodHandlerImpl(metadataHandler, httpFactory, resultHandler);
		ApiProxyFactory proxyFactory = new ApiProxyFactory(apiHandler);

		ApigeeAPI publicApi = proxyFactory.getProxy(ApigeeAPI.class);

		return publicApi;
	}

	private ApiGeeUtil() {
	}

}
