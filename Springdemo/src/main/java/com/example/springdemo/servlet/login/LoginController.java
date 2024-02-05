package com.example.springdemo.servlet.login;

import org.springframework.boot.web.server.Cookie;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录登出对request.getSession()的使用
 * 以及
 * jwt、cookie
 * 返回request.getSession().getId()
 *
 * @author jiayn01
 * @date 2023-10-23 17:23:41
 */
public class LoginController {
    /**
     * 1、request.getSession()可以帮你得到HttpSession类型的对象，通常称之为session对象，session对象的作用域为一次会话，通常浏览器不关闭，保存的值就不会消失，当然也会出现session超时。
     * 服务器里面可以设置session的超时时间，web.xml中有一个session time out的地方，tomcat默认为30分钟。
     *
     * 2、session.setAttribute(“key”,value)；是session设置值的方法，原理同java中的HashMap的键值对。
     *
     * 3、可以使用session.getAttribute(“key”);来取值，以为着你能得到userName的值。
     *
     * 4、注意：getAttribute的返回值类型是Object，需要向下转型。
     */
//
//    @RequestMapping(value="/login")
//    @ResponseBody
//    public StatusBean login(@RequestBody Map<String, String> params, HttpServletRequest request, HttpServletResponse response){
//
//        StatusBean status = new StatusBean();
//        String ipAddress = NetworkUtil.getIpAddress(request);
//
//        String userId = params.get("userId");
//        String adminPassword = params.get("adminPassword");
//
//        String storedPassword = propertiesService.getDicValue(BusinessConstants.SYS_PROPERTIES_TYPE_ADMIN_PASSWORD, BusinessConstants.SYS_DICTIONARY_CODE_PASSWORD);
//
//        if (isProductEnvironment.contentEquals(Boolean.TRUE.toString()) && !adminPassword.contentEquals(storedPassword)) {
//            status.setStatusCode(SystemConstants.RETURN_CODE_ERROR);
//            status.setStatusMsg("管理员密码不正确 此次forward方式登录行为的IP地址将被记录");
//            logginLogger.error("IP:" + ipAddress + ",forward 方式登录出现错误 host: [" + request.getRemoteHost() + "], userId: [" + userId + ']');
//            sysLoginLogService.insertSysLogin(userId, ipAddress, SystemConstants.SYS_LOGIN_LOG_TYPE_PROXY);
//            return status;
//        }
//
//        KMUser kmUser= kmUserService.getUserInfo(userId);
//        if (kmUser == null) {
//            logginLogger.error("IP:" + NetworkUtil.getIpAddress(request) + ",在数据库中查询不到人员信息,usernid == " + userId);
//            status.setStatusCode(SystemConstants.RETURN_CODE_ERROR);
//            status.setStatusMsg("人员信息不存: userId = [" + userId + ']');
//            return status;
//        }
//        request.getSession().setAttribute(SystemConstants.SESSION_USERID, userId);
//        request.getSession().setAttribute(SystemConstants.SESSION_USERNAME, kmUser.getChName());
//        request.getSession().setAttribute(SystemConstants.SESSION_EMP_NO, kmUser.getEmpNo());
//        request.getSession().setAttribute(SystemConstants.SESSION_DEPTNAME, kmUser.getOrgChName());
//        request.getSession().setAttribute(SystemConstants.SESSION_DEPTCODE, kmUser.getOrgCode());
//        request.getSession().setAttribute(SystemConstants.SESSION_DC_DEPTCODE, kmUser.getDcOrgCode());
//        request.getSession().setAttribute(SystemConstants.SESSION_DC_COMPANY, kmUser.getBizunitId());
//        request.getSession().setAttribute(SystemConstants.SESSION_USER_EMAIL, kmUser.getEmail());
//        request.getSession().setAttribute(SystemConstants.SESSION_LOGIN_TYPE, SystemConstants.SESSION_LOGIN_TYPE_PROXY);
//
//        KMOrg kmorg=kmUserService.getOrgInfoByOrgcode(kmUser.getOrgCode());
//
//        if(kmorg==null){
//            logginLogger.error("IP:" + ipAddress + ",人员的部门为空,org_code=="+kmUser.getOrgCode());
//        }else{
//            request.getSession().setAttribute(SystemConstants.SESSION_PS_DEPTCODE, kmorg.getDcOrgCode());
//            request.getSession().setAttribute(SystemConstants.SESSION_PS_DEPTPATH, kmorg.getDcPath());
//        }
//
//        sysLoginLogService.insertSysLogin(userId, ipAddress, SystemConstants.SYS_LOGIN_LOG_TYPE_PROXY);
//        logginLogger.info("IP:" + ipAddress + ",登录成功 account:" + kmUser.getAccount() + ",loginType:" + SystemConstants.SESSION_LOGIN_TYPE_PROXY);
//
//
//        Cookie cookie = new Cookie("curaccount", userId.replaceAll(" ",""));
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        Map<String, String> payload = new HashMap<>();
//        payload.put("userAccount", userId);
//        payload.put("userChName", kmUser.getChName());
//        String jwtToken = JwtUtil.getToken(payload);
//        Cookie cookieToken = new Cookie("PDM-Token", jwtToken);
//        cookieToken.setPath("/");
//        cookieToken.setDomain("jsfund.cn");
//        response.addCookie(cookieToken);
//
//        status.setStatusCode(SystemConstants.RETURN_CODE_SUCCESS);
//        status.setStatusMsg("登录成功: userId = [" + userId + ']');
//
//        String jsessionId = request.getSession().getId();
//        status.setData(jsessionId);
//        return status;
//    }
//
//
//
//    @RequestMapping(value="/logout")
//    @ResponseBody
//    public Boolean logout(HttpServletRequest request){
//        String userId = UserInfoHelper.getUserId(request);
//        request.getSession().removeAttribute(SystemConstants.SESSION_USERID);
//        request.getSession().removeAttribute(SystemConstants.SESSION_USERNAME);
//        request.getSession().removeAttribute(SystemConstants.SESSION_DEPTNAME);
//        request.getSession().removeAttribute(SystemConstants.SESSION_DEPTCODE);
//        request.getSession().removeAttribute(SystemConstants.SESSION_EMP_NO);
//        request.getSession().removeAttribute(SystemConstants.SESSION_DC_DEPTCODE);
//        request.getSession().removeAttribute(SystemConstants.SESSION_DC_COMPANY);
//        request.getSession().removeAttribute(SystemConstants.SESSION_USER_EMAIL);
//        request.getSession().removeAttribute(SystemConstants.SESSION_LOGIN_TYPE);
//        logginLogger.info("IP:" + NetworkUtil.getIpAddress(request) + ",注销成功： [" + userId + "]");
//        return true;
//    }
}
