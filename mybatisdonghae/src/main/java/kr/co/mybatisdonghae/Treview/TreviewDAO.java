package kr.co.mybatisdonghae.Treview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TreviewDAO implements ITreviewDAO{
      
    
      @Inject
      SqlSession sqlSession;

      
	  @Override    
      public int seqselect() {
    	    
    	  return sqlSession.selectOne("Treview.seqselect");
      }
      
      //---------------------------------------------------------------------------------------------
      
	 @Override
      public int create(TreviewDTO dto) { //쓰기
             return sqlSession.insert("Treview.create",dto); 
      }//create() end
     //----------------------------------------------------------------------------------------------- 
     
	 @Override
	 public int fcreate(TreviewFileDTO fdto, int seq) { //쓰기
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("filename", fdto.getFileName());
			map.put("filesize", fdto.getFilesize());
			map.put("rnum",seq);
			
           return sqlSession.insert("Treview.fcreate",map);
       }//fcreate() end
      
    //---------------------------------------------------------------------------------------------
      
	@Override 
      public List<TreviewDTO> list(){ //목록
         return sqlSession.selectList("Treview.list");
      }//list() end
      
    //---------------------------------------------------------------------------------------------
      
	@Override
      public TreviewDTO read(int rnum) { //상세보기
    	  TreviewDTO dto=new TreviewDTO();
          int cnt=sqlSession.update("Treview.readup", rnum);
          if(cnt!=0) {
        	  dto= sqlSession.selectOne("Treview.read", rnum);
          }else {
        	  dto=null;
          }
          return dto;
       }//read() end
     //----------------------------------------- 
   
	@Override  
	public List<TreviewFileDTO> fread(int rnum){ //목록
         
          return sqlSession.selectList("Treview.flist",rnum);
       }//list() end
     
    //---------------------------------------------------------------------------------------------
      
      public int update(TreviewDTO dto) { 
       
               return sqlSession.update("Treview.update",dto);
      }//update() end
    //---------------------------------------------------------------------------------------------  
      
      public int pwcheck(TreviewDTO dto) {
    	  
    		return sqlSession.selectOne("Treview.pwcheck",dto);
	    	}//pwcheck end

    //---------------------------------------------------------------------------------------------
      public int delete(int rnum) {
       
               return sqlSession.delete("Treview.delete",rnum);
      }//delete() end
      
     //---------------------------------------------------------------------------------------------
      
      public int fdelete(int rnum) {
         
                return sqlSession.delete("Treview.fdelete",rnum);
       }//delete() end
      
    //---------------------------------------------------------------------------------------------

      public List<TreviewDTO> list2(String col, String word) {
    	  	Map<String, Object>map=new HashMap<String, Object>();
    	  	map.put("col", col);
    	  	map.put("word", word);
    	  	List<TreviewDTO> cno=null;
    	  	if(col.equals("0")){
        	  	cno=sqlSession.selectList("Treview.listA", map);
    	  	}else if(word.equals(null)) {
        	  	cno=sqlSession.selectList("Treview.listB", map);
    	  	}else {
        	  	cno=sqlSession.selectList("Treview.listC", map);
    	  	}
    	  	return cno;
         }//list2() end
   
   
       
      
      //글목록 구하기 
      
      
      
   
}//class end