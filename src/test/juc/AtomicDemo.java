package test.juc;

import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author chenxiangge
 * @Date 2020/8/12
 */
class User {
    private String userName;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userName='" + userName + "'")
                .add("age=" + age)
                .toString();
    }
}

public class AtomicDemo {


    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User z3 = new User("z3", 18);
        User l4 = new User("l4", 19);

        atomicReference.set(z3);

        System.out.println("before change result:" + atomicReference.get().toString());

        System.out.println("first change result:" + atomicReference.compareAndSet(z3, l4) + " atomicResult:" + atomicReference.get().toString());
        System.out.println("second change result:" + atomicReference.compareAndSet(z3, l4) + " atomicResult:" + atomicReference.get().toString());
    }
}
