package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {
  static void calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, Request paramRequest) {
    if (paramInt4 > paramInt2 || paramInt3 > paramInt1) {
      double d;
      if (paramInt2 == 0) {
        d = Math.floor((paramInt3 / paramInt1));
      } else if (paramInt1 == 0) {
        d = Math.floor((paramInt4 / paramInt2));
      } else {
        paramInt2 = (int)Math.floor((paramInt4 / paramInt2));
        paramInt1 = (int)Math.floor((paramInt3 / paramInt1));
        if (paramRequest.centerInside) {
          paramInt1 = Math.max(paramInt2, paramInt1);
        } else {
          paramInt1 = Math.min(paramInt2, paramInt1);
        } 
        paramOptions.inSampleSize = paramInt1;
        paramOptions.inJustDecodeBounds = false;
      } 
      paramInt1 = (int)d;
    } else {
      paramInt1 = 1;
    } 
    paramOptions.inSampleSize = paramInt1;
    paramOptions.inJustDecodeBounds = false;
  }
  
  static void calculateInSampleSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, Request paramRequest) {
    calculateInSampleSize(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions, paramRequest);
  }
  
  static BitmapFactory.Options createBitmapOptions(Request paramRequest) {
    boolean bool1;
    boolean bool = paramRequest.hasSize();
    if (paramRequest.config != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    BitmapFactory.Options options = null;
    if (bool || bool1 || paramRequest.purgeable) {
      BitmapFactory.Options options1 = new BitmapFactory.Options();
      options1.inJustDecodeBounds = bool;
      options1.inInputShareable = paramRequest.purgeable;
      options1.inPurgeable = paramRequest.purgeable;
      options = options1;
      if (bool1) {
        options1.inPreferredConfig = paramRequest.config;
        options = options1;
      } 
    } 
    return options;
  }
  
  static boolean requiresInSampleSize(BitmapFactory.Options paramOptions) {
    boolean bool;
    if (paramOptions != null && paramOptions.inJustDecodeBounds) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public abstract boolean canHandleRequest(Request paramRequest);
  
  int getRetryCount() {
    return 0;
  }
  
  public abstract Result load(Request paramRequest, int paramInt) throws IOException;
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo) {
    return false;
  }
  
  boolean supportsReplay() {
    return false;
  }
  
  public static final class Result {
    private final Bitmap bitmap;
    
    private final int exifOrientation;
    
    private final Picasso.LoadedFrom loadedFrom;
    
    private final Source source;
    
    public Result(Bitmap param1Bitmap, Picasso.LoadedFrom param1LoadedFrom) {
      this(Utils.<Bitmap>checkNotNull(param1Bitmap, "bitmap == null"), null, param1LoadedFrom, 0);
    }
    
    Result(Bitmap param1Bitmap, Source param1Source, Picasso.LoadedFrom param1LoadedFrom, int param1Int) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Bitmap != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (param1Source == null)
        bool1 = false; 
      if (bool2 != bool1) {
        this.bitmap = param1Bitmap;
        this.source = param1Source;
        this.loadedFrom = Utils.<Picasso.LoadedFrom>checkNotNull(param1LoadedFrom, "loadedFrom == null");
        this.exifOrientation = param1Int;
        return;
      } 
      throw new AssertionError();
    }
    
    public Result(Source param1Source, Picasso.LoadedFrom param1LoadedFrom) {
      this(null, Utils.<Source>checkNotNull(param1Source, "source == null"), param1LoadedFrom, 0);
    }
    
    public Bitmap getBitmap() {
      return this.bitmap;
    }
    
    int getExifOrientation() {
      return this.exifOrientation;
    }
    
    public Picasso.LoadedFrom getLoadedFrom() {
      return this.loadedFrom;
    }
    
    public Source getSource() {
      return this.source;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\RequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */