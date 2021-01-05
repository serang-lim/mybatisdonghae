package kr.co.mybatisdonghae.Treview;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TreviewCont {

	@Inject
	TreviewDAO dao;
	
	public TreviewCont() {
		System.out.println("---TreviewCont() 객체 생성됨...");
	}//MemberCont() end
	
	/*-------------------------------------------------------------
	
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
	public String insert(@RequestParam("photonameMF")MultipartFile[] files
										, TreviewDTO treviewDTO
										,MultipartHttpServletRequest req
										, Model model) throws Exception {
		
		String uploadPath=req.getRealPath("./storage");
		
		
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
	*/
	
	 // 조회
    @RequestMapping("/Treview/Treview.do")
    public String list(@RequestParam("rnum") int rnum,
						SearchCriteria cri, Model model){
         
        int count = dao.ReviewCount(cri);
        model.addAttribute("count", count);
         
        model.addAttribute("list", dao.Reviewlist(cri));
        PageMaker pageMaker = new PageMaker();
 
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(dao.ReviewCount(cri));
        
	     
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("dto", dao.readReview(rnum)); 
        return "Treview/Treviewlist";
    }// list()
  //-------------------------------------------------------------
    
    // 상세보기
    @RequestMapping("/Treview/read.do")
    public String read(@RequestParam(required=false, defaultValue="0") int rnum, @ModelAttribute("cri") SearchCriteria cri, Model model){
        dao.increaseCnt(rnum);
        List<TreviewFileDTO> uploadFileList = dao.flist(rnum);
        
        model.addAttribute("uploadFileList", uploadFileList);  
        model.addAttribute("cri", cri);
        model.addAttribute("dto", dao.readReview(rnum));     
        return "Treview/Treviewread";
    }// read() end

     
  //-------------------------------------------------------------
    
	// 등록 페이지
    @RequestMapping("/Treview/createrform.do")
    public String createrform(Model model) throws Exception{
        model.addAttribute("maxCode", dao.getMaxCode()); 
        return "Treview/Treviewcreate";
    }//noticeWrite() end
    
    // 등록
    @RequestMapping("/Treview/create.do")
    public String insert(int rnum, TreviewDTO dto, Model model) throws IOException{   
		// 파일 업로드 처리
		String fileName = null;
		MultipartFile uploadFile = dto.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			fileName=uuid+"."+ext;
			uploadFile.transferTo(new File("./storage/" + fileName));
		}
		dto.setRphoto_name(fileName);
		dao.insert(dto);
		return "redirect:/Treview/Treview.do";
    }//insert() end
    	
    	/*
    	  
    	String[] fileNum = req.getParameterValues("fileNum");
    	String src = mhsq.getParameter("src");
    	// 넘어온 파일을 리스트로 저장
    	List<MultipartFile> fileList = mhsq.getFiles("uploadFile");
        System.out.println("src value : " + src);
        
        String realFolder = "c:/upload2/";
        File dir = new File(realFolder);
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        		
    	if (fileList.size() == 1 && fileList.get(0).getOriginalFilename().equals("")) {
        } else {
            for (int i = 0; i < fileList.size(); i++) {
                // 파일 중복명 처리
                String genId = UUID.randomUUID().toString();
                // 본래 파일명
                String realName = fileList.get(i).getOriginalFilename();
                String fileName = genId + "." + getExtension(realName);
                // 저장되는 파일 이름
                String savePath = realFolder + fileName; // 저장 될 파일 경로
                long fileSize = fileList.get(i).getSize(); // 파일 사이즈
                fileList.get(i).transferTo(new File(savePath)); // 파일 저장
                dao.fileUpload(realName, fileName, fileSize);
            }	
        }
		 String[] fileNum = req.getParameterValues("fileNum");
	     TreviewFileUtil nf = new TreviewFileUtil();
	     nf.setConPath(req.getSession().getServletContext().getRealPath("/treviewUpload"));
	     List<TreviewFileDTO> filelist = nf.saveAllFiles();
	     dao.createReview(treviewDTO, filelist, fileNum); 
	    
    	---------------------------------------------------------------------------------------
    	// 넘어온 파일을 리스트로 저장
    	List<MultipartFile> fileList = mhsq.getFiles("uploadFile");
        String src = mhsq.getParameter("src");
        System.out.println("src value : " + src);
 
        //String realFolder = "c:/upload2/";
        String path = "C:/upload2/";

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);

            String safeFile = path + System.currentTimeMillis() + originFileName;
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//end
        }//for end
        ------------------------------------------------
        if (fileList.size() == 1 && fileList.get(0).getOriginalFilename().equals("")) {
        } else {
            for (int i = 0; i < fileList.size(); i++) {
                // 파일 중복명 처리
                String genId = UUID.randomUUID().toString();
                // 본래 파일명
                String realName = fileList.get(i).getOriginalFilename();
                String fileName = genId + "." + getExtension(realName);
                // 저장되는 파일 이름
                String savePath = realFolder + fileName; // 저장 될 파일 경로
                long fileSize = fileList.get(i).getSize(); // 파일 사이즈
                fileList.get(i).transferTo(new File(savePath)); // 파일 저장
                dao.fileUpload(realName, fileName, fileSize);
            }
        }//if end
          
           
        
        

//-------------------------------------------------------------
    
    // 수정 페이지
    @RequestMapping("/Treview/updateform.do")
    public String updateForm(@RequestParam("rnum") int rnum, @ModelAttribute("cri") SearchCriteria cri, Model model) {      
        model.addAttribute("dto", dao.readReview(rnum));
        List<TreviewFileDTO> fileview = dao.flist(rnum);
        model.addAttribute("fileview", fileview);
        return "Treview/Treviewupd";
    }

    // 수정
    @RequestMapping(value="/noticeUpdate.do", method=RequestMethod.POST)
    public String update(int rnum, TreviewDTO treviewDTO, SearchCriteria cri, RedirectAttributes rttr, HttpServletRequest request){
         
        String[] fileNum = request.getParameterValues("fileNum");
        TreviewFileUtil nf = new TreviewFileUtil();
        nf.setConPath(request.getSession().getServletContext().getRealPath("/treviewUpload"));
        List<TreviewFileDTO> filelist = nf.saveAllFiles(d.getUploadfile());
 
        dao.updateReview(treviewDTO, filelist, fileNum);
         
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
         
        rttr.addFlashAttribute("updateMsg", "success");
         
        return "redirect:/Treview/read.do?rnum=" + rnum;
    }// updatePOST()
    
  //-------------------------------------------------------------
  */
    // 삭제
    @RequestMapping("/Treview/delete.do")
    public String delete(@RequestParam("rnum") int rnum, SearchCriteria cri, RedirectAttributes rttr) {
        dao.deleteReview(rnum);
         
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
 
        return "redirect:/Treview/Treview.do";
    }// deletePOST()
    
}//class end
