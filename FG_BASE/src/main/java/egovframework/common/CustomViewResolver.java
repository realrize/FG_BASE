package egovframework.common;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import egovframework.example.cmmn.EgovSampleOthersExcepHndlr;


public class CustomViewResolver extends UrlBasedViewResolver implements Ordered {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleOthersExcepHndlr.class);
	
	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		AbstractUrlBasedView view = buildView(viewName);
		View viewObj = (View) getApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
		LOGGER.debug("viewObj: "+viewObj);
		if (viewObj instanceof JstlView) {
		JstlView jv = (JstlView) viewObj;
		LOGGER.debug(jv.getBeanName());
			if (jv.getBeanName().indexOf(".jsp") != -1) {
			    return null;
			}
		}
	return viewObj;
	}
	
}
