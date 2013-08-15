package com.xml;

import com.bundle.model.Bundle;

public class BundleTest {

	public static void main(String[] args) {
		Bundle bundle = Bundle.loadFromZip("api-proxy.zip");

		System.out.println(bundle.getApiProxy().getDisplayName());
	}

}
