package com.itcen.lsy.util;

public class Pager {
	int page = 1;
	int perPage = 10; // 한화면에 몇페이지까지 보여줄건가

	float total;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getPagination() {
		String html = "<div class=\"pagination pagination-sm justify-content-center\">";

		int maxPage = (int) Math.ceil(total / perPage); // 전체 페이지 수
		int startPage = (page < 3) ? 1 : (page - 2); // 삼항 연산자
		int endPage = (page < 3) ? 5 : (page + 2);

		html += "<span class=\"page-item\"> <a class=\"page-link\" href=\"?page=1\">" + "처음" + "</a></span>";

		html += "<span class=\"page-item\"> <a class=\"page-link\" href=\"?page=" + (page > 1 ? page - 1 : 1) + "\">" + "&laquo" + "</a></span>";

		for (int i = startPage; i <= endPage && i <= maxPage; i++) {

			html += "<span class=\"page-item ";
			if( i==page)
				html += "active";
				
					html +=  "\"> <a class=\"page-link\" href=\"?page=" + i + "\">" + i + "</a></span>";

		}
		
		html += "<span class=\"page-item\"> <a class=\"page-link\" href=\"?page=" + (page < maxPage ? page + 1 : maxPage) + "\">" + "&raquo" + "</a></span>";

		html += "<span class=\"page-item\"> <a class=\"page-link\" href=\"?page=" + maxPage + "\">" + "마지막" + "</a></span>";
		
		html += "</div>";
		
		return html;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

}
