package kr.co.mybatisdonghae.Tpromotion;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository	//<-모델클래스로 지정하면 스프링컨테이너에서 관리를 해줌
public class TpromotionDAO implements ITpromotionDAO {

	//root-context.xml에서 <bean id="sqlSession">를 가리킴
	@Inject	//<-사용자가 직접 만들지 않고 스프링에서 생성해서 주입을 시킴
	SqlSession sqlSession;
	
	@Override
	public List<TpromotionDTO> list() {
		
		return sqlSession.selectList("Tpromotion.list");
	}//list() end

	@Override
	public void insert(TpromotionDTO dto) {
		sqlSession.insert("Tpromotion.insert",dto);
	}//insert() end

	@Override
	public TpromotionDTO read(int tbno) {
		return sqlSession.selectOne("Tpromotion.read", tbno);
		
	}

	@Override
	public void delete(int tbno) {
		sqlSession.delete("Tpromotion.delete", tbno);
		
	}//delete() end

	@Override
	public void update(TpromotionDTO dto) {
		sqlSession.update("Tpromotion.update", dto);
		
	}//update() end


	
	
}//class end
