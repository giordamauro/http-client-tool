package com.http.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiProxyFactory {

	private final InvocationHandler invocationHandler;

	public ApiProxyFactory(final ApiMethodHandler apiHandler) {

		if (apiHandler == null) {

			throw new IllegalArgumentException("Api handler cannot be null");
		}

		this.invocationHandler = new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Exception {

				return apiHandler.handleMethodCall(method, args);
			}
		};
	}

	public <T> T getProxy(Class<T> interfaceClass) {

		ClassLoader classLoader = interfaceClass.getClassLoader();

		Class<?>[] implClass = new Class<?>[] { interfaceClass };

		@SuppressWarnings("unchecked")
		T proxy = (T) Proxy.newProxyInstance(classLoader, implClass, invocationHandler);

		return proxy;
	}
}