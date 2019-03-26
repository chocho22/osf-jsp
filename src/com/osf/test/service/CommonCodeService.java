package com.osf.test.service;

import java.util.List;

import com.osf.test.vo.CommonCodeVO;

public interface CommonCodeService {
	public List<CommonCodeVO> selectCommonCodeList(String ccGroup);
}
