package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.firebase_auth.zzdh;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

final class zzcq extends zzes<AuthResult, zza> {
  private final zzdh zza;
  
  public zzcq(String paramString) {
    super(2);
    this.zza = new zzdh(paramString);
  }
  
  public final String zza() {
    return "signInAnonymously";
  }
  
  public final TaskApiCall<zzdt, AuthResult> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzcp(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzcp(this)).build();
  }
  
  public final void zze() {
    zzn zzn = zzau.zza(this.zzd, this.zzl);
    this.zzf.zza(this.zzk, (FirebaseUser)zzn);
    zzb((ResultT)new zzh(zzn));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzcq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */