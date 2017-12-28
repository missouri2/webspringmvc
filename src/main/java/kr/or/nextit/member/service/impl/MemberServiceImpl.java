package kr.or.nextit.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.mapper.MemberMapper;
import kr.or.nextit.member.model.Member;
import kr.or.nextit.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public List<Member> getMemberList(Map<String, Object> paramMap) throws Exception{		
		return memberMapper.selectMemberList(paramMap);
	}

	@Override
	public Member getMember(String mem_id) throws Exception {
		return memberMapper.selectMember(mem_id);
	}

	@Override
	public int insertMember(Member member) throws Exception {		
		return memberMapper.insertMember(member);		
	}

	@Override
	public int updateMember(Member member) throws Exception {
		return memberMapper.updateMember(member);
	}

	@Override
	public int deleteMember(String mem_id) throws Exception {
		return memberMapper.deleteMember(mem_id);
	}
}
