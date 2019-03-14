package jwang.filter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class LoginFilter extends ZuulFilter{

	@Override
	public Object run() {
		//JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = (HttpServletRequest) requestContext.getRequest();

        //token对象,有可能在请求头传递过来，也有可能是通过参数传过来，实际开发一般都是请求头方式
        String token = request.getHeader("token");

        if (StringUtils.isBlank((token))) {
            token = request.getParameter("token");
        }
        System.out.println("页面传来的token值为：" + token);
        //登录校验逻辑  如果token为null，则直接返回客户端，而不进行下一步接口调用
        if (StringUtils.isBlank(token)) {
            // 过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //返回错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		 //共享RequestContext，上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = (HttpServletRequest) requestContext.getRequest();

        System.out.println(request.getRequestURI());
        //需要权限校验URL
        if ("/apigateway/order/api/v1/order/save".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        } else if ("/apigateway/order/api/v1/order/list".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        } else if ("/apigateway/order/api/v1/order/find".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        }
        return false;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		
		return null;
	}

}	
