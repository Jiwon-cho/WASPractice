package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

//양방향 암호화 처리
//java.security패키지, java.crypto패키지에서 제공을 함.
public class AESEncrypt {
	//양방향 암호화 처리하는 클래스
	//1.key값을 생성
	// 영원히 저장이 되어야함. 유일한 값으로 -> 파일로 관리
	//SecretKey 클래스 를  제공 -> 암호화를 위한 키
	
	private static SecretKey key; //키를 관리하는 객체
	private String path;//key가 파일로 저장할때 경로
	
	public AESEncrypt() {
		//1. key 파일이 있으면 key 파일에서 secretKey객체를 불러오고
		//2. key 파일이 없으면 secretkey객체를 생성해서 파일로 저장
		
		//파일 경로를 지정
		this.path=AESEncrypt.class.getResource("/").getPath();
		//...WEB-INF/classes/
		this.path=this.path.substring(0,this.path.indexOf("classes"));
		
		File f=new File(this.path+"/gwon.gw");
		
		//파일이 있는지 없는지 확인
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				key=(SecretKey)ois.readObject();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			generateKey();
		}
	}
	
	private void generateKey() {
		//key 생성시 중복이 되면 안되기 때문에 중복되지 않기 위한 랜덤값을 출력함
		SecureRandom ser=new SecureRandom();
		//key 생성하는 클래스 생성/설정하기
		KeyGenerator keygen=null;
		try {
			keygen=KeyGenerator.getInstance("AES");
			//key생성에 대한 초기값을 설정
			keygen.init(128,ser);
			AESEncrypt.key=keygen.generateKey();
		}catch(Exception e) {
			e.printStackTrace();
		}
		File f=new File(this.path+"gwon.gw");
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(AESEncrypt.key); //static 이라 이렇게 접근
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//암호화 처리 메소드 만들기
	public static String encrypt(String value) throws NoSuchAlgorithmException,
	NoSuchPaddingException,InvalidKeyException,IllegalBlockSizeException,BadPaddingException{
		//암호화 , 복호화 처리를 해주는 클래스를 이용
		Cipher cipher=Cipher.getInstance("AES");
		//암호화
		cipher.init(Cipher.ENCRYPT_MODE, AESEncrypt.key);
		
		byte[] nativeVal=value.getBytes(Charset.forName("utf-8"));
		byte[] encResult=cipher.doFinal(nativeVal);
		
		return Base64.getEncoder().encodeToString(encResult);
	}
	
	//복호화 매소드 작성
	public static String decrypt(String value) throws NoSuchAlgorithmException,
	NoSuchPaddingException,InvalidKeyException,IllegalBlockSizeException,BadPaddingException{
		//암호화 , 복호화 처리를 해주는 클래스를 이용
		Cipher cipher=Cipher.getInstance("AES");
		//복호화
		cipher.init(Cipher.DECRYPT_MODE, AESEncrypt.key);
		
		//Base64Encoder로 인코딩한 값을 decoding
		byte[] decodeStr=Base64.getDecoder().decode(value.getBytes(Charset.forName("utf-8")));
		byte[] decResult=cipher.doFinal(decodeStr);

		
		return new String(decResult);
	}
}
