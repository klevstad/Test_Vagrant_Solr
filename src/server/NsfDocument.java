package server;

import org.apache.solr.client.solrj.beans.Field;

public class NsfDocument {
	
	@Field("id")
	private int m_id;
	@Field
	private String title;
	//@Field
	private String _type;
	@Field
	private String nsf_org;
	@Field
	private String latest_amendment_date;
	@Field
	private String file;
	@Field
	private String award_number;
	@Field
	private String award_instr;
	@Field
	private String prgm_manager;
	@Field
	private String start_date;
	@Field
	private String expires;
	@Field
	private String expected_total_amt;
	@Field
	private String investigator;
	@Field
	private String sponsor;
	@Field
	private String nsf_program;
	@Field
	private String fld_applictn;
	@Field
	private String program_ref;
	@Field
	private String _abstract;
	
	//public static final String TITLE = "Title";
	//public static final String TYPE = "Type";
	//public static final String NSF_ORG = "NSF Org";
	//public static final String LATEST_AMENDMENT_DATE = "Latest Amendment Date";
	//public static final String FILE = "File";
	//public static final String AWARD_NUMBER = "Award Number";
	//public static final String AWARD_INSTR = "Award Instr.";
	//public static final String PRGM_MANAGER = "Prgm Manager";
	//public static final String START_DATE = "Start Date";
	//public static final String EXPIRES = "Expires";
	//public static final String EXPECTED_TOTAL_AMT = "Expected Total Amt.";
	//public static final String INVESTIGATOR = "Investigator";
	//public static final String SPONSOR = "Sponsor";
	//public static final String NSF_PROGRAM = "NSF Program";
	//public static final String FLD_APPLICTN = "Fld Applictn";
	//public static final String PROGRAM_REF = "Program Ref";
	//public static final String ABSTRACT = "Abstract";
	
	public NsfDocument() {
	}
	
	public void mapToNsfDocumentObject(String property, String value){
		switch(property){
		case "Title":
			this.setM_title(value);
			break;
		case "Type":
			this.setM_type(value);
			break;
		case "NSF Org":
			this.setM_nsf_org(value);
			break;
		case "Latest Amendment Date":
			this.setM_latest_amendment_date(value);
			break;
		case "File":
			this.setM_file(value);
			break;
		case "Award Number":
			this.setM_award_number(value);
			break;
		case "Award Instr.":
			this.setM_award_instr(value);
			break;
		case "Prgm Manager":
			this.setM_prgm_manager(value);
			break;
		case "Start Date":
			this.setM_start_date(value);
			break;
		case "Expires":
			this.setM_expires(value);
			break;
		case "Expected Total Amt.":
			this.setM_expected_total_amt(value);
			break;
		case "Investigator":
			this.setM_investigator(value);
			break;
		case "Sponsor":
			this.setM_sponsor(value);
			break;
		case "NSF Program":
			this.setM_nsf_program(value);
			break;
		case "Fld Applictn":
			this.setM_fld_applictn(value);
			break;
		case "Program  Ref":
			this.setM_program_ref(value);
			break;
		case "Abstract":
			this.setM_abstract(value);
			break;
		}
			
	}
	

	public String getM_title() {
		return title;
	}


	public void setM_title(String m_title) {
		this.title = m_title;
	}


	public String getM_type() {
		return _type;
	}


	public void setM_type(String m_type) {
		this._type = m_type;
	}


	public String getM_nsf_org() {
		return nsf_org;
	}


	public void setM_nsf_org(String m_nsf_org) {
		this.nsf_org = m_nsf_org;
	}


	public String getM_latest_amendment_date() {
		return latest_amendment_date;
	}


	public void setM_latest_amendment_date(String m_latest_amendment_date) {
		this.latest_amendment_date = m_latest_amendment_date;
	}


	public String getM_file() {
		return file;
	}


	public void setM_file(String m_file) {
		this.file = m_file;
	}


	public String getM_award_number() {
		return award_number;
	}


	public void setM_award_number(String m_award_number) {
		this.award_number = m_award_number;
	}


	public String getM_award_instr() {
		return award_instr;
	}


	public void setM_award_instr(String m_award_instr) {
		this.award_instr = m_award_instr;
	}


	public String getM_prgm_manager() {
		return prgm_manager;
	}


	public void setM_prgm_manager(String m_prgm_manager) {
		this.prgm_manager = m_prgm_manager;
	}


	public String getM_start_date() {
		return start_date;
	}


	public void setM_start_date(String m_start_date) {
		this.start_date = m_start_date;
	}


	public String getM_expires() {
		return expires;
	}


	public void setM_expires(String m_expires) {
		this.expires = m_expires;
	}


	public String getM_expected_total_amt() {
		return expected_total_amt;
	}


	public void setM_expected_total_amt(String m_expected_total_amt) {
		this.expected_total_amt = m_expected_total_amt;
	}


	public String getM_investigator() {
		return investigator;
	}


	public void setM_investigator(String m_investigator) {
		this.investigator = m_investigator;
	}


	public String getM_sponsor() {
		return sponsor;
	}


	public void setM_sponsor(String m_sponsor) {
		this.sponsor = m_sponsor;
	}


	public String getM_nsf_program() {
		return nsf_program;
	}


	public void setM_nsf_program(String m_nsf_program) {
		this.nsf_program = m_nsf_program;
	}


	public String getM_fld_applictn() {
		return fld_applictn;
	}


	public void setM_fld_applictn(String m_fld_applictn) {
		this.fld_applictn = m_fld_applictn;
	}


	public String getM_program_ref() {
		return program_ref;
	}


	public void setM_program_ref(String m_program_ref) {
		this.program_ref = m_program_ref;
	}


	public String getM_abstract() {
		return _abstract;
	}


	public void setM_abstract(String m_abstract) {
		this._abstract = m_abstract;
	}

}
