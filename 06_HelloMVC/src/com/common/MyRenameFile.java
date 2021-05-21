package com.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//나만의 리네임 규칙 적용 하기
public class MyRenameFile implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		//중복되지 않는 파일명을 만들어보자
		File newFile=null;// 반환할 파일
		
		do {
			long currentTime=System.currentTimeMillis();//현재시간을 밀리세컨초로 받아옴
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd=(int)(Math.random()*1320);
			String oriName=oldFile.getName();//업로드된 파일명->원 이름을 가져오는 이유는
			//확장자 때문에->.txt/.png/.java
			int dot=oriName.lastIndexOf(".");
			String ext="";
			if(dot!=-1) {
				ext=oriName.substring(dot);
			}
			
			//새이름 설정하기
			String newName=sdf.format(new Date(currentTime))+"_"+rnd+ext;
			
			newFile=new File(oldFile.getParent(),newName);
		}while(!createNewFile(newFile));
		return newFile;
		
	}
	
	private boolean createNewFile(File newFile) {
		try {
			return newFile.createNewFile();//파일생성하기
		}catch(IOException e) {
			return false;
		}
	}
	
	
	
}
