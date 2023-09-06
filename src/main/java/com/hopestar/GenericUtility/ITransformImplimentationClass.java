package com.hopestar.GenericUtility;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
// take this package as import -|
import org.testng.internal.annotations.IAnnotationTransformer;

public class ITransformImplimentationClass implements IAnnotationTransformer{

	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		
		annotation.setRetryAnalyzer(com.hopestar.GenericUtility.IRetryListenerImplementationClass.class);// in the parameter we have to pass the fully qualified path of IRetryListenerImplimentationclass path here
	}
	
	

}
