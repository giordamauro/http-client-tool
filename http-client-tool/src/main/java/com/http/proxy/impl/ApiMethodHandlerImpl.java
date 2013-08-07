package com.http.proxy.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.http.model.HttpFactory;
import com.http.model.HttpMethod;
import com.http.model.HttpRequest;
import com.http.model.HttpResponse;
import com.http.model.QueryRequest;
import com.http.model.RequestParams;
import com.http.proxy.ApiMetadataHandler;
import com.http.proxy.ApiMethodHandler;
import com.http.proxy.ApiResultHandler;
import com.http.proxy.BaseServiceMetadata;

public class ApiMethodHandlerImpl implements ApiMethodHandler {

	private Log logger = LogFactory.getLog(getClass());

	private final ApiMetadataHandler metadataHandler;

	private final HttpFactory requestFactory;

	private final ApiResultHandler resultHandler;

	public ApiMethodHandlerImpl(ApiMetadataHandler metadataHandler, HttpFactory requestFactory, ApiResultHandler errorHandler) {

		if (metadataHandler == null || requestFactory == null || errorHandler == null) {

			throw new IllegalArgumentException("MetadataHandler, requestFactory and resultHandler cannot be null");
		}
		this.metadataHandler = metadataHandler;
		this.resultHandler = errorHandler;
		this.requestFactory = requestFactory;
	}

	public Object handleMethodCall(Method method, Object[] args) throws Exception {

		if (!method.getDeclaringClass().equals(Object.class)) {

			logger.info(String.format("Invoking service method: '%s.%s(%s)'", method.getDeclaringClass().getSimpleName(), method.getName(), getMethodTypesLog(method.getParameterTypes())));

			BaseServiceMetadata metadata = metadataHandler.getBaseServiceMetadata(method);
			Map<String, String> pathParams = metadataHandler.getPathParams(method, args);

			HttpRequest request = requestFactory.newRequest(metadata.getMethod(), metadata.getUrl());
			request.setPathParams(pathParams);

			HttpResponse response = null;

			if (metadata.getMethod() != HttpMethod.OPTIONS) {
				RequestParams queryParams = metadataHandler.getQueryParams(method, args);
				QueryRequest queryRequest = (QueryRequest) request;
				queryRequest.addQueryParams(queryParams);
			}

			response = request.send();

			// TODO incorporar Payload!

			String produces = metadata.getProduces();
			Type returnType = metadata.getResultType();

			return resultHandler.getResponseResult(response, produces, returnType);
		} else {
			return method.invoke(this, args);
		}
	}

	private String getMethodTypesLog(Class<?>[] parameterTypes) {

		String types = "";

		for (Class<?> parameterClass : parameterTypes) {

			types += parameterClass.getSimpleName() + ", ";
		}
		if (parameterTypes.length > 0) {
			types = types.substring(0, types.length() - 2);
		}
		return types;
	}
}
