package kr.co.mybatisdonghae.Treview;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreviewCont {

	@Inject
	TreviewDAO dao;
	
	public TreviewCont() {
		System.out.println("---TreviewCont() 객체 생성됨...");
	}//MemberCont() end
	
	//-------------------------------------------------------------
	
	@RequestMapping("/Treview/Treview.do")
	public String list(Model model) throws Exception {
		List<TreviewDTO> list = dao.list();
	       model.addAttribute("list", list);
	       //System.out.println(list);

		return "Treview/Treviewlist";
	}//list() end
	
	//-------------------------------------------------------------
	
	@RequestMapping("/Treview/read.do")
	public String read(@RequestParam(required=false, defaultValue="0") int rnum, Model model) throws Exception {
		model.addAttribute("dto", dao.read(rnum));
		System.out.println(dao.read(rnum));
		return "Treview/Treviewread";
	}//read() end
	
	//-------------------------------------------------------------
	@RequestMapping("/Treview/createrform.do")
	public String createrform() {
		return "Treview/Treviewcreate";
	}//createrform end
	
	@RequestMapping("/Treview/create.do")
	public String insert(@ModelAttribute TreviewDTO dto) throws Exception {
		dao.insert(dto);
		System.out.println(dto.toString());
		
		return "redirect:/Treview/Treview.do";
	}//insert() end
	
	//-------------------------------------------------------------
	@RequestMapping("/Treview/updateform.do")
	public String updateForm(@RequestParam(required=false, defaultValue="0") int rnum, Model model) throws Exception {
		model.addAttribute("dto", dao.read(rnum));  
		return "Treview/Treviewupd";
   }//updateForm() end
	
	@RequestMapping("/Treview/update.do")
	public String update(@ModelAttribute TreviewDTO dto) throws Exception {
		dao.update(dto);
		System.out.println(dto.toString());
		
		return "redirect:/Treview/Treview.do";
		
	}//update() end
	//-------------------------------------------------------------
	@RequestMapping("/Treview/delete.do")
	public String delete(@RequestParam(required=false, defaultValue="0") int rnum, Model model) throws Exception {
		dao.delete(rnum);
		
		return "redirect:/Treview/Treview.do";
		
	}//update() end
	
}//class end
