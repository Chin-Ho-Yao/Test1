package com.programcreek.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programcreek.helloworld.dao.MemberDao;
import com.programcreek.helloworld.model.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberDao memberDao;
  
  @Transactional
  @Override
  public Member getMember(Integer memberId) {
    return memberDao.getMember(memberId);
  }

}