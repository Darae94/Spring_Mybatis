package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {

	private String namespace= "travel.TravelBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public List<TravelBean> getTravelList(Paging pageInfo,Map<String,String> map) {
		List<TravelBean> lists = new ArrayList<TravelBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetTravelList",map,rowBounds);
		//System.out.println("lists.get(0).getArea():"+lists.get(0).getArea());
//		for(TravelBean tb : lists) {
//			System.out.println(tb.getName());
//		}
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	public void insertTravel(TravelBean tb) {
		//System.out.println(tb.getArea());
		sqlSessionTemplate.insert(namespace+".InsertTravel", tb);
	}

	public TravelBean getTravel(int num) {
		TravelBean tb = sqlSessionTemplate.selectOne(namespace+".GetTravel", num);
		return tb;
	}

	public void deleteTravel(int num) {
		sqlSessionTemplate.delete(namespace+".DeleteTravel", num);
	}

	public int updateTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.delete(namespace+".UpdateTravel", travel);
		return cnt;
	}
	
}






