package com.allianz.pa.common.consant;

import java.util.HashMap;
import java.util.Map;

import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementBody;
import com.allianz.pa.dto.request.policyconfirm.group.GPConfirmBody;
import com.allianz.pa.dto.request.policyconfirm.op.OPConfirmBody;
import com.allianz.pa.service.impl.GroupPolicyEndorsementServiceImpl;
import com.allianz.pa.service.impl.PolicyCheckServiceImpl;
import com.allianz.pa.service.impl.PolicyServiceImpl;

public class PolicyConst {
	public static final String APPNAME="ePolicy";
	public final static String ENCODING = "UTF-8";
	public static final String JSON_CONTENT_TYPE = "application/json; charset=UTF-8";
	public static final String HTML_CONTENT_TYPE = "text/html; charset=UTF-8";
	public static final String TRUE = "1";
	public static final String FALSE = "0";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final Integer PCK_RESULT_SUCCESS = 0;
	public static final Integer ONE = 1;
	
	public static final String CHANGE_DESC = "修改被保险人";
    public static final String CHANGE_FLAG = "C";
    public static final String DELETE_FLAG = "D";
    public static final String ADDED_FLAG = "A";
    public static final String UPDATE_FLAG = "U";
    public static final Integer PartitionNo = 1;
    public static final String PATHSEPARTOR = "/";
    
    public static final String RMB = "RMB";
    public final static String PASSWORD_KEY = "AZCN-ZM";
    public final static String REMOTE_ADDRESS = "REMOTE_ADDRESS";
    public static final String APP_IG_EPOLICY = "IG_ePolicy";
    public final static Map<String, String> referCommentsMap = new HashMap<String, String>();
    
    static {
    	referCommentsMap.put(QueryBranch.GD.value, QueryBranch.GDREFER.value);
    	referCommentsMap.put(QueryBranch.SH.value, QueryBranch.SHREFER.value);
    }
	public enum RoleTypeStr {
		PHI("PHI"), 
		AGN("AGN"), 
		PRP("PRP");

		public final String value;

		RoleTypeStr(String value) {
			this.value = value;
		}
	}

	public enum RoleTypeInt {
		PHI_IPNO(1), 
		PRP_IPNO(2), 
		AGN_IPNO(3);

		public final Integer value;

		RoleTypeInt(Integer value) {
			this.value = value;
		}
	}
    public static interface PolicyHolderType{
        public static final String PERSONAL="I";
        public static final String ENTERPRISE="C";
    }

    /**
     * 证件类型 1-身份证 2-护照 3-其他
     */
	public static interface IdType {
		public static final String IDENTITY = "1";
		public static final String PASSPORT = "2";
		public static final String OTHER = "3";
	}
	
    /**
     * 性别 M-男性 F-女性 O-未知
     */
	public static interface Gender {
		public static final String MALE = "M";
		public static final String FEMALE = "F";
		public static final String UNKNOWN = "O";
	}
    
    public enum PremiumCalMethod { 
        Period("1"),    //按区间计算
        Day("2"),       //按天计算
        Month("3"),     //按月计算
        Year("4"),      //按年计算
        Rate("5"),      //按比例计算
        Term("6"),      //按短期费率计算
        NewYear("7"),   //按年计算新
        YearForPet("8");//按年计算(宠物)
        public String value;

        PremiumCalMethod(String value) {
            this.value = value;
        }
    }
    
    public enum QueryBranch {
        GD("1"),
        SH("2"),
        
        GDREFER("B"),
        SHREFER("C");
        public String value;

        QueryBranch(String value) {
            this.value = value;
        }
    }
    /**
     * 登录错误代码
     */
    public enum LogOnError {
        success("0"),
        successButOutDate("1"),
        errorUserOrPass("2"),
        userOrPassOutDate("3"),
        userLocked("4"),
        error("-1");
        public final String value;

