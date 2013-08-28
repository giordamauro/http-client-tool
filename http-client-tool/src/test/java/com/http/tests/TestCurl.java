package com.http.tests;

import com.util.CmdUtils;
import com.util.Curl;

public class TestCurl {

	public static void main(String[] args) throws Exception {

		// Two alternatives to do the same call:

		Curl.get("https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test").setUser("mgiorda@apigee.com", "1234321Nomejodas").send();

		CmdUtils.execCommand("curl -k -v https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test -u mgiorda@apigee.com:1234321Nomejodas");
	}

}
