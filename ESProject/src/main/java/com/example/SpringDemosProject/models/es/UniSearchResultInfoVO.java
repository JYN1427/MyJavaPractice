package com.example.SpringDemosProject.models.es;

import com.example.SpringDemosProject.common.constants.ESConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-15 14:04:47
 */
@Data
@Accessors(chain = true)
@Document(indexName = ESConstant.CRM_SEARCH_MAINDATA_INXEX)
//@Builder //添加这个注解之后，反射获取字段异常，实例化失败
public class UniSearchResultInfoVO {

    // @ApiModelProperty(value = "ES索引数据主键ID")
    @Id
    @Field(type = FieldType.Keyword)
    private String uniEsId;

    // @ApiModelProperty(value = "索引数据类别 1-机构客户 2-渠道网点 3-账户组合 4-联系人 5-零售战役活动")
    @Field(type = FieldType.Keyword)
    private String uniDataType;

    // @ApiModelProperty(value = "索引子数据类别 1-机构客户实体 2-机构客户单元  3-账户 4-组合  5-机构客户联系人 6-渠道联系人  7-渠道网点 8-零售战役活动 ")
    @Field(type = FieldType.Keyword)
    private String uniSubDataType;

    //机构客户
    // @ApiModelProperty(value = "客户实体名称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String custEntityName;

    // @ApiModelProperty(value = "客户实体简称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String busEntitySubName;

    // @ApiModelProperty(value = "客户实体曾用名")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String busEntityFormerName;

    // @ApiModelProperty(value = "客户单元名称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String custUnitName;

    // @ApiModelProperty(value = "客户单元简称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String custUnitSubName;

    // @ApiModelProperty(value = "机构客户实体或单元缩写")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String custEntityOrUnitShortName;

    // @ApiModelProperty(value = "客户需求类型")
    private String custEntityClass;

    // @ApiModelProperty(value = "客户实体状态：(0-保护、1-竞争、2-停运)")
    private String custEntityStatus;

    // @ApiModelProperty(value = "客户实体状态中文：(0-保护、1-竞争、2-停运)")
    private String custEntityStatusName;

    // @ApiModelProperty(value = "客户归属部门(团队)")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String deptName;

    // @ApiModelProperty(value = "客户单元的主客户经理")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String employName;

    // @ApiModelProperty(value = "主客户经理id")
    @Field(type = FieldType.Keyword)
    private String employId;

    // @ApiModelProperty(value = "双计部门集合")
    private String dept24Name;

    // @ApiModelProperty(value = "三计部门集合")
    private String dept25Name;

    // @ApiModelProperty(value = "资产规模")
    @Field(type = FieldType.Double)
    private BigDecimal presAsset;

    // @ApiModelProperty(value = "本年规模变动")
    @Field(type = FieldType.Double)
    private BigDecimal yrNetin;

    // @ApiModelProperty(value = "本年收入")
    @Field(type = FieldType.Double)
    private BigDecimal yrIncome;

    // @ApiModelProperty(value = "近一周联系次数")
    @Field(type = FieldType.Integer)
    private Integer weekContactCount;

    // @ApiModelProperty(value = "最近一次联系时间(已转为天数)")
    private String lastContactTime;

    // @ApiModelProperty(value = "归属部门集合")
    @Field(type = FieldType.Keyword)
    private String limitDept21;

    // @ApiModelProperty(value = "竞争部门集合")
    @Field(type = FieldType.Keyword)
    private String limitDept22;

    // @ApiModelProperty(value = "拆分部门集合")
    @Field(type = FieldType.Keyword)
    private String limitDept23;

    // @ApiModelProperty(value = "双计部门集合")
    @Field(type = FieldType.Keyword)
    private String limitDept24;

    // @ApiModelProperty(value = "三计部门集合")
    @Field(type = FieldType.Keyword)
    private String limitDept25;

    // @ApiModelProperty(value = "归属个人集合")
    @Field(type = FieldType.Keyword)
    private String limitEmploy21;

