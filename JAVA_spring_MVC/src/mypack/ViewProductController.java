package mypack;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/view_product")
public class ViewProductController {
	@RequestMapping(method=RequestMethod.GET)
	public String before(){
		return "view";
	}
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(HttpServletRequest request,HttpSession session){
		String sel=request.getParameter("sel");
		List<Product> l=pdao.viewProduct(sel);
		session.setAttribute("mylist", l);
		return "result";
		
	}

}
