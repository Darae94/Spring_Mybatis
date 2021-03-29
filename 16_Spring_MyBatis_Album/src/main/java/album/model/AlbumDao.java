package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/* AlbumDao myAlbumDao = new AlbumDao(); */
@Component("myAlbumDao")
public class AlbumDao {
	
	// root-context.xml 에서 객체 생성함
	@Autowired // 객체 주입!
	SqlSessionTemplate sqlSessionTemplate;
	
	public AlbumDao() {
		System.out.println("AlbumDao() 생성자");
	}

	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String, String> map) {
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit()); // 1페이지 :0,2 2페이지:2,2 3페이지:4,2
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList",map,rowBounds); // namespace(album.AlbumBean) 안의 id(GetAlbumList)
		//System.out.println("AlbumDao lists.size(): "+lists.size());
		return lists;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("album.AlbumBean.GetTotalCount",map);
		return cnt;
	}

	public void insertAlbum(AlbumBean album) {
		sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum", album);
	}

	public void deleteAlbum(int num) {
		sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum", num);
	}

	public AlbumBean getAlbum(int num) {
		AlbumBean bean = sqlSessionTemplate.selectOne("album.AlbumBean.GetAlbum", num);
		return bean;
	}

	public void updateAlbum(AlbumBean album) {
		sqlSessionTemplate.update("album.AlbumBean.UpdateAlbum", album);
	}
	
}
