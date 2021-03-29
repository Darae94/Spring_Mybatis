package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMovieDao")
public class MovieDao {

	private String namespace = "movie.MovieBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getCountMovie(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+"GetCountMovie", map);
		return cnt;
	}
	
	public List<MovieBean> getMovieList(Paging pageInfo, Map<String, String> map) {
		List<MovieBean> lists = new ArrayList<MovieBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+"GetMovieList", map, rowBounds);
		return lists;
	}
	
	public void insertMovie(MovieBean mb) {
		sqlSessionTemplate.insert(namespace+"InsertMovie", mb);
	}
	
	public MovieBean getMovie(int num) {
		MovieBean mb = sqlSessionTemplate.selectOne(namespace+"GetMovie", num);
		return mb;
	}
	
	public void deleteMovie(int num) {
		sqlSessionTemplate.delete(namespace+"DeleteMovie", num);
	}
	
	public int updateMovie(MovieBean mb) {
		int cnt = sqlSessionTemplate.update(namespace+"UpdateMovie", mb);
		return cnt;
	}
	
}
