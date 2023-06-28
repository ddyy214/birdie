package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	//첨부파일 구현으로 인한 선언
	MultipartRequest multi = null;
	//첨부 파일 업로드되는 물리적인 이름
	String realFolder = null;
	//첨부파일의 한글 처리
	String encType = "utf-8";
	//첨부파일의  최대 크기
	int maxSize = 5*1024*1024;//5MB제한
	public HashMapBinder() {}//디폴트 생성자
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
		this.realFolder = "D:\\workspace_jsp\\basic0512\\src\\main\\webapp\\pds" ;
	}
	//첨부파일이 있을 때 사용자가 입력한 값 청취하기 - 읽어오기 -  pMap에 담아주기
	public void multiBind(Map<String,Object> pMap) {
		logger.info("multiBind");
		pMap.clear();//기존에 값을 가진 건 비워주기
		try {
			//생성자를 호출하는 것 만으로 파일 업로드 처리는 완성
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		//encType이면 표준요청객체로 사용자가 입력한 값을 읽을 수 없음.
		//첨부파일의 파일 이름을 얻어오기 - pds폴더에 사용자가 선택한 파일을 업로드 해주기 위해서 사용자가 입력한 값을 읽어오는 코드
		Enumeration<String> em = multi.getParameterNames();// s가 붙어 복수형임 컴포넌트이름 여러개를 한 번에 읽어온다
		while(em.hasMoreElements()) {
			String key = em.nextElement();
			pMap.put(key, multi.getParameter(key));//Map에 사용자가 입력한 값 담김 -  파일은 제외됨
		}//end of while
		Enumeration<String> files = multi.getFileNames();//첨부파일이 여러개 일때도 받아줌
		// 첨부파일이 있는거야?
		if(files !=null) {
			//File객체는 파일명을 객체로 만들어주는 클래스임 - 그러나 파일에 내용까지 담고 있지는 않음
			File file = null;
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				String filename = multi.getFilesystemName(fname);
				pMap.put("b_file", filename);
				if(filename !=null &&  filename.length()>1) {
					file = new File(realFolder+"\\"+filename);
				}//end of if
			}//// end of while
			//75번라인에서 파일객체가 생성완료됨 - 파일크기를 계산가능함 XXX.zip(5.2MB)
			//첨부파일에 크기를 담을 수 있는 처리 추가
			double size= 0;
			if(file!=null) {
				size = file.length();//파일크기 바이트
				size=size/1024.0;
				pMap.put("b_size", size);
			}
		}
	}
		public void bind(Map<String,Object> pMap) {
		pMap.clear();
		Enumeration<String> en = req.getParameterNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			logger.info(req.getParameter(key));// 한글깨짐 출력한 코드
			pMap.put(key, HangulConversion.toUTF(req.getParameter(key)));//한글처리끝 - POST방식
		}
	}
}
