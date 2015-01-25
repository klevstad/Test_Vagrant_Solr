package server;

import org.apache.solr.client.solrj.beans.Field;

public class NsfDocument {
	
	@Field("id")
	private int m_id;
	@Field
	private String m_title;
	@Field
	private String m_type;
	@Field
	private String m_nsf_org;
	@Field
	private String m_latest_amendment_date;
	@Field
	private String m_file;
	@Field
	private String m_award_number;
	@Field
	private String m_award_instr;
	@Field
	private String m_prgm_manager;
	@Field
	private String m_start_date;
	@Field
	private String m_expires;
	@Field
	private String m_expected_total_amt;
	@Field
	private String m_investigator;
	@Field
	private String m_sponsor;
	@Field
	private String m_nsf_program;
	@Field
	private String m_fld_applictn;
	@Field
	private String m_program_ref;
	@Field
	private String m_abstract;
	
	public static final String TITLE = "Title";
	public static final String TYPE = "Type";
	public static final String NSF_ORG = "NSF Org";
	public static final String LATEST_AMENDMENT_DATE = "Latest Amendment Date";
	public static final String FILE = "File";
	public static final String AWARD_NUMBER = "Award Number";
	public static final String AWARD_INSTR = "Award Instr.";
	public static final String PRGM_MANAGER = "Prgm Manager";
	public static final String START_DATE = "Start Date";
	public static final String EXPIRES = "Expires";
	public static final String EXPECTED_TOTAL_AMT = "Expected Total Amt.";
	public static final String INVESTIGATOR = "Investigator";
	public static final String SPONSOR = "Sponsor";
	public static final String NSF_PROGRAM = "NSF Program";
	public static final String FLD_APPLICTN = "Fld Applictn";
	public static final String PROGRAM_REF = "Program Ref";
	public static final String ABSTRACT = "Abstract";
	
	
	
	public NsfDocument() {
		this.m_title = "";
		this.m_type = "";
		this.m_nsf_org = "";
		this.m_latest_amendment_date = "";
		this.m_file = "";
		this.m_award_number = "";
		this.m_award_instr = "";
		this.m_prgm_manager = "";
		this.m_start_date = "";
		this.m_expires = "";
		this.m_expected_total_amt = "";
		this.m_investigator = "";
		this.m_sponsor = "";
		this.m_nsf_program = "";
		this.m_fld_applictn = "";
		this.m_program_ref = "";
		this.m_abstract = "";
	}
	
	
	public void mapToNsfDocumentObject(String property, String value){
		switch(property){
		case TITLE:
			this.setM_title(value);
			break;
		case TYPE:
			this.setM_type(value);
			break;
		case NSF_ORG:
			this.setM_nsf_org(value);
			break;
		case LATEST_AMENDMENT_DATE:
			this.setM_latest_amendment_date(value);
			break;
		case FILE:
			this.setM_file(value);
			break;
		case AWARD_NUMBER:
			this.setM_award_number(value);
			break;
		case AWARD_INSTR:
			this.setM_award_instr(value);
			break;
		case PRGM_MANAGER:
			this.setM_prgm_manager(value);
			break;
		case START_DATE:
			this.setM_start_date(value);
			break;
		case EXPIRES:
			this.setM_expires(value);
			break;
		case EXPECTED_TOTAL_AMT:
			this.setM_expected_total_amt(value);
			break;
		case INVESTIGATOR:
			this.setM_investigator(value);
			break;
		case SPONSOR:
			this.setM_sponsor(value);
			break;
		case NSF_PROGRAM:
			this.setM_nsf_program(value);
			break;
		case FLD_APPLICTN:
			this.setM_fld_applictn(value);
			break;
		case PROGRAM_REF:
			this.setM_program_ref(value);
			break;
		case ABSTRACT:
			this.setM_abstract(value);
			break;
		}
			
	}
	

	public String getM_title() {
		return m_title;
	}


	public void setM_title(String m_title) {
		this.m_title = m_title;
	}


	public String getM_type() {
		return m_type;
	}


	public void setM_type(String m_type) {
		this.m_type = m_type;
	}


	public String getM_nsf_org() {
		return m_nsf_org;
	}


	public void setM_nsf_org(String m_nsf_org) {
		this.m_nsf_org = m_nsf_org;
	}


	public String getM_latest_amendment_date() {
		return m_latest_amendment_date;
	}


	public void setM_latest_amendment_date(String m_latest_amendment_date) {
		this.m_latest_amendment_date = m_latest_amendment_date;
	}


	public String getM_file() {
		return m_file;
	}


	public void setM_file(String m_file) {
		this.m_file = m_file;
	}


	public String getM_award_number() {
		return m_award_number;
	}


	public void setM_award_number(String m_award_number) {
		this.m_award_number = m_award_number;
	}


	public String getM_award_instr() {
		return m_award_instr;
	}


	public void setM_award_instr(String m_award_instr) {
		this.m_award_instr = m_award_instr;
	}


	public String getM_prgm_manager() {
		return m_prgm_manager;
	}


	public void setM_prgm_manager(String m_prgm_manager) {
		this.m_prgm_manager = m_prgm_manager;
	}


	public String getM_start_date() {
		return m_start_date;
	}


	public void setM_start_date(String m_start_date) {
		this.m_start_date = m_start_date;
	}


	public String getM_expires() {
		return m_expires;
	}


	public void setM_expires(String m_expires) {
		this.m_expires = m_expires;
	}


	public String getM_expected_total_amt() {
		return m_expected_total_amt;
	}


	public void setM_expected_total_amt(String m_expected_total_amt) {
		this.m_expected_total_amt = m_expected_total_amt;
	}


	public String getM_investigator() {
		return m_investigator;
	}


	public void setM_investigator(String m_investigator) {
		this.m_investigator = m_investigator;
	}


	public String getM_sponsor() {
		return m_sponsor;
	}


	public void setM_sponsor(String m_sponsor) {
		this.m_sponsor = m_sponsor;
	}


	public String getM_nsf_program() {
		return m_nsf_program;
	}


	public void setM_nsf_program(String m_nsf_program) {
		this.m_nsf_program = m_nsf_program;
	}


	public String getM_fld_applictn() {
		return m_fld_applictn;
	}


	public void setM_fld_applictn(String m_fld_applictn) {
		this.m_fld_applictn = m_fld_applictn;
	}


	public String getM_program_ref() {
		return m_program_ref;
	}


	public void setM_program_ref(String m_program_ref) {
		this.m_program_ref = m_program_ref;
	}


	public String getM_abstract() {
		return m_abstract;
	}


	public void setM_abstract(String m_abstract) {
		this.m_abstract = m_abstract;
	}

}
