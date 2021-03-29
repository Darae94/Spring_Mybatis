package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMemberDao")
public class MemberDao {

	private String namespace = "member.model.Member.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void insertMember(Member member) {
		sqlSessionTemplate.insert(namespace+"InsertMember", member);
	}
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+"GetTotalCount", map);
		return cnt;
	}
	
	public List<Member> getMemberList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<Member> lists = new ArrayList<Member>();
		lists = sqlSessionTemplate.selectList(namespace+"GetMemberList", map, rowBounds);
		return lists;
	}
	
	public Member getMember(String id) {
		Member member = sqlSessionTemplate.selectOne(namespace+"GetMember", id);
		return member;
	}
	
	public int updateMember(Member mb) {
		int cnt = sqlSessionTemplate.update(namespace+"UpdateMember", mb);
		return cnt;
	}
	
	public void deleteMember(String id) {
		sqlSessionTemplate.delete(namespace+"DeleteMember", id);
	}

	public int searchMember(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+"SearchMember",map);
		return cnt;
	}
	
}
