package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface MoneyOrBuilder extends MessageLiteOrBuilder {
  String getCurrencyCode();
  
  ByteString getCurrencyCodeBytes();
  
  int getNanos();
  
  long getUnits();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\MoneyOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */