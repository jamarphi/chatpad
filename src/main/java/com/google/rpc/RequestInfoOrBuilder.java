package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RequestInfoOrBuilder extends MessageLiteOrBuilder {
  String getRequestId();
  
  ByteString getRequestIdBytes();
  
  String getServingData();
  
  ByteString getServingDataBytes();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\RequestInfoOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */