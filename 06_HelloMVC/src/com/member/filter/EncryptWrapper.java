package com.member.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		
	}

	@Override
	public String getParameter(String name) {
		String value;
		
		if(name.equals("password")) {
			//password name은 암호화해서
			System.out.println("암호화전: "+super.getParameter(name));
			
			value=getSHA512(super.getParameter(name));
			
			System.out.println("암호화후: "+value);
		}else {
			value=super.getParameter(name);
		}
		
		return value;
	}
	
	private String getSHA512(String val) {
		String encValue;
		//SHA512방식의 암호화를 적용
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//암호화를 할떄는 bit
		byte[] bytes=val.getBytes(Charset.forName("utf-8"));
		md.update(bytes);
		//문자열로 반환하기 위해서 Encoder 사용
		//Base64Encoder사용
		encValue=Base64.getEncoder().encodeToString(md.digest());
		return encValue;
	}
	
}
