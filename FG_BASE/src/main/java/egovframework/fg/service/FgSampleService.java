package egovframework.fg.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.example.cmmn.EgovSampleOthersExcepHndlr;
import egovframework.fg.mapper.FgMapper;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class FgSampleService{
	
	@Autowired
	private FgMapper fgMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleOthersExcepHndlr.class);
	
	public HashMap<String, Object> getBoardList(HashMap<String, Object> paramMap) throws Exception{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<?> resultList = fgMapper.selectList(paramMap);
		resultMap.put("resultList", resultList);
		return resultMap;
	}
	
	public HashMap<String, Object> insertBoard(HashMap<String, Object> paramMap) throws Exception{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			
			paramMap.put("ID", 6);
			paramMap.put("CAT_ID", 1);
			paramMap.put("CAT_NM", "공지");
			paramMap.put("CONTENT", "ABC");
			paramMap.put("USE_YN", "Y");
			paramMap.put("REG_ID", "realrize");
			
			int result = fgMapper.insertBoard(paramMap);
			
			LOGGER.debug("resultCode: "+result);
			resultMap.put("resultCode", result);
			throw new Exception(); 
			
		}catch(Exception e){
			LOGGER.debug("exception");
		}

		return resultMap;
	}
	
	

}
