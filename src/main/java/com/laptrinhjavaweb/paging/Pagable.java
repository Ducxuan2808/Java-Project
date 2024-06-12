package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public interface Pagable {

	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
