package egovframework.fg.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.cmmn.EgovSampleOthersExcepHndlr;
import egovframework.fg.mapper.FgMapper;
@Service
public class FgSampleService{
	
	@Autowired
	private FgMapper fgMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleOthersExcepHndlr.class);
	
	public HashMap<String, Object> getBoardList(HashMap<String, Object> paramMap) throws Exception{
		LOGGER.debug("service");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<?> resultList = fgMapper.selectList(paramMap);
		LOGGER.debug("AAA");
		resultMap.put("resultList", resultList);
		return resultMap;
	}

}
