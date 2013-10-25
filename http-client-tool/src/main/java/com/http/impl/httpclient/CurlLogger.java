package com.http.impl.httpclient;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.http.model.FormPayload;
import com.http.model.FormRequest;
import com.http.model.HttpMethod;
import com.http.model.HttpRequest;
import com.http.model.HttpResponse;
import com.http.model.PathParamsUtil;
import com.http.model.PayloadType;
import com.http.model.RawPayload;

public final class CurlLogger {

	private static final String AUTHORIZATION_HEADER = "Authorization";

	private static final Log logger = LogFactory.getLog(CurlLogger.class);

	private CurlLogger() {
	}

	public static <T extends HttpRequest> void logRequest(T request, String completePath, Map<String, String> pathParams) {
		String curlPath = PathParamsUtil.replacePathParameters(completePath, pathParams);

		String curlAuthorization = getCurlAuthorization(request.getHeaders());
		String curlHeaders = getAuthorizationHeaders(request.getHeaders());

		String curl = String.format("curl -k -v -X %s \"%s\"%s%s", request.getMethod(), curlPath, curlHeaders, curlAuthorization);

		// TODO Agregar otros tipos de payload

		if (request.getMethod() == HttpMethod.POST || request.getMethod() == HttpMethod.PUT) {
			FormRequest formRequest = (FormRequest) request;

			FormPayload formPayload = formRequest.getPayload();
			if (formPayload != null && formPayload.getPayloadType() == PayloadType.RAW) {

				RawPayload payload = (RawPayload) formRequest.getPayload();
				String rawPayload = payload.getRawPayload();

				curl += String.format(" -d \"%s\"", rawPayload.replaceAll("\"", "\\\\\""));
			}
		}

		logger.info(curl);
	}

	private static String getAuthorizationHeaders(Map<String, String> headers) {
		String curlHeaders = "";

		for (Entry<String, String> header : headers.entrySet()) {
			if (!header.getKey().equals(AUTHORIZATION_HEADER) || header.getValue().equals("")) {
				curlHeaders += "-H \"" + header.getKey() + ": " + header.getValue() + "\" ";
			}
		}
		if (!curlHeaders.equals("")) {
			curlHeaders = curlHeaders.substring(0, curlHeaders.length() - 1);
			curlHeaders = " " + curlHeaders;
		}

		return curlHeaders;
	}

	private static String getCurlAuthorization(Map<String, String> headers) {
		String curlAuthorization = "";

		if (headers.containsKey(AUTHORIZATION_HEADER)) {
			String authHeader = headers.get(AUTHORIZATION_HEADER);

			if (authHeader.startsWith("Basic ")) {
				String base64 = authHeader.replaceFirst("Basic ", "");
				byte[] bytesDecoded = Base64.decodeBase64(base64);
				try {
					String plain = new String(bytesDecoded, "UTF-8");
					curlAuthorization = "-u " + plain;

				} catch (UnsupportedEncodingException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		if (!curlAuthorization.equals("")) {
			curlAuthorization = " " + curlAuthorization;
		}
		return curlAuthorization;
	}

	public static void logResponse(HttpResponse response) {

		logger.info(String.format("Response: %s, Headers: %s", response.getStatus(), response.getHeaders()));
	}
}
