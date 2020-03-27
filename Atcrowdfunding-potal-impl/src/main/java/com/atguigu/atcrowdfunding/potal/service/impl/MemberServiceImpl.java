package com.atguigu.atcrowdfunding.potal.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.exception.LoginFailException;
import com.atguigu.atcrowdfunding.potal.dao.MemberMapper;
import com.atguigu.atcrowdfunding.potal.service.MemberService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	public Member queryMemberlogin(Map<String, Object> paramMap) {
		
		Member member = memberMapper.queryMebmerlogin(paramMap);
		
		if(member==null){
			throw new LoginFailException("用户账号或密码不正确!");
		}
		return member;
	}

	public void updateAcctType(Member loginMember) {
		memberMapper.updateAcctType(loginMember);
	}

	public void updateBasicinfo(Member loginMember) {
		memberMapper.updateBasicinfo(loginMember);
		
	}

	public void updateEmail(Member loginMember) {
		memberMapper.updateEmail(loginMember);
		
	}

	public void updateAuthstatus(Member loginMember) {
		memberMapper.updateAuthstatus(loginMember);
	}

	public Member getMemberById(Integer memberid) {
		
		return memberMapper.getMemberById(memberid);
	}

	public List<Map<String, Object>> queryCertByMemberid(Integer memberid) {
		return memberMapper.queryCertByMemberid(memberid);
	}

	public int saveMember(Member member) {
		member.setUserpswd(MD5Util.digest(member.getUserpswd()));
		return memberMapper.saveMember(member);
	}
}
