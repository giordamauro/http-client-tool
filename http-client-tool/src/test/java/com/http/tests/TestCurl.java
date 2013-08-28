package com.http.tests;

import com.util.Curl;

public class TestCurl {

	public static void main(String[] args) throws Exception {

		Curl.get("https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test").setUser("mgiorda@apigee.com", "1234321Nomejodas").send();

	}

}