        LogOnError(String value) {
            this.value = value;
        }
    }
    public enum ErrorCode {
        SUCCESS("0000"),
        wrongRequest("1111"),
        notNull("0001"),
        wrongDateFormat("0002"),
        WrongUserCodeOrPassword("0003"),
        OutDateUserOrPassword("00031"),
        UserLocked("00032"),
        overlength("0004"),
        numberFormat("0005"),
        wrongEnum("0006"),
        noRecord("0007"),
        loginFail("0008"),
        DecryptionFail("0009"),
        noPower("9999"),
        systemerror("2222"),
        systemhandle("3333"),
        alreadyissue("1048"),
        elseerror("8888"),
        banknotnull("1064"),
        PolicyAlreadyCancel("1110"),
        Underwrite_blacklist("U4444");
        public final String value;
        ErrorCode(String value) {
            this.value = value;
        }
    }
    public enum SequenceList {
        INS_INSURED_ID("prl_part_plan_ins_ext_seq1"),
        RISK_RISK_ID("PRL_PART_PLAN_INS_RISK_ID_SEQ"),
        OTI_INS_INSURED_BEN_ID("prl_part_ins_ben_ext_seq"),
        OTI_INS_INSURED_EMG_ID("prl_part_ins_emg_ext_seq"),
        OTI_INS_INSURED_ID("prl_part_plan_ins_ext_seq");
        
        public String value;

        SequenceList(String value) {
            this.value = value;
        }
    }
    
    public static interface BeneficialType{
        public static final String LEGAL="1";  
        public static final String SYNPOSITION="2";
        public static final String SPLIT="3";
        public static final String PROPORTION="4";
    }
    
    public enum RequestState {
        success("1"),
        exception("0"),
        waiting("2");
        public final String value;
        RequestState(String value) {
            this.value = value;
        }
    }
    /**
     * 各类开关
     */
    public enum AppAarameterKey {
        RegExName("RegEx.Name"),
    	AllianzAccountPolicyCancel("AllianzAccount.PolicyCancel");
        
        public final String value;
        AppAarameterKey(String value) {
            this.value = value;
        }
    }
    /**
     * 请求类型
     */
    public static interface RequestType{
    	 public static final String REQ_TYPE_POLICYCONFIRM_OP ="JD01";
    	 public static final String REQ_TYPE_ENDORSEMENT_RISK_OP ="JD02";
    	 public static final String REQ_TYPE_POLICYCHECK_GROUP = "G001";
    	 public static final String REQ_TYPE_ENDORSEMENT_GROUP = "G002";
    	 public static final String REQ_TYPE_CONFIRMCHECK_GROUP = "G003";
    	 public static final String REQ_TYPE_CONFIRM_GROUP = "G004";
    }
    /*public enum RequestType {
        //Ehome
        REQ_TYPE_POLICYCONFIRM_EHOME("2002"),
        REQ_TYPE_POLICYSTATUSQUERY_EHOME("2003"),
        REQ_TYPE_POLICYCANCEL_EHOME("2004"),
        REQ_TYPE_POLICYQUERY_EHOME("2005"),
        REQ_TYPE_POLICYPRINT_EHOME("2006"),
        REQ_TYPE_ENDORSEMENT_AWP614("2007"),
        //OTI
        REQ_TYPE_POLICYCONFIRM_OTI("0002"),
        REQ_TYPE_POLICYSTATUSQUERY_OTI("0003"),
        REQ_TYPE_POLICYCANCEL_OTI("0004"),
        REQ_TYPE_POLICYQUERY_OTI("0005"),
        REQ_TYPE_POLICYPRINT_OTI("0006"),
        REQ_TYPE_ENDORSEMENT_ONEINSURED_OTI("0009"),
        REQ_TYPE_UNDERWRITE_OTI("1000"),
        REQ_TYPE_POLICYCANCEL_SETTLEMENT_OTI("0008"),
        REQ_TYPE_RENEWALPOLICYQUERY_OTI("1001"),
        REQ_TYPE_POLICYRENEWAL_OTI("1002"),
        REQ_TYPE_CALCULATE_PREMIUM_OTI("1003"),
        //PET
        REQ_TYPE_POLICYCONFIRM_PET("4001"),
        REQ_TYPE_POLICYCONFIRM_HAITAO("4002"),
        //团单
        REQ_TYPE_POLICYCONFIRM_GROUP("5001"),
        REQ_TYPE_ENDORSEMENT_GROUP("5002"),
        //Plan
        REQ_TYPE_AUTHORIZEDPLANQUERY("PT01"),
        REQ_TYPE_PLANDETAILQUERY("PT02"),
        REQ_TYPE_PLANCONFIRM("BC02"),
        REQ_TYPE_PREMQUERY("PT03"),
        //others eg.PartnerPortal
        REQ_TYPE_ACCOUNTCONFIRM("3001"),
        REQ_TYPE_AGENCYCONFIRM("3002"),
        REQ_TYPE_PLANASSIGNMENT("3003"),
        REQ_TYPE_ISSUEPOLICY("3004"),
        REQ_TYPE_CALCULATE_REFUNDPREMIUM("3005"),
        REQ_TYPE_INSTALLMENT_ORDER("3006"),
        
        //JD OP
        REQ_TYPE_POLICYCONFIRM_OP("JD01"),
        REQ_TYPE_ENDORSEMENT_RISK_OP("JD02");
        public final String value;

        RequestType(String value) {
            this.value = value;
        }
    }*/
    /**
     * function的返回值
     */
    public enum FunctionResult {
        success("0"),
        error("1"),
        error2("2"),
        error3("3");
        public final String value;

