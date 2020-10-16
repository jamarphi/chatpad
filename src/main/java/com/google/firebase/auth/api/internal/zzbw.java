package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzdp;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzn;

final class zzbw extends zzes<Void, zza> {
  private final zzdp zza;
  
  public zzbw(EmailAuthCredential paramEmailAuthCredential) {
    super(2);
    Preconditions.checkNotNull(paramEmailAuthCredential, "Credential cannot be null");
    this.zza = new zzdp(paramEmailAuthCredential);
  }
  
  public final String zza() {
    return "reauthenticateWithEmailLink";
  }
  
  public final TaskApiCall<zzdt, Void> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzbv(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzbv(this)).build();
  }
  
  public final void zze() {
    zzn zzn = zzau.zza(this.zzd, this.zzl);
    if (this.zze.getUid().equalsIgnoreCase(zzn.getUid())) {
      this.zzf.zza(this.zzk, (FirebaseUser)zzn);
      zzb((ResultT)null);
      return;
    } 
    zza(new Status(17024));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzbw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */