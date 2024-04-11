package kr.ac.hansung.cse.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*") //루트 이외의 모든 request를 가로채겠다.
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(((HttpServletRequest) request).getRequestURL());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
