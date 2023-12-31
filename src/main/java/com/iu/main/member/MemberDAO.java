package com.iu.main.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	// 이 네임스페이스는 클래스 내부에서만 쓰니까 private
	private final String NAMESPACE="com.iu.main.member.MemberDAO.";
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}

	public int setMemberUpdate(MemberDTO memberDTO)throws Exception {
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
		
	}
}
