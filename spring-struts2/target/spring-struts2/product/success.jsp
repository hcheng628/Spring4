<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="us.supercheng.spring4.spring.struts2.entity.Product" %>
<%@ page import="us.supercheng.spring4.spring.struts2.service.IProductService" %>
<%@ page import="us.supercheng.spring4.spring.struts2.service.impl.ProductServiceImpl" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<body>
<h2>Success!</h2>
    <%
        ApplicationContext applicationContext = (ApplicationContext) application.getAttribute("applicationContext");
        Product product = applicationContext.getBean(Product.class);
        IProductService productService = applicationContext.getBean(ProductServiceImpl.class);
    %>
    <h3><%  response.getWriter().println(product.toString()); %></h3>
    <h3><%  response.getWriter().println(productService.toString()); %></h3>
</body>
</html>