        FunctionResult(String value) {
            this.value = value;
        }
    }
    
    /**
     * CBCflag
     */
    public enum CBCFlag {
        noCBC("0"),
        CBC("1");
        public final String value;

        CBCFlag(String value) {
            this.value = value;
        }
    }
    
    public enum EndorsementType  {
        changePeriod("E01"),
        changePlan("E02"),
        changeDestination("E03"),
        changeInsured("E04"),
        changeHolder("E05"),
        changeAgency("E06"),
        changeAddress("E07"),
        changePolicyPeriodAmend("E08"),
        changeObject("E09"),
        cancle("E15"),
        cancleNoRefund("E16"),
        refund("E17"),
        internalAmend("E18");
        public String value;

        EndorsementType(String value) {
            this.value = value;
        }
    }
    
    public enum PolicyStatus {
        WIPPolicy(30),
        WaitForPay(60),
        InForce(70),
        CancelToBeCheck(75),
        Cancelled(80),
        Endorsement(35),
        EndorsementToBeCheck(40);
        public final Integer value;
        PolicyStatus(Integer value) {
            this.value = value;
        }
    }
    
    public enum SubProduct {
        Personal("593"),//个人意外保险
        Travel("594"),//旅行保险
        FlightDelay("595"),//航班延误保险
        Group("543"),
        EL("304"),
        Home("613"),
        Pet("614"),
        Health("520"),//个人医疗保险
        DamageWarrantyLiability("325"),//产品意外损坏保修责任保险 (325)
        ExtendedWarrantyLiability("326"),//产品延长保修责任保险 (326) 
        ReturnShipmentCostInsurance("903");//网络购物运费损失保险 (903)
        
        
        public String value;

        SubProduct(String value) {
            this.value = value;
        }
    }
    
	public static final HashMap<String, Class> RequestType4RequestBodyMap = new HashMap<String, Class>() {
        {  
            put(PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP, OPConfirmBody.class);
            put(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP, OPEndorsementBody.class);
            put(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP, EndorsementBody.class);
            put(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP, EndorsementBody.class);
            put(PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP, GPConfirmBody.class);
        }
    };
    
	public static final HashMap<String, Class> RequestType4ServiceBeanMap = new HashMap<String, Class>() {
        {  
            put(PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP, PolicyServiceImpl.class);
            put(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP, PolicyServiceImpl.class);
            put(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP, PolicyCheckServiceImpl.class);
            put(PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP, PolicyCheckServiceImpl.class);
            put(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP, GroupPolicyEndorsementServiceImpl.class);
        }
    };
    
}
