package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException extends Exception {
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(String paramString) {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"));
  }
  
  public FirebaseException(String paramString, Throwable paramThrowable) {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"), paramThrowable);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\FirebaseException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */