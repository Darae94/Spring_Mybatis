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
	
	// root-context.xml ���� ��ü ������
	@Autowired // ��ü ����!
	SqlSessionTemplate sqlSessionTemplate;
	
	public AlbumDao() {
		System.out.println("AlbumDao() ������");
	}

	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String, String> map) {
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit()); // 1������ :0,2 2������:2,2 3������:4,2
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList",map,rowBounds); // namespace(album.AlbumBean) ���� id(GetAlbumList)
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
