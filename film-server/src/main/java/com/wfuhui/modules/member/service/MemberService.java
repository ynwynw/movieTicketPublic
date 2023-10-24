package com.wfuhui.modules.member.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.member.entity.MemberEntity;

/**
 * 会员
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public interface MemberService {
	
	MemberEntity queryObject(Long id);
	
	List<MemberEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MemberEntity member);
	
	void update(MemberEntity member);
	
	void delete(Long id);
	
	void deleteBatch(Integer[] ids);

	MemberEntity queryByOpenid(String openid);

	MemberEntity queryByLoginName(String loginName);
}
