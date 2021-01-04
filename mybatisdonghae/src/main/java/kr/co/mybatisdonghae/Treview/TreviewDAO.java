package kr.co.mybatisdonghae.Treview;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository //<-모델클래스로 지정하면 스프링 컨테이너에서 관리를 해줌
public class TreviewDAO implements ITreviewDAO {
	
	//root Context.xml에서 <bean id="sqlSession">를 가리킴
	@Inject //사용자가 직접 만들지 않고 스프링에서 생성해서 주입을 시킴
	SqlSession sqlSession;
	
	@Autowired
    private DataSourceTransactionManager txManager;
	
	/*
	@Override
	public List<TreviewDTO> list() throws Exception{
		return sqlSession.selectList("treview.list");
	}
	
	@Override
	public TreviewDTO read(int rnum) throws Exception{
		// selectOne() 레코드 1개
		// selectList() 레코드 2개 이상
		return sqlSession.selectOne("treview.read", rnum);
	}//detail() end

	@Override
	public void insert(TreviewDTO dto) throws Exception{
		sqlSession.insert("treview.insert", dto);
	}//insert() end

	@Override
	public void update(TreviewDTO dto) throws Exception{
		sqlSession.update("treview.update", dto);
	}//update() end
	
	@Override
	public void delete(int rnum) throws Exception{
		sqlSession.delete("treview.delete", rnum);
	}//delete() end
	
	//조회수 증가
	@Override
	public void increaseCnt(int rnum) throws Exception {
		sqlSession.update("treveiw.increaseCnt", rnum);
	};
	*/
	/*
	// 등록
    @Override
    public void createReview(TreviewDTO treviewDTO, List<TreviewFileDTO> filelist, String[] fileNum) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);        
        try {
            sqlSession.insert("treview.insert");
             
            if (fileNum != null) {
                HashMap<String, String[]=""> fileVO = new HashMap<string, string[]="">();
                fileVO.put("fileNum", fileNum);
                sqlsession.insert("treview.deletefile");
            }
             
            for (ReviewFileDTO file : filelist) {
                file.setReviewPK(ReviewDTO.getReviewNum());
                sqlsession.insert("treview.insertfile", file);
            }
            txManager.commit(status);
        } catch (TransactionException ex) {
            txManager.rollback(status);
            System.out.println("데이터 저장 오류: " + ex.toString());
        }           
    }   
    */
    // 상세보기
    @Override
    public TreviewDTO readReview(int rnum) {
        return sqlSession.selectOne("treview.read", rnum);
    }
    /*
    // 업데이트 (+ 파일업데이트)
    @Override
    public void updateReview(TreviewDTO treviewDTO, List<TreviewFileDTO> filelist, String[] fileNum) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);        
        try {
        	sqlSession.update("treview.updateReview", treviewDTO);
             
            if (fileNum != null) {
            	HashMap<String, String[]=""> fileVO = new HashMap<string, string[]="">();
                fileVO.put("fileNum", fileNum);
                sqlsession.insert("treview.deletefile", fileVO);
            }
             
            for (ReviewFileDTO file : filelist) {
                file.setReviewPK(ReviewDTO.getSnum());
                sqlSession.insert("treview.insertfile", file);
            }
            txManager.commit(status);
        } catch (TransactionException ex) {
            txManager.rollback(status);
            System.out.println("데이터 저장 오류: " + ex.toString());
        }               
    }   
    */
    // 삭제
    @Override
    public void deleteReview(int rnum) {
    	sqlSession.delete("treview.delete", rnum);        
    }   
    
    // 조회수 증가
    @Override
    public void increaseCnt(int rnum) {
    	sqlSession.update("treview.increaseCnt", rnum);     
    }
    
    // 리스트(검색 + 페이징)
    @Override
    public List<TreviewDTO> Reviewlist(SearchCriteria cri) {
        return sqlSession.selectList("treview.list", cri);
    }
    
    // 페이징을 위한 카운트  
    @Override
    public Integer ReviewCount(SearchCriteria cri) {
        return sqlSession.selectOne("treview.reviewcount", cri);
    }
    
    // 파일리스트(해당 공지에 대해서)    
    @Override
    public List<TreviewFileDTO> flist(int rnum) {       
        return sqlSession.selectList("treview.filelist", rnum);
    }   
    
    // MAXCODE 증가
    @Override
    public String getMaxCode(){
        return sqlSession.selectOne("treview.maxCode");
    }

}//class end
