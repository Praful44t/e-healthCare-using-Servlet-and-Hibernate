package com.montran.util;

import javax.crypto.Cipher ;
import javax.crypto.spec.SecretKeySpec;
import java.lang.Exception ;



public class PasswordEncrypt {
	
	public static void main(String[] args) throws Exception {
			String s1 = "123456";
		    String key = "1";
		    String s2 = encrypt(s1,key);
		    String s3 = decrypt(s2, key);
		    System.out.println(s1+"\n"+s2+"\n"+s3);
}

public static String encrypt(String strClearText,String strKey) throws Exception{
String strData="";

try {
	SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
	Cipher cipher=Cipher.getInstance("Blowfish");
	cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
	byte[] encrypted=cipher.doFinal(strClearText.getBytes());
	strData=new String(encrypted);
	
} catch (Exception e) {
	e.printStackTrace();
	throw new Exception(e);
}
return strData;
}
public static String decrypt(String strEncrypted,String strKey) throws Exception{
    String strData="";
    
    try {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
        strData=new String(decrypted);
        
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e);
    }
    return strData;
}
}