package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "SessionFilter", urlPatterns = { "*.xhtml" })
public class SessionFilter implements Filter {
	public SessionFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession();

			String reqURI = req.getRequestURI();

			System.out.println(reqURI + " " + session.getAttribute("username"));
			if (reqURI.indexOf("/pages/index.xhtml") >= 0
					&& session.getAttribute("username") != null) {
				res.sendRedirect("/pages/home.xhtml");
			}
			
			if (reqURI.indexOf("/pages/index.xhtml") >= 0
					|| session.getAttribute("username") != null
					|| reqURI.contains("javax.faces.resource")
					|| reqURI.contains("/pages/registration.xhtml")) {
				
				chain.doFilter(request, response);
			} else {
				res.sendRedirect("/pages/index.xhtml");
			}
		} catch (Exception e) {
			((HttpServletResponse) response).sendRedirect("/pages/error.xhtml");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
