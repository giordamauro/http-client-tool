package com.http.proxy.impl;

import java.lang.reflect.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.http.model.HttpResponse;
import com.http.proxy.ApiResultHandler;

public class ApiResultHandlerImpl implements ApiResultHandler {

	private final Log logger = LogFactory.getLog(this.getClass());

	private static final int HTTP_SUCCESS_CODE = 200;
	private static final int HTTP_REDIRECTION_CODE = 300;

	private static final String JSON_CONTENT_TYPE = "application/json";
	private static final String OCTET_STREAM_CONTENT_TYPE = "application/octet-stream";

	public ApiResultHandlerImpl() {
	}

	public Object getResponseResult(HttpResponse response, String produces, Type returnType) throws Exception {

		if (response == null || produces == null || returnType == null) {
			throw new IllegalArgumentException("Response, produces and returnType cannot be null");
		}

		if (isResponseSuccessful(response.getStatus())) {

			Object result = null;

			if (produces.equals(JSON_CONTENT_TYPE)) {

				String stringResponse = response.getStringContent();
				logger.info(String.format("Parsing json: '%s'", stringResponse));

				result = getFromJSon(returnType, stringResponse);
			} else if (produces.equals(OCTET_STREAM_CONTENT_TYPE)) {

				result = response.getInputStream();
			} else {
				result = response.getStringContent();
			}
			return result;
		} else {
			throw new IllegalStateException(String.format("Response not successful - Code: %s Body: '%s'", response.getStatus(), response.getStringContent()));
		}
	}

	private boolean isResponseSuccessful(int responseCode) {

		return responseCode >= HTTP_SUCCESS_CODE && responseCode < HTTP_REDIRECTION_CODE;
	}

	private <T> T getFromJSon(Type returnType, String body) {

		GsonBuilder gs = new GsonBuilder();
		gs.serializeNulls();
		gs.disableHtmlEscaping();
		gs.setLongSerializationPolicy(LongSerializationPolicy.STRING);

		Gson gson = gs.create();
		try {
			return gson.fromJson(body, returnType);
		} catch (Exception e) {

			throw new IllegalStateException(String.format("Couln't parse json '%s' to class '%s'", body, returnType), e);
		}
	}
}
