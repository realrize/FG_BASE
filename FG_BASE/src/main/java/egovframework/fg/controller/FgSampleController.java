/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.fg.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.cmmn.EgovSampleOthersExcepHndlr;
import egovframework.fg.service.FgSampleService;


@Controller
public class FgSampleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleOthersExcepHndlr.class);
	@Autowired
	private FgSampleService fgSampleService;

	@RequestMapping(value = "/fgList.do")
	public ModelAndView selectSampleList(ModelMap model) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> sampleData = fgSampleService.getBoardList(model);
		modelAndView.addObject("sampleData", sampleData);
		modelAndView.setViewName("fg/egovSampleList.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/fgHtml.do")
	public ModelAndView selectHtmlList(ModelMap model) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> sampleData = fgSampleService.getBoardList(model);
		modelAndView.addObject("sampleData", sampleData);
		modelAndView.setViewName("fg/aa.html");
		
		return modelAndView;
	}

	@RequestMapping(value = "/fgInsert.do")
	public ModelAndView insertBoard(ModelMap model) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> sampleData = fgSampleService.insertBoard(model);
		modelAndView.addObject("sampleData", sampleData);
		modelAndView.setViewName("fg/egovSampleList");
		
		return modelAndView;
	}

}
