package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface WriteOrBuilder extends MessageLiteOrBuilder {
  Precondition getCurrentDocument();
  
  String getDelete();
  
  ByteString getDeleteBytes();
  
  Write.OperationCase getOperationCase();
  
  DocumentTransform getTransform();
  
  Document getUpdate();
  
  DocumentMask getUpdateMask();
  
  boolean hasCurrentDocument();
  
  boolean hasUpdateMask();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */