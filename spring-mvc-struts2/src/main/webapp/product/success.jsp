<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="us.supercheng.spring4.spring.springmvc.struts2.entity.Product" %>
<%@ page import="us.supercheng.spring4.spring.springmvc.struts2.service.IProductService" %>
<%@ page import="us.supercheng.spring4.spring.springmvc.struts2.service.impl.ProductServiceImpl" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="us.supercheng.spring4.spring.springmvc.struts2.struts.action.ProductAction" %>
<html>
<body>
<%
    ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
    Product product = applicationContext.getBean(Product.class);
    ProductAction productAction = applicationContext.getBean(ProductAction.class);
    IProductService productService = applicationContext.getBean(ProductServiceImpl.class);
    response.getWriter().println("<hr><h3>" + product.toString() + "</h3>");
    response.getWriter().println("<hr><h3>productService: " + productService.toString() + "</h3>");
    response.getWriter().println("<hr><h3>productAction: " + productAction.toString() + "</h3>");
    response.getWriter().println("<hr><h3>Cheng: " + application.getAttribute("Cheng") + "</h3>");
    response.getWriter().println("<hr><h3>application: " + application + "</h3>");
    response.getWriter().println("<hr><h3>Request: " + request.getAttribute("RequestScope") + "</h3>");
    response.getWriter().println("<hr><h3>Session: " + session.getAttribute("SessionScope") + "</h3>");
%>
</body>
</html>