    // @ApiModelProperty(value = "竞争个人集合")
    @Field(type = FieldType.Keyword)
    private String limitEmploy22;

    // @ApiModelProperty(value = "拆分个人集合")
    @Field(type = FieldType.Keyword)
    private String limitEmploy23;

    // @ApiModelProperty(value = "双计个人集合")
    @Field(type = FieldType.Keyword)
    private String limitEmploy24;

    // @ApiModelProperty(value = "三计个人集合")
    @Field(type = FieldType.Keyword)
    private String limitEmploy25;

    // @ApiModelProperty(value = "客户单元类型:0-公司 1-部门")
    private String custUnitType;

    // @ApiModelProperty(value = "客户单元类型名称:分公司 部门")
    private String custUnitTypeName;

    // @ApiModelProperty(value = "客户单元层级 0-实体")
    private String custUnitLevel;

    // @ApiModelProperty(value = "客户等级标签")
    private String custEntityLevelTag;

    // @ApiModelProperty(value = "特许经营标签")
    private String custEntityFranchiseTag;

    //渠道
    // @ApiModelProperty(value = "渠道id")
    @Field(type = FieldType.Keyword)
    private String channelId;

    // @ApiModelProperty(value = "网点全称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String vcSiteName;

    // @ApiModelProperty(value = "客户需求类型 默认渠道网点")
    private String custNeedType;

    // @ApiModelProperty(value = "网点类型代码")
    private String distributorType;

    // @ApiModelProperty(value = "网点类型（经销商类型 核心银行，潜力银行，潜力券商，核心券商等")
    private String distributorTypeName;

    // @ApiModelProperty(value = "归属部门名称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String vcDeptName;

    // @ApiModelProperty(value = "归属渠道经理")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String vcEmployName;

    // @ApiModelProperty(value = "网点等级")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String gradeName;

    // @ApiModelProperty(value = "渠道网点-最近联系时间(已转为天数)")
    private String dLastofflineDate;

    // @ApiModelProperty(value = "渠道网点-最近联系人")
    private String recentContactor;

    // @ApiModelProperty(value = "业务单元")
    @Field(type = FieldType.Keyword)
    private String vcUnit;

    // @ApiModelProperty(value = "部门ID")
    @Field(type = FieldType.Keyword)
    private String lDeptId;

    // @ApiModelProperty(value = "是否是最底层网点（没有下级）")
    @Field(type = FieldType.Keyword)
    private String cLevel;

    // @ApiModelProperty(value = "KA部门ID")
    @Field(type = FieldType.Keyword)
    private String lKaDeptid;

    // @ApiModelProperty(value = "渠道业绩查看-部门ID")
    @Field(type = FieldType.Keyword)
    private String lChannellookDeptId;


    //账户
    // 查询账户实体

    // @ApiModelProperty(value = "账户id/组合编码")
    @Field(type = FieldType.Keyword)
    private String idKey;

    // @ApiModelProperty(value = "账户名称/组合简称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String name;

    // @ApiModelProperty(value = "组合全称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String portfFullName;

    // @ApiModelProperty(value = "账户 或 组合类型")
    private String type;

    // @ApiModelProperty(value = "销售商名称(开户渠道)  使用：账户查询 联系人查询")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String distributorName;

    // @ApiModelProperty(value = "组合状态（成立，运维，终止）")
    private String portfStatus;

    // @ApiModelProperty(value = "客户单元id")
    @Field(type = FieldType.Keyword)
    private String custUnitId;

    // @ApiModelProperty(value = "客户实体ID")
    @Field(type = FieldType.Keyword)
    private String custEntityId;

    // @ApiModelProperty(value = "累计损益")
    @Field(type = FieldType.Double)
    private BigDecimal ttlRet;

    // @ApiModelProperty(value = "累计净值")
    @Field(type = FieldType.Double)
    private BigDecimal ttlNav;

