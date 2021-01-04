package kr.co.mybatisdonghae.Tpromotion;

import java.util.List;


public interface ITpromotionDAO {

	public List<TpromotionDTO> list();
    public void insert(TpromotionDTO dto);
    public TpromotionDTO read(int tbno);
    public void delete(int tbno);
    public void update(TpromotionDTO dto);

	
}//interface end
