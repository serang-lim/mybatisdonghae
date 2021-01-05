package kr.co.mybatisdonghae.Treview;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ITreviewDAO {
	/*
	public List<TreviewDTO> list() throws Exception;
	public TreviewDTO read(int rnum) throws Exception;
    public void insert(TreviewDTO dto) throws Exception;
    public void update(TreviewDTO dto) throws Exception;
    public void delete(int rnum) throws Exception;
    public void increaseCnt(int rnum) throws Exception;
    */
	
	public void createReview(TreviewDTO treviewDTO, List<TreviewFileDTO> filelist, String[] fileNum);
	public TreviewDTO readReview(int rnum);
	public void updateReview(TreviewDTO treviewDTO, List<TreviewFileDTO> filelist, String[] fileNum);
	public void deleteReview(int rnum);
	public void increaseCnt(int rnum);
	public List<TreviewDTO> Reviewlist(SearchCriteria cri);
	public Integer ReviewCount(SearchCriteria cri);
	public List<TreviewFileDTO> flist(int rnum);
	public String getMaxCode();
	public void fileUpload(String realName, String fileName, long fileSize);
	public void insert(TreviewDTO dto);
	
}//interface end
