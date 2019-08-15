package yy.demo.demo1.base.emnu;

/**
 * 状态结果枚举
 * @author yinmb
 * @Date 2019/4/1 15:12:15
 */
public enum ZLJRBidStatus {

    /**
     * 申请成功
     */
    BID_SUCCESS("000","申请成功"),
    /**
     * 申请处理中
     */
    BID_PROCESSING( "001", "申请处理中" ),
    /**
     * 申请拒绝
     */
    BID_REFUSE( "002", "申请拒绝" ),
    /**
     * 申请失败
     */
    BID_FAIL("003","申请失败"),
    /**
     * 未提交申请
     */
    BID_UNCOMMITTED("004","未提交申请"),
    /**
     * 申请编号有误
     */
    BID_APPLYNO_WRONG("005","申请编号有误"),

    /**
     * 提交申请成功
     */
    BID_COMMITTED_SUCCESS("006","提交申请成功"),

    /**
     * 提交申请失败
     */
    BID_COMMITTED_FAIL("007","提交申请失败");

    public final String name;
    public final String value;
    ZLJRBidStatus(String value, String name) {
		this.name = name;
		this.value = value;
    }

}
