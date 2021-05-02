package com.programcreek.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programcreek.helloworld.dao.MemberDao;
import com.programcreek.helloworld.model.Member;
//j個又是啥
@Service("memberService")
@Transactional //存取映射必須加上交易管理注釋，用來確定這筆資料處理完成都沒報錯才回處理，如果中間有錯誤就不會動到資料庫
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberDao memberDao;
  
  
  
  @Override
  public Member getMember(Integer memberId) {
    return memberDao.getMember(memberId);
  }

}