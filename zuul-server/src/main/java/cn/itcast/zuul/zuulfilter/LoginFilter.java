package cn.itcast.zuul.zuulfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xualin
 * @version v1.0
 * @date 2019/4/2 11:45
 * @description
 **/

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器四种类型：pre route post error
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 执行顺序 返回值越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行改过滤器 true:执行run方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象
        RequestContext context = RequestContext.getCurrentContext();

        //获取request对象
        HttpServletRequest request = context.getRequest();

        //获取参数
        String parameter = request.getParameter("access-token");
        if (StringUtils.isBlank(parameter)) {
            //不存在，未登录 拦截，不转发请求
            context.setSendZuulResponse(false);

            //响应状态码，401身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            context.setResponseBody("request error!");
        }


        //返回值为null，就代表什么都不做
        return null;
    }
}
