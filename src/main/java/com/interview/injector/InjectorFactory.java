package com.interview.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorFactory {

	private final static Injector INJECTOR = Guice.createInjector();
	
	public static Injector getInjector() {
		return INJECTOR;
	}
	
}
