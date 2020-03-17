package com.mzxf.cluser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author china.fuyao@outlook.com
 * @since 2020-03-16
 */
public class TlUser extends Model<TlUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String nick;

    /**
     * 头像
     */
    private String headPort;

    /**
     * 积分
     */
    private Integer integory;

    /**
     * 余额(单位分)
     */
    private Integer balance;

    /**
     * 等级
     */
    private Integer grade;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHeadPort() {
        return headPort;
    }

    public void setHeadPort(String headPort) {
        this.headPort = headPort;
    }

    public Integer getIntegory() {
        return integory;
    }

    public void setIntegory(Integer integory) {
        this.integory = integory;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "TlUser{" +
        "userId=" + userId +
        ", phone=" + phone +
        ", password=" + password +
        ", nick=" + nick +
        ", headPort=" + headPort +
        ", integory=" + integory +
        ", balance=" + balance +
        ", grade=" + grade +
        "}";
    }
}
