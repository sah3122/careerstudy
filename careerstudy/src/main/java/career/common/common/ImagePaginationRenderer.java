/*package career.common.common;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

public class ImagePaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{

	private ServletContext servletContext;
	
	public ImagePaginationRenderer() {
	
	}
	
	public void initVariables(){
		firstPageLabel    = "<div class=\"box-footer clearfix text-center\"><div class=\"row\"><div class=\"col-md-4\"></div><div class=\"col-md-4\">\n<ul class=\"pagination pagination-sm no-margin\">\n";
        previousPageLabel = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">&laquo;</a></li>\n";
        currentPageLabel  = "<li class=\"active\"><a>{0}</a></li>\n";
        otherPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a></li>\n";
        nextPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">&raquo;</a></li>\n";
        lastPageLabel     = "</ul>\n</div></div></div></div>\n";
	}

	

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}

}
*/