package com.mochen.auth.common.contanst;

/**
 * 通用常量
 *
 * @author 刘雪
 * @since 2021/12/30 17:02:46
 */
public class CommonConstant {

    // 阿里云实名认证模板
    public static final String CERTIFICATE_SMS_TEMPLATE = "SMS_228016640";
    // Token过期时间
    public static final long TOKEN_EXPIRATION = 1000L * 60 * 60 * 24 * 365 * 100;
    // 泉城e学appid
    public static final String MAJOR_APP_ID = "wxb291a3f172390304";
    // 泉城e学appSecret
    public static final String MAJOR_APP_SECRET = "3b8c30197a8af2173b863cac4f3b799b";
    // 词霸召集令appid
    public static final String ENGLISH_APP_ID = "wxe5af72207b5e9ea0";
    // 诗词群英会appid
    public static final String POETRY_APP_ID = "wx5cf989a8eb8c4131";

    // 统一授权地址
    public static final String AGENT_URL = "https://gateway.eduplatform.cn/mp/agent";
    // 统一授权回掉地址
    public static final String CALLBACK_URL = "https://gateway.eduplatform.cn/mp/callback1";

    // 获取普通access_token地址
    public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";
    // 凭据获取地址
    public static final String GET_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    //php封装getCode的url
    public static final String GET_CODE_URL = "http://mp.yuezhix.com/get-weixin-code.php";
    //获取授权access_token的url
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

}
