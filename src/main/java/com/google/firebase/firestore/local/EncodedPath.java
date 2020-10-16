package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class EncodedPath {
  private static final char ENCODED_ESCAPE = '\021';
  
  private static final char ENCODED_NUL = '\020';
  
  private static final char ENCODED_SEPARATOR = '\001';
  
  private static final char ESCAPE = '\001';
  
  private static List<String> decode(String paramString) {
    boolean bool;
    int i = paramString.length();
    if (i >= 2) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Invalid path \"%s\"", new Object[] { paramString });
    if (i == 2) {
      if (paramString.charAt(0) == '\001' && paramString.charAt(1) == '\001') {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Non-empty path \"%s\" had length 2", new Object[] { paramString });
      return Collections.emptyList();
    } 
    int j = paramString.length();
    ArrayList<String> arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    int k = 0;
    while (k < i) {
      int m = paramString.indexOf('\001', k);
      if (m >= 0 && m <= j - 2) {
        int n = m + 1;
        char c = paramString.charAt(n);
        if (c != '\001') {
          if (c != '\020') {
            if (c == '\021') {
              stringBuilder.append(paramString.substring(k, n));
            } else {
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Invalid encoded resource path: \"");
              stringBuilder2.append(paramString);
              stringBuilder2.append("\"");
              throw new IllegalArgumentException(stringBuilder2.toString());
            } 
          } else {
            stringBuilder.append(paramString.substring(k, m));
            stringBuilder.append(false);
          } 
        } else {
          String str = paramString.substring(k, m);
          if (stringBuilder.length() != 0) {
            stringBuilder.append(str);
            str = stringBuilder.toString();
            stringBuilder.setLength(0);
          } 
          arrayList.add(str);
        } 
        k = m + 2;
        continue;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid encoded resource path: \"");
      stringBuilder1.append(paramString);
      stringBuilder1.append("\"");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    return arrayList;
  }
  
  static FieldPath decodeFieldPath(String paramString) {
    return FieldPath.fromSegments(decode(paramString));
  }
  
  static ResourcePath decodeResourcePath(String paramString) {
    return ResourcePath.fromSegments(decode(paramString));
  }
  
  static <B extends com.google.firebase.firestore.model.BasePath<B>> String encode(B paramB) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramB.length();
    for (byte b = 0; b < i; b++) {
      if (stringBuilder.length() > 0)
        encodeSeparator(stringBuilder); 
      encodeSegment(paramB.getSegment(b), stringBuilder);
    } 
    encodeSeparator(stringBuilder);
    return stringBuilder.toString();
  }
  
  private static void encodeSegment(String paramString, StringBuilder paramStringBuilder) {
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      char c = paramString.charAt(b);
      if (c != '\000') {
        if (c != '\001') {
          paramStringBuilder.append(c);
        } else {
          paramStringBuilder.append('\001');
          paramStringBuilder.append('\021');
        } 
      } else {
        paramStringBuilder.append('\001');
        paramStringBuilder.append('\020');
      } 
    } 
  }
  
  private static void encodeSeparator(StringBuilder paramStringBuilder) {
    paramStringBuilder.append('\001');
    paramStringBuilder.append('\001');
  }
  
  static String prefixSuccessor(String paramString) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder(paramString);
    int i = stringBuilder.length() - 1;
    char c = stringBuilder.charAt(i);
    if (c == '\001') {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "successor may only operate on paths generated by encode", new Object[0]);
    stringBuilder.setCharAt(i, (char)(c + 1));
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\EncodedPath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */