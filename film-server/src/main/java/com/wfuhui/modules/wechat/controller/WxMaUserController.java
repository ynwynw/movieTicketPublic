package com.wfuhui.modules.wechat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.web.utils.JwtUtils;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.member.entity.MemberEntity;
import com.wfuhui.modules.member.service.MemberService;

/**
 * 微信小程序用户接口
 */
@RestController
@RequestMapping("/api/wechat")
public class WxMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMaService wxService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登陆接口
     */
    @AuthIgnore
    @GetMapping("login")
    public R login(String code) {
        if (StringUtils.isBlank(code)) {
            return R.error("empty jscode");
        }

        try {
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            
            //查询用户信息
            MemberEntity user = memberService.queryByOpenid(session.getOpenid());
            if(user == null) {
            	String sessionKey = session.getSessionKey();
            	return R.error(1, "未注册").put("sessionKey", sessionKey);
            }
            
            //生成token
            String token = jwtUtils.generateToken(user.getId());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("token", token);
            map.put("userInfo", user);
            return R.ok(map);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            return R.error();
        }
    }
    
    /**
     * 用户注册
     */
    @AuthIgnore
    @GetMapping("register")
    public R register(String avatarUrl, String nickname, String gender, String code) {
		try {
			String openid = this.wxService.getUserService().getSessionInfo(code).getOpenid();
			//查询用户信息
            MemberEntity user = memberService.queryByOpenid(openid);
            if(user != null) {
            	return R.ok();
            }
			//注册
	        MemberEntity member = new MemberEntity();
	        member.setAvatarUrl("http://localhost:10001/img/1672730642079.jpg");
	        member.setOpenid(openid);
	        member.setNickname(filterUtf8mb4(nickname));
	        member.setGender(gender);
	        member.setCreateTime(new Date());
	        memberService.save(member);
	        return R.ok();
		} catch (WxErrorException e) {
			e.printStackTrace();
			return R.error();
		}
    }
    
    public static String filterUtf8mb4(String str) {
        final int LAST_BMP = 0xFFFF;
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            if (codePoint < LAST_BMP) {
                sb.appendCodePoint(codePoint);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
