package test.test;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @Author chenxiangge
 * @Date 2020/7/8
 */
public class Constants {

    /**
     * 常量
     */
    public static final String CLAM_SP = "sp_1";
    public static final String CRAB_SP = "sp_2";
    public static final String OCTOPUS_SP = "sp_3";
    public static final String TABLE_EXCHANGE = "exchange";
    public static final String TABLE_INVITE = "invite";
    public static final int SIGN_CYCLE_PERIOD = 5;
    public static final int MAX_RANK_LEVEL = 5;
    public static final int MIN_RANK_LEVEL = 1;
    public static final String PRIZE_THANKS = "thanks";
    public static final BigDecimal SECONDS_HOUR = new BigDecimal(3600);


    public static final int CURRENT_RANK_INDEX = 0;
    public static final int PRE_RANK_INDEX = 1;

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DATE_WEEK_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATE_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");


    /**
     * 生成邀请码字符串
     */
    public static final String RANDOM_NUMBER_STR = "0123456789";
    public static final Random RANDOM = new Random();

    /**
     * 需要验证白名单的任务类型
     */
    public static final int WHITE_LIST_TASK_TYPE = 5;

    /**
     * 绑定邀请码分布式key
     */
    public static final String BIND_KEY = "bindKey_";


    /**
     * 任务完成状态
     * 0-未完成
     * 1-已完成-未领取奖励
     * 2-已领取奖励
     */
    public static final int TASK_STATUS_INIT = 0;
    public static final int TASK_STATUS_FINISH = 1;
    public static final int TASK_STATUS_AWARD = 2;

    /**
     * kv值
     */
    public static final String KV_SIGN_AWARD = "signAward_";
    public static final String KV_TASK_STATUS = "taskStatus_";
    public static final String KV_DAILY_FIRST_ENTER = "dailyFirstEnter_";

    /**
     * userdata
     */
    public static final String UD_IS_FIRST_TIME = "isFirstTime";
    public static final String UD_IS_BIND = "isBind";
    public static final String UD_INVITE_COUNT = "inviteCount";
    public static final String UD_UPGRADE = "upgrade";
    public static final String UD_CLAM_TIME = "clamTime";
    public static final String UD_CRAB_TIME = "crabTime";
    public static final String UD_OCTOPUS_TIME = "octopusTime";


    /**
     * 运营配置项名称start
     */
    public static final String SIGN_AWARDS = "signAwards";
    public static final String TASK_CONFIG = "taskConfig";
    public static final String CRAB_GROW_TIME = "crabGrowTime";
    public static final String OCTOPUS_GROW_TIME = "octopusGrowTime";
    public static final String SHARE_TITLE = "shareTitle";
    public static final String SHARE_SUB_TITLE = "shareSubTitle";
    public static final String SHARE_PIC = "sharePic";
    public static final String RANK_CONFIG = "rankConfig";
    public static final String EXCHANGE_CONFIG = "exchangeConfig";
    public static final String APP_ID = "appId";
    public static final String  EXCHANGE_END_TIME = "exchangeEndTime";
    /**
     * 运营配置项名称end
     */


}
