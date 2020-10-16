package test.java8.vo;

/**
 * @Author chenxiangge
 * @Date 2020/7/10
 */
public class TestVo {
    private Integer maxCapacity;
    private double speed;
    private String name;

    public TestVo() {
    }

    public TestVo(Integer maxCapacity, double speed) {
        this.maxCapacity = maxCapacity;
        this.speed = speed;
    }

    public TestVo(Integer maxCapacity, double speed, String name) {
        this.maxCapacity = maxCapacity;
        this.speed = speed;
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

