package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myBoardDao")
public class BoardDao {

	private String namespace = "board.model.BoardBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getCountBoard(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+"GetCountBoard", map);
		return cnt;
	}
	
	public List<BoardBean> getAllBoard(Paging pageInfo, Map<String, String> map) {
		List<BoardBean> lists = new ArrayList<BoardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+"GetAllBoard", map, rowBounds);
		return lists;
	}
	
	public int insertBoard(BoardBean bb) {
		int cnt = sqlSessionTemplate.insert(namespace+"InsertBoard", bb);
		return cnt;
	}
	
	public BoardBean getBoard(int num) {
		sqlSessionTemplate.update(namespace+"ReadCountUpdate", num);
		BoardBean bb = sqlSessionTemplate.selectOne(namespace+"GetBoard", num);
		return bb;
	}

	public int updateBoard(BoardBean bb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+"UpdateBoard", bb);
		return cnt;
	}

	public int deleteBoard(Map<String, String> map) {
		int cnt = -1;
		//BoardBean bb = sqlSessionTemplate.selectOne(namespace+"CheckPasswd", num);
		cnt = sqlSessionTemplate.delete(namespace+"DeleteBoard", map);
		return cnt;
	}

	public void insertReply(BoardBean board) {
		//System.out.println(board.getRef()+"/"+board.getReStep());
		int re = sqlSessionTemplate.update(namespace+"updateReStep", board);
		//System.out.println("Update reply: "+re);
		int cnt = sqlSessionTemplate.update(namespace+"InsertReply", board);
		//System.out.println("Update reply: "+cnt);
	}
	
}
