package test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
   
public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String s="Testando projeto next 2023";
	       MessageDigest m=MessageDigest.getInstance("MD5");
	       MessageDigest sha1=MessageDigest.getInstance("SHA1");
	       sha1.update(s.getBytes(),0,s.length());
	       m.update(s.getBytes(),0,s.length());
	       System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
	       System.out.println("SHA1: "+new BigInteger(1,sha1.digest()).toString(16));
	       
	       
	     

	}

}
