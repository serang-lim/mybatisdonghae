package kr.co.mybatisdonghae.Treview;

import java.util.List;


public interface ITreviewDAO {

	int seqselect();

	int create(TreviewDTO dto);

	int fcreate(TreviewFileDTO fdto, int seq);

	List<TreviewDTO> list();

	TreviewDTO read(int rnum);

	List<TreviewFileDTO> fread(int rnum);

}//interface end