    // @ApiModelProperty(value = "更新日期")
    //@Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private String busiDate;

    // @ApiModelProperty(value = "净值日期")
    //@Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private String navDate;

    // @ApiModelProperty(value = "拆分签报数量")
    private String splitNum;

    // @ApiModelProperty(value = "组合管理人")
    private String actPartyName;

    // @ApiModelProperty(value = "拆分级别")
    private String splitClass;

    // @ApiModelProperty(value = "基金账号")
    @Field(type = FieldType.Keyword)
    private String fundAcco;

    // @ApiModelProperty(value = "交易账号")
    @Field(type = FieldType.Keyword)
    private String tradeAcco;

    // @ApiModelProperty(value = "账户证件号码")
    @Field(type = FieldType.Keyword)
    private String certNo;

    // @ApiModelProperty(value = "账户证件类型")
    private String certType;

    // @ApiModelProperty(value = "账户证件类型中文")
    private String certTypeName;

    //4-联系人
    // @ApiModelProperty(value = "联系人Id")
    private String contactorId;

    // @ApiModelProperty(value = "联系人姓名")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
//    @Field(type = FieldType.Keyword)
    private String contactorName;

    // @ApiModelProperty(value = "联系人职位")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String contactorRank;

    // @ApiModelProperty(value = "注册alpha嘉油站 1-已注册")
    private String registerAlpha;

    // @ApiModelProperty(value = "联系人职位等级（理财经理等级）")
    private String rankLevel;

    // @ApiModelProperty(value = "联系人手机号")
    @Field(type = FieldType.Text)
    private String mobile;

    // @ApiModelProperty(value = "创建者本人")
    private String creator;

    // @ApiModelProperty(value = "创建者部门")
    private String creatorDeptName;

    // @ApiModelProperty(value = "创建者部门id")
    @Field(type = FieldType.Keyword)
    private String creatorDeptId;

    // @ApiModelProperty(value = "部门id")
    @Field(type = FieldType.Keyword)
    private String deptId;

    // @ApiModelProperty(value = "联系人类别 CUST-客户 CHANNEL-渠道")
    @Field(type = FieldType.Keyword)
    private String substanceType;

    // @ApiModelProperty(value = "联系人类别名称 CUST-客户 CHANNEL-渠道")
    @Field(type = FieldType.Keyword)
    private String substanceTypeName;

    // @ApiModelProperty(value = "注册alpha嘉油站 1-已注册")
    private String isRegisterAlpha;

    // @ApiModelProperty(value = "是否理财经理 0-不是 1-是")
    private String isFinManager;

    // @ApiModelProperty(value = "经销商代码")
    @Field(type = FieldType.Keyword)
    private String distributorCode;

    // @ApiModelProperty(value = "渠道实体id")
    @Field(type = FieldType.Keyword)
    private String entryId;

    // @ApiModelProperty(value = "渠道各实体Id ")
    @Field(type = FieldType.Keyword)
    private String substanceId;


    // -----------渠道联系人/start

    // @ApiModelProperty(value = "机构客户业绩双计部门")
    @Field(type = FieldType.Keyword)
    private String lPerfDooubleDeptid;

    // @ApiModelProperty(value = "业绩三计部门")
    @Field(type = FieldType.Keyword)
    private String lPerfThreeDeptid;

    // @ApiModelProperty(value = "是否入公海池,1-是,0-否")
    @Field(type = FieldType.Keyword)
    private String cIsHighSeaPool;

    // @ApiModelProperty(value = "体系编码")
    @Field(type = FieldType.Keyword)
    private String vcSystemCode;

    // @ApiModelProperty(value = "创建渠道部门id")
    @Field(type = FieldType.Keyword)
    private String lCreateDeptid;

    // @ApiModelProperty(value = "渠道经理id")
    @Field(type = FieldType.Keyword)
    private String lEmployid;

    // @ApiModelProperty(value = "网点简称")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String substanceName;

