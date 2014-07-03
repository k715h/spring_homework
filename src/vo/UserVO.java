package vo;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 1:58
 * To change this template use File | Settings | File Templates.
 */
public class UserVO extends VO {

    private String userName;
    private String nickName;
    private int age;
    private String address;

    public UserVO(){}

    public UserVO(String userName, String nickName, int age, String address) {
        this.userName = userName;
        this.nickName = nickName;
        this.age = age;
        this.address = address;
    }
    public UserVO(Long id, String userName, String nickName, int age, String address) {
        setId(id);
        this.userName = userName;
        this.nickName = nickName;
        this.age = age;
        this.address = address;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
