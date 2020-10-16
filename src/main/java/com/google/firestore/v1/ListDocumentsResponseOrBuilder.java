package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ListDocumentsResponseOrBuilder extends MessageLiteOrBuilder {
  Document getDocuments(int paramInt);
  
  int getDocumentsCount();
  
  List<Document> getDocumentsList();
  
  String getNextPageToken();
  
  ByteString getNextPageTokenBytes();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListDocumentsResponseOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */