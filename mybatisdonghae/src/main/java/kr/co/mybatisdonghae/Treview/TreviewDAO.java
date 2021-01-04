package kr.co.mybatisdonghae.Treview;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //<-모델클래스로 지정하면 스프링 컨테이너에서 관리를 해줌
public class TreviewDAO implements ITreviewDAO {
	
	//root Context.xml에서 <bean id="sqlSession">를 가리킴
	@Inject //사용자가 직접 만들지 않고 스프링에서 생성해서 주입을 시킴
	SqlSession sqlSession;
	
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
	
}//class end
