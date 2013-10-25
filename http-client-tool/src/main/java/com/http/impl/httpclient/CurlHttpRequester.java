package com.http.impl.httpclient;

import java.util.Map;

import com.http.model.FormPayload;
import com.http.model.HttpRequest;
import com.http.model.HttpResponse;
import com.http.model.RequestParams;

public class CurlHttpRequester extends HttpRequester {

	CurlHttpRequester() {
		super(null);
	}

	public HttpResponse sendFormRequest(HttpRequest request, Map<String, String> pathParams, RequestParams queryParams, FormPayload payload) {
		getRequest(request, pathParams, queryParams, payload);

		return null;
	}
}
