package utilities;

import java.security.MessageDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	
    public static String encrypt(String password){
        return md5(sha256(password));
    }
    
    private static String sha256(String password)
   {
       String generatedPassword = null;
       try {
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] bytes = md.digest(password.getBytes());
           StringBuilder sb = new StringBuilder();
           for(int i=0; i< bytes.length ;i++)
           {
               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
           }
           generatedPassword = sb.toString();
       }
       catch (NoSuchAlgorithmException e)
       {
           e.printStackTrace();
       }
       return generatedPassword;
   }
    
    private static String md5(String password)
   {
       String generatedPassword = null;
       try {
           
           MessageDigest md = MessageDigest.getInstance("MD5");
           byte[] bytes = md.digest(password.getBytes());
           StringBuilder sb = new StringBuilder();
           for(int i=0; i< bytes.length ;i++)
           {
               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
           }
           generatedPassword = sb.toString();
       }
       catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
       return generatedPassword;
   }
    
    
    
    //source: http://stackoverflow.com/questions/3103652/hash-string-via-sha-256-in-java
	//source: https://www.mkyong.com/java/java-sha-hashing-example/
	//source: https://www.mkyong.com/java/java-md5-hashing-example/
}