package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T> {
  private final String methodName;
  
  private final Class[] methodParams;
  
  private final Class<?> returnType;
  
  public OptionalMethod(Class<?> paramClass, String paramString, Class... paramVarArgs) {
    this.returnType = paramClass;
    this.methodName = paramString;
    this.methodParams = paramVarArgs;
  }
  
  private Method getMethod(Class<?> paramClass) {
    String str = this.methodName;
    Method method1 = null;
    Method method2 = method1;
    if (str != null) {
      method2 = getPublicMethod(paramClass, str, this.methodParams);
      if (method2 != null) {
        paramClass = this.returnType;
        if (paramClass != null && !paramClass.isAssignableFrom(method2.getReturnType()))
          method2 = method1; 
      } 
    } 
    return method2;
  }
  
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass) {
    try {
      Method method = paramClass.getMethod(paramString, paramArrayOfClass);
      try {
        int i = method.getModifiers();
        if ((i & 0x1) == 0)
          return null; 
      } catch (NoSuchMethodException noSuchMethodException) {}
    } catch (NoSuchMethodException noSuchMethodException) {}
    return null;
  }
  
  public Object invoke(T paramT, Object... paramVarArgs) throws InvocationTargetException {
    Method method = getMethod(paramT.getClass());
    if (method != null)
      try {
        return method.invoke(paramT, paramVarArgs);
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpectedly could not call: ");
        stringBuilder1.append(method);
        AssertionError assertionError = new AssertionError(stringBuilder1.toString());
        assertionError.initCause(illegalAccessException);
        throw assertionError;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Method ");
    stringBuilder.append(this.methodName);
    stringBuilder.append(" not supported for object ");
    stringBuilder.append(illegalAccessException);
    throw new AssertionError(stringBuilder.toString());
  }
  
  public Object invokeOptional(T paramT, Object... paramVarArgs) throws InvocationTargetException {
    Method method = getMethod(paramT.getClass());
    if (method == null)
      return null; 
    try {
      return method.invoke(paramT, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      return null;
    } 
  }
  
  public Object invokeOptionalWithoutCheckedException(T paramT, Object... paramVarArgs) {
    try {
      return invokeOptional(paramT, paramVarArgs);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getTargetException();
      if (throwable instanceof RuntimeException)
        throw (RuntimeException)throwable; 
      AssertionError assertionError = new AssertionError("Unexpected exception");
      assertionError.initCause(throwable);
      throw assertionError;
    } 
  }
  
  public Object invokeWithoutCheckedException(T paramT, Object... paramVarArgs) {
    try {
      return invoke(paramT, paramVarArgs);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getTargetException();
      if (throwable instanceof RuntimeException)
        throw (RuntimeException)throwable; 
      AssertionError assertionError = new AssertionError("Unexpected exception");
      assertionError.initCause(throwable);
      throw assertionError;
    } 
  }
  
  public boolean isSupported(T paramT) {
    boolean bool;
    if (getMethod(paramT.getClass()) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\OptionalMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */