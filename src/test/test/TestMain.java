package test.test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author chenxiangge
 * @Date 2020/7/22
 */
class PrizeVo {
    /**
     * 配置的奖品id
     */
    private String prizeId;
    /**
     * 奖品类型
     */
    private Integer prizeType;

    public PrizeVo(String prizeId, Integer prizeType) {
        this.prizeId = prizeId;
        this.prizeType = prizeType;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }
}

public class TestMain {


    public static void main(String[] args) {

        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid.length());
//        PrizeVo prizeVo1 = new PrizeVo("thanks", 1);
//        PrizeVo prizeVo2 = new PrizeVo("0", 1);
//        List<PrizeVo> prizeVos = new ArrayList<>();
//        prizeVos.add(prizeVo1);
//        prizeVos.add(prizeVo2);

        String hi="中文";
        String hi2="hi";

//        List<PrizeVo> notThanksList = prizeVos.stream().filter(o -> !o.getPrizeId().equals(Constants.PRIZE_THANKS)).limit(1).collect(Collectors.toList());


    }

}
