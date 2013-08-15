package com.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bundle.model.ApiProxy;
import com.bundle.model.ProxyEndpoint;
import com.bundle.model.TargetEndpoint;

public class BundleUtils {

	public static final String TEMP_BUNDLE_PATH = "." + File.separator + "temp";
	public static final String TEMP_PROXIES_PATH = TEMP_BUNDLE_PATH + File.separator + "apiproxy" + File.separator + "proxies" + File.separator;
	public static final String TEMP_TARGETS_PATH = TEMP_BUNDLE_PATH + File.separator + "apiproxy" + File.separator + "targets" + File.separator;

	public static TargetEndpoint getTargetEndpoint(String name) {
		File proxyEndpointFile = new File(TEMP_TARGETS_PATH + name);

		return unmarshalFileToClass(proxyEndpointFile, TargetEndpoint.class);

	}

	public static ProxyEndpoint getProxyEndpoint(String name) {
		File proxyEndpointFile = new File(TEMP_PROXIES_PATH + name);

		return unmarshalFileToClass(proxyEndpointFile, ProxyEndpoint.class);

	}

	public static ApiProxy getApiProxyInfo() {
		File infoXmlFile = getApiInfoXmlFile();

		return unmarshalFileToClass(infoXmlFile, ApiProxy.class);
	}

	public static File getApiInfoXmlFile() {
		File dir = new File(TEMP_BUNDLE_PATH + File.separator + "apiproxy");

		for (File child : dir.listFiles()) {
			if (child.getName().endsWith(".xml")) {
				return child;
			}
		}
		throw new IllegalStateException("ApiInfo xml file was not found");
	}

	private static <T> T unmarshalFileToClass(File file, Class<T> theClass) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(theClass);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			@SuppressWarnings("unchecked")
			T object = (T) jaxbUnmarshaller.unmarshal(file);

			return object;
		} catch (JAXBException e) {
			throw new IllegalStateException(e);
		}

	}

	public static void marshal(Object obj) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(obj, System.out);

		} catch (JAXBException e) {
			throw new IllegalStateException(e);
		}

	}
}
