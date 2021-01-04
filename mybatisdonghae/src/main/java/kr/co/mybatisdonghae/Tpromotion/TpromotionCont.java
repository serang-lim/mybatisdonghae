package kr.co.mybatisdonghae.Tpromotion;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TpromotionCont {
	@Inject
	TpromotionDAO dao; 
	
	public TpromotionCont(){
		System.out.println("---TpromotionCont() 객체 생성됨 !!! ");
	}//기본생성자함수
	
	@RequestMapping("/index.do")
    public String index() {
    	return "./index";
    }//insert() end

//--------------------------------------------------------------------------------------------------------
	
	@RequestMapping("Tpromotion/Tpromotion.do")
	public String list(Model model) {
		List<TpromotionDTO> list =dao.list();
	       model.addAttribute("list", list);
	       System.out.println(list);

		return "Tpromotion/TpromotionList";
	}//write() end
	
//--------------------------------------------------------------------------------------------------------	
	
	@RequestMapping("Tpromotion/TpromotionWrite.do")
	public String insert() {
		return "Tpromotion/TpromotionWrite";
	}//write() end

    @RequestMapping("Tpromotion/TpromotionWrite2.do")
    public String insert(@ModelAttribute TpromotionDTO dto, HttpServletRequest req, Model model) {
    	
    	System.out.println(dto.toString());
		//파일 저장 폴더의 실제 물리적인 경로 가져오기

    	  dao.insert(dto);    	  
			
    	return "redirect:Tpromotion.do";
    	
    }//insert() end

    
//--------------------------------------------------------------------------------------------------------    
    
    
    @RequestMapping("Tpromotion/TpromotionRead.do")
    public String detail(@RequestParam int tbno, Model model) {
       model.addAttribute("dto", dao.read(tbno));
       return "Tpromotion/TpromotionRead";
    }//detail() end
    
    
//--------------------------------------------------------------------------------------------------------    
    
    
    @RequestMapping("Tpromotion/TpromotionUpdate.do")
    public String update(int tbno, Model model) {
    	model.addAttribute("dto", dao.read(tbno));
		return "Tpromotion/TpromotionUpdateForm";	//회원목록으로이동    
    }//update() end
    
    
    @RequestMapping("Tpromotion/TpromotionUpdate2.do")
    public String update(@ModelAttribute TpromotionDTO dto, Model model) {
		dao.update(dto);					//회원정보수정
		return "redirect:Tpromotion/Tpromotion.do";	//회원목록으로이동    
    }//update() end
    
    
//--------------------------------------------------------------------------------------------------------
    

	@RequestMapping("Tpromotion/TpromotionDelete.do")
	public String delete() {
		return "Tpromotion/TpromotionDeleteForm";
	}//write() end
    
	@RequestMapping("Tpromotion/TpromotionDelete2.do")
	public String delete(int tbno) {
		dao.delete(tbno);
		return "redirect:Tpromotion/Tpromotion.do";
	}//write() end
    
    
}//class end