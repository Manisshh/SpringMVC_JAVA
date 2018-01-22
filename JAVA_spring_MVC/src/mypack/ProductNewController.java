package mypack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/new_product")
public class ProductNewController {
	List <String>categorylist;
	
	@Autowired
	ProductDAO pdao;
	@RequestMapping(method=RequestMethod.POST)
	public String proccessSubmit(Product myproduct)
	{
		pdao.add(myproduct);
		return "success";
	}
	@ModelAttribute("categoryList")
	public List<String> populateWebFrameworkList(){
		categorylist=new ArrayList<String>();
		categorylist.add("Stationery");
		categorylist.add("Electronics");
		categorylist.add("Grocerry");
		return categorylist;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView before()
	{
		Product defaultProduct=new Product();
		//defaultProduct.setPname("Enter New Product Name");
		//defaultProduct.setPrice(0);
		return new ModelAndView("add","myproduct",defaultProduct);
	}
}
