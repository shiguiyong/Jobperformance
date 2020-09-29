package com.xiuxiu.pojo;

/**
 * @author stone
 * @date 2020/9/29 002910:48
 */
public class WechatInfo {
    private String headimgurl;
    private String name;
    private	int	sex;
    private	String	province;
    private	String	city;
    private	String	country;

    @Override
    public String toString() {
        return "WechatInfo{" +
                "headimgurl='" + headimgurl + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
