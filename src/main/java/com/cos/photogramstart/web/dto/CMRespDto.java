package com.cos.photogramstart.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {

	private int code; // 응답코드 성공1, 실패 -1
	private String message;
	private T data;
}
