package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RollbackRequestOrBuilder extends MessageLiteOrBuilder {
  String getDatabase();
  
  ByteString getDatabaseBytes();
  
  ByteString getTransaction();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\RollbackRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */