package com.smhrd.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {

	private int startPage;// 시작 페이지
	private int endPage;// 끝 페이지
	private boolean prev, next;// 이전, 다음

	private int total;// 전체 글 개수 저장
	private Criteria cri;// 페이지 번호(pageNum), 한 페이지당 글 개수(amount)

	
	// 생성자
	public Page(Criteria cri, int total) {

		this.cri = cri;
		this.total = total;

		// 여기서 5는 페이지블록을 구성하는 페이지 개수
			//Math.ceil:반올림
		this.endPage = (int) Math.ceil(cri.getPageNum() / 5.0) * 5;

		this.startPage = this.endPage - (5 - 1);

		// 실제 끝페이지
			//끝 페이지가 딱 떨어질 때도 있고 아닐 때도 있기 때문에 이 로직을 거친 후 마지막 페이지 결정
		int realEnd = (int) Math.ceil((double) total / cri.getAmount());

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;

		this.next = this.endPage < realEnd;

	}

}