    // @ApiModelProperty(value = "信息是否完整")
    private String isMessageWhole;

    // @ApiModelProperty(value = "纬度")
    private String longitude;

    // @ApiModelProperty(value = "经度")
    private String latitude;

    // @ApiModelProperty(value = "理财经理等级")
    private String finGrade;

    // @ApiModelProperty(value = "网点等级")
    private String channelGrade;

    // @ApiModelProperty(value = "网点地址")
    private String address;

    // @ApiModelProperty(value = "是否网点层级根节点")
    private String isChannelHead;

    // @ApiModelProperty(value = "管理等级，字典：1415(1-一级分行/2-二级分行)")
    private String manageGrade;

    // @ApiModelProperty(value = "是否关键人,1-是,0-否")
    private String isKeyPer;

    // -----------渠道联系人/end

    //-----------账户数据/start
    // @ApiModelProperty(value = "柜台客户经理ID")
    @JsonProperty("lCounterEmployid")
    private String lCounterEmployid;

    // @ApiModelProperty(value = "柜台客户经理部门ID")
    @JsonProperty("lCounterDeptid")
    private String lCounterDeptid;

    // @ApiModelProperty(value = "是否关联到客户：0-否，1-是")
    private String cIsRelaCust;

    // @ApiModelProperty(value = "拆分部门集合")
    private String splitDeptid;


    // @ApiModelProperty(value = "21归属权限部门中文集合")
    private String deptName21;

    // @ApiModelProperty(value = "22竞争权限部门中文集合")
    private String deptName22;

    // @ApiModelProperty(value = "23拆分权限部门中文集合")
    private String deptName23;

    // @ApiModelProperty(value = "24双计权限部门中文集合")
    private String deptName24;

    // @ApiModelProperty(value = "25三计权限部门中文集合")
    private String deptName25;

    // @ApiModelProperty(value = "是否是活跃客户 1-是 0-否")
    private String isActive;

    // @ApiModelProperty(value = "客户实体的单元id")
    private String custEntityUnitId;

    // @ApiModelProperty(value = "不同权限部门中文列表")
    private List<Map<String,String>> limitArrays;

    // 页面展示操作权限控制
    // @ApiModelProperty(value = "是否查看详情的权限 ")
    private Boolean viewDetail;

    // @ApiModelProperty(value = "跟进状态 1-取消跟进 2-跟进 （客户实体）")
    private String followUp;

    // @ApiModelProperty(value = "申请调整部门归属 1-可申请 （客户实体）")
    private String adjustBelongTo;

    // @ApiModelProperty(value = "申请调整客户经理  1-可申请（客户实体）")
    private String adjustCustManager;

    // @ApiModelProperty(value = "机构客户数据第三行是否显示 1-显示")
    private String isViewThirdLine;

    // @ApiModelProperty(value = "客户竞争状态下竞争团队数量")
    private String competeDeptCount;

    // @ApiModelProperty(value = "联系人完整手机号")
    private String mobileFullNum;


    // --  5-零售战役活动
    // @ApiModelProperty(value = "campaignId")
    private String campaignId;

    // @ApiModelProperty(value = "campaignName")
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String campaignName;

    // @ApiModelProperty(value = "ageny")
    private String ageny;

    // @ApiModelProperty(value = "publishDate")
    private String publishDate;

    // @ApiModelProperty(value = "finishDate")
    private String finishDate;

    // @ApiModelProperty(value = "campaignType")
    private String campaignType;

    // @ApiModelProperty(value = "publishType")
    private String publishType;

    // @ApiModelProperty(value = "campaignAimAmtAll")
    private String campaignAimAmtAll;

    // @ApiModelProperty(value = "campaignInAmtAll")
    private String campaignInAmtAll;

    // @ApiModelProperty(value = "completePercentAll")
    private String completePercentAll;

    // @ApiModelProperty(value = "campaignDeptId")
    private String campaignDeptId;

}

