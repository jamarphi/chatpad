package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
  abstract JsonElement deepCopy();
  
  public BigDecimal getAsBigDecimal() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public BigInteger getAsBigInteger() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean getAsBoolean() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  Boolean getAsBooleanWrapper() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public byte getAsByte() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public char getAsCharacter() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double getAsDouble() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public float getAsFloat() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int getAsInt() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public JsonArray getAsJsonArray() {
    if (isJsonArray())
      return (JsonArray)this; 
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public JsonNull getAsJsonNull() {
    if (isJsonNull())
      return (JsonNull)this; 
    throw new IllegalStateException("This is not a JSON Null.");
  }
  
  public JsonObject getAsJsonObject() {
    if (isJsonObject())
      return (JsonObject)this; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Not a JSON Object: ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public JsonPrimitive getAsJsonPrimitive() {
    if (isJsonPrimitive())
      return (JsonPrimitive)this; 
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  public long getAsLong() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public Number getAsNumber() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public short getAsShort() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String getAsString() {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean isJsonArray() {
    return this instanceof JsonArray;
  }
  
  public boolean isJsonNull() {
    return this instanceof JsonNull;
  }
  
  public boolean isJsonObject() {
    return this instanceof JsonObject;
  }
  
  public boolean isJsonPrimitive() {
    return this instanceof JsonPrimitive;
  }
  
  public String toString() {
    try {
      StringWriter stringWriter = new StringWriter();
      this();
      JsonWriter jsonWriter = new JsonWriter();
      this(stringWriter);
      jsonWriter.setLenient(true);
      Streams.write(this, jsonWriter);
      return stringWriter.toString();
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\gson\JsonElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */