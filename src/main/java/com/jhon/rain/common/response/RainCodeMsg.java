package com.jhon.rain.common.response;

import lombok.Getter;

/**
 * <p>功能描述</br>错误码和错误消息的定义</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-seckill
 * @date 2018/2/7 9:23
 */
public class RainCodeMsg {

  /**
   * 返回码
   */
  @Getter
  private int code;
  /**
   * 返回消息
   */
  @Getter
  private String msg;
  /**
   * 通用的错误码
   **/
  public static RainCodeMsg SUCCESS = new RainCodeMsg(0, "success");
  /**
   * 校验错误码
   **/
  public static RainCodeMsg BIND_ERROR = new RainCodeMsg(500100, "参数校验异常：%s");

  /**
   * 系统繁忙，请稍后再试
   **/
  public static RainCodeMsg SERVER_ERROR = new RainCodeMsg(500900, "系统繁忙，请稍后再试！");

  /**
   * 手机号不存在
   **/
  public static final RainCodeMsg MOBILE_NOT_EXIST = new RainCodeMsg(100100, "手机号不存在");

  /**
   * Session不存在或者已经失效
   **/
  public static final RainCodeMsg SESSION_ERROR = new RainCodeMsg(5001001, "Session不存在或者已经失效");

  /**
   * 访问太频繁
   **/
  public static final RainCodeMsg ACCESS_LIMIT_REACHED = new RainCodeMsg(5001002, "访问太频繁");

  /**
   * 密码错误
   **/
  public static final RainCodeMsg PASSWORD_ERROR = new RainCodeMsg(1001001, "密码错误");

  private RainCodeMsg() {
  }

  private RainCodeMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public RainCodeMsg fillArgs(Object... args) {
    int code = this.code;
    String message = String.format(this.msg, args);
    return new RainCodeMsg(code, message);
  }
}
