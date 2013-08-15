package com.apigee.proxy;

import java.io.InputStream;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.model.ApiRevision;
import com.util.ApiGeeUtil;
import com.util.FileUtils;

public class DownloadBundleScript {

	public static void main(String[] args) {

		final String organization = "mgiorda";
		final String username = "mgiorda@devspark.com";
		final String password = "1234321Nomejodas";
		final String apiName = "cvs-proxy";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		ApiRevision api = publicApi.getApiRevisions(apiName);

		List<Integer> revisions = api.getRevision();
		int lastRev = revisions.get(revisions.size() - 1);

		System.out.println(lastRev);

		InputStream bundle = publicApi.getApiBundle(apiName, lastRev, ApiGeeUtil.BUNDLE_FORMAT);

		FileUtils.streamToFile(bundle, apiName + ".zip");

	}

}
