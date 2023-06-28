package com.util;

import org.apache.log4j.Logger;

public class BSPageBar {
	Logger logger = Logger.getLogger(BSPageBar.class);
	//전체레코드 갯수
	private int totalRecord;//list.size()
	//페이지당 레코드 수
	private int numPerPage;// 10개씩이다
	//블럭당 디폴트 페이지 수 - 여기서는 일단 2개로 정함.
	private int pagePerBlock=2;
	//총페이지 수
	private int totalPage;
	//총블럭 수
	private int totalBlock;
	//현재 내가 바라보는 페이지 수
	private int nowPage;
	//현재 내가 바라보는 블럭 수
	private int nowBlock;
	//적용할 페이지 이름
	private String pagePath;
	//페이지 번호를 출력하는 태그들을 문자열로 담아주는 변수임
	private String pagination;
	//디폴트 생성자 선언해보기 - 생략 가능함
	public BSPageBar() {}
	//페이지 네비게이션 초기화
	/*
	 * 화면에서 받아와야 하는 정보에는 어떤 것들이 있을까?
	 * 페이지에 뿌려질 로우의 수 numberPerPage
	 * 전체 레코드 수 totalRecord
	 * 현재 내가 바라보는 페이지 번호 nowPage
	 * 내가 처리해야할 페이지 이름 pagePath
	 */
	/*******************************************************************************************************
	 * 파라미터에 있는 변수들은 모두 전변으로 선언되어 있다.
	 * 생성자를 갖는다는 건 전변을 초기화 해주는 역할
	 * @param numPerPage - 한 페이지에 몇 개씩 보여줄거야? - 10개 혹은 3개 혹은  5개
	 * @param totalRecord - List.size();// 로우의 수이다
	 * @param nowPage - 현재 내가 바라보는 페이지
	 * @param pagePath - 어떤 페이지에서 이 공통코드를 사용할 거니?
	 ********************************************************************************************************/
	//이 페이지네이션을 사용하는 페이지마다 몇개씩 보여줄지, 페이지이름 , 전체레코드 수, URL  당연히 달라야 하지 않나?
	//해당 페이지에서 생성자의 파라미터로 받아온 정보는 최소한 같은 주소번지에 대해서는 모두 일치해야한다. - 이랬다 저랬다 하면 안되고...
	public BSPageBar(int numPerPage, int totalRecord, int nowPage, String pagePath) {
		this.numPerPage = numPerPage;//한 페이지에 몇 개를 뿌릴거야?
		this.totalRecord = totalRecord;//조회된 전체 레코드 수
		this.nowPage = nowPage;
		this.pagePath = pagePath;
		//공식
		this.totalPage = 
				(int)Math.ceil((double)this.totalRecord/this.numPerPage);// 47.0/10=> 4.7 4.1->5page 4.2->5page
		this.totalBlock= 
				(int)Math.ceil((double)this.totalPage/this.pagePerBlock);//5.0/2=> 2.5-> 3장
		//현재 내가바라보는 페이지 : (int)((double)4-1/2)
		this.nowBlock = (int)((double)this.nowPage/this.pagePerBlock);
	}
	//setter메소드 선언
	//페이징처리로 필요한 화면(Tag)을 그려주는 메소
	public void setPageBar() {
		//문자열을 조작할 때 원본이 바뀌지 않는 String클래스 대신에 StringBuilder{싱글스레드안전-속도는 조금 빠름}나 StringBuffer{멀티스레드안전-속도는 조금 느림}클래스를 사용하자
		StringBuilder pageLink = new StringBuilder();
		//전체 레코드 수가 0보다 클때 처리하기 - 조회된 글이나 등록된 글이 있을 때만 페이지 네비게이션이 필요함
		if(totalRecord>0) {
			//nowBlock이 0보다 클때 처리
			//이전 페이지로 이동 해야 하므로 페이지 번호에 a태그를 붙여야 하고
			//pagePath뒤에 이동할 페이지 번호를 붙여서 호출 해야함.
			if(nowBlock > 0 ) {                                    
				pageLink.append("<li class='page-item'>");
				pageLink.append("<a class='page-link' href='"+pagePath+"&nowPage="+((nowBlock-1)*pagePerBlock+(pagePerBlock-1))+"'>");
				pageLink.append("<span aria-hidden='true'>&laquo;</span>");//>>
				pageLink.append("</a>");
				pageLink.append("</li>");
			}
			for(int i=0;i<pagePerBlock;i++) {//전체 페이지 블록 수
				//현재 내가 보고 있는 페이지 블록 일때와
				if(nowBlock*pagePerBlock+i==nowPage) {
					pageLink.append("<a class='page-link'>"+(nowBlock*pagePerBlock+i+1)+"</a>");
				}
				//그렇지 않을 때를 나누어 처리해야 함.
				//4번과 6번에 대해서는 마우스를 올렸을 때 손모양으로 이미지가 변함
				else {
					pageLink.append("<a class='page-link' href='"+pagePath+"&nowPage="+((nowBlock*pagePerBlock)+i)+"'>"+((nowBlock*pagePerBlock)+i+1)+"</a>");
					
				}
				//모든 경우에 pagePerBlock만큼 반복되지 않으므로 break처리해야 함.
				//주의할 것.
				//for문을 탈출할 때는 break문을 사용할것.
				if((nowBlock*pagePerBlock)+i+1==totalPage) break;// 더 갈데가 없어요  2*3+0+1=7, 2*3+1+1=8, 2*3+2+1=9
			}//end of  for문  
			//현재 블록에서 다음 블록이 존재할 경우 이미지 추가하고 페이지 이동할 수 있도록 a태그 활용하여 링크 처리하기
			if(totalBlock > nowBlock+1) {
				pageLink.append("<li class='page-item'>");
				pageLink.append("<a class='page-link' aria-label='Next' href='"+pagePath+"&nowPage="+((nowBlock+1)*pagePerBlock)+"'>");
				pageLink.append("<span aria-hidden=\"true\">&raquo;</span>");//<<
				pageLink.append("</a>");	
				pageLink.append("</li>");
			}
		}
		logger.info("pageLink.toString():"+pageLink.toString());
		pagination = pageLink.toString();//pageLink가 StringBuilder타입이므로 toString()을 붙임.
	}
	//getter메소드 선언
	//
	public String getPageBar() {//getPageBar()의 리턴타입이 String이니까 print메소드 안에서 호출이 가능하였다
		this.setPageBar();
		//인스턴스화 할때마다 달라야져야 함 -> BSPageBar pb = new BSPageBar();
		return pagination;// 1 2 3 >>   << 4 5 6 >>   << 7
	}
}