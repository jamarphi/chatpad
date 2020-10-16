package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

final class TargetAction extends Action<Target> {
  TargetAction(Picasso paramPicasso, Target paramTarget, Request paramRequest, int paramInt1, int paramInt2, Drawable paramDrawable, String paramString, Object paramObject, int paramInt3) {
    super(paramPicasso, paramTarget, paramRequest, paramInt1, paramInt2, paramInt3, paramDrawable, paramString, paramObject, false);
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {
    if (paramBitmap != null) {
      Target target = getTarget();
      if (target != null) {
        target.onBitmapLoaded(paramBitmap, paramLoadedFrom);
        if (paramBitmap.isRecycled())
          throw new IllegalStateException("Target callback must not recycle bitmap!"); 
      } 
      return;
    } 
    throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
  }
  
  void error(Exception paramException) {
    Target target = getTarget();
    if (target != null)
      if (this.errorResId != 0) {
        target.onBitmapFailed(paramException, this.picasso.context.getResources().getDrawable(this.errorResId));
      } else {
        target.onBitmapFailed(paramException, this.errorDrawable);
      }  
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\TargetAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */