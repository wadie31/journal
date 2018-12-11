package com.wall.mapper;

import org.springframework.data.domain.Slice;
import org.springframework.http.HttpHeaders;

import com.wall.entities.Article;

public class PaginationUtil {

	public static HttpHeaders generateSliceHttpHeaders(Slice<Article> slice) {
		  HttpHeaders headers = new HttpHeaders();
		  headers.add("X-Has-Next-Page", "" + slice.hasNext());
		  return headers;
		}

}
