package us.supercheng.spring4.spring.springmvc.struts2.struts.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.SessionScope;
import us.supercheng.spring4.spring.springmvc.struts2.entity.Product;
import us.supercheng.spring4.spring.springmvc.struts2.service.IProductService;
import us.supercheng.spring4.spring.springmvc.struts2.service.impl.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Scope("prototype")
public class ProductAction {

    @Autowired
    private IProductService productService;

    public ProductAction() {
        super();
        System.out.println(this.productService);
    }

    public IProductService getProductService() {
        return productService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public String execute(){
        ServletContext servletContext = ServletActionContext.getServletContext();
        servletContext.setAttribute("Cheng", "Hongyu");
        ServletActionContext.getRequest().setAttribute("RequestScope","Request-Scope");
        ServletActionContext.getRequest().getSession().setAttribute("SessionScope","Session-Scope");

        Product product = new Product();
        product.setName("TestName" + new Date());
        product.setBrand("TestBrand");
        this.productService.checkProductService(product);
        return "product";
    }
}