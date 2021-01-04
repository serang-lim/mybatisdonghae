package kr.co.mybatisdonghae.Treview;

import java.util.List;

public interface ITreviewDAO {
	
	public List<TreviewDTO> list() throws Exception;
	public TreviewDTO read(int rnum) throws Exception;
    public void insert(TreviewDTO dto) throws Exception;
    public void update(TreviewDTO dto) throws Exception;
    public void delete(int rnum) throws Exception;
    public void increaseCnt(int rnum) throws Exception;
    
}//interface end
