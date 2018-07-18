package com.synergy.recupro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "candidate")
public class Candidate extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "candidates_generator")
	@SequenceGenerator(name = "candidates_generator", sequenceName = "candidates_sequence", initialValue = 1000)
	@Column(name = "candidateid")
	private Long candidateId;
	@Column(columnDefinition = "text")
	private String firstname;
	@Column(columnDefinition = "text")
	private String lastname;
	@Column(columnDefinition = "text")
	private String phonenumber;
	@Column(columnDefinition = "text")
	private String emailaddress;
	@Column(columnDefinition = "text")
	private String overallexperience;
	@Column(columnDefinition = "text")
	private String relevantexperience;
	@Column(columnDefinition = "text")
	private String workingstatus;
	@Column(columnDefinition = "text")
	private String strengths;
	@Column(columnDefinition = "text")
	private String avaiabilityforinterview;
	@Column(columnDefinition = "text")
	private String availabilitytojoin;
	@Column(columnDefinition = "text")
	private String status;
	@Column(columnDefinition = "text")
	private String reason;
	@Column(columnDefinition = "text")
	private String linkedinurl;
	@Column(columnDefinition = "text")
	private String referrences;
	@Column(columnDefinition = "text")
	private String vendorname;
	@Column(columnDefinition = "text")
	private String vendorcontact;
	@Column(columnDefinition = "text")
	private String vendorphone;
	@Column(columnDefinition = "text")
	private String vendoremail;
	@Column(columnDefinition = "text")
	private String referredby;
	@Column(columnDefinition = "text")
	private String primaryskills;
	@Column(columnDefinition = "text")
	private String secondaryskills;
	@Column(columnDefinition = "text")
	private String docsuploaded;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Candidate_Requirement", joinColumns = { @JoinColumn(name = "candidate_id") }, inverseJoinColumns = { @JoinColumn(name = "req_id") })
	@JsonIgnoreProperties("candidates")
	private List<Requirements> requirements = new ArrayList<Requirements>();

	

	

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getOverallexperience() {
		return overallexperience;
	}

	public void setOverallexperience(String overallexperience) {
		this.overallexperience = overallexperience;
	}

	public String getRelevantexperience() {
		return relevantexperience;
	}

	public void setRelevantexperience(String relevantexperience) {
		this.relevantexperience = relevantexperience;
	}

	public String getWorkingstatus() {
		return workingstatus;
	}

	public void setWorkingstatus(String workingstatus) {
		this.workingstatus = workingstatus;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getAvaiabilityforinterview() {
		return avaiabilityforinterview;
	}

	public void setAvaiabilityforinterview(String avaiabilityforinterview) {
		this.avaiabilityforinterview = avaiabilityforinterview;
	}

	public String getAvailabilitytojoin() {
		return availabilitytojoin;
	}

	public void setAvailabilitytojoin(String availabilitytojoin) {
		this.availabilitytojoin = availabilitytojoin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLinkedinurl() {
		return linkedinurl;
	}

	public void setLinkedinurl(String linkedinurl) {
		this.linkedinurl = linkedinurl;
	}

	public String getReferrences() {
		return referrences;
	}

	public void setReferrences(String referrences) {
		this.referrences = referrences;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getVendorcontact() {
		return vendorcontact;
	}

	public void setVendorcontact(String vendorcontact) {
		this.vendorcontact = vendorcontact;
	}

	public String getVendorphone() {
		return vendorphone;
	}

	public void setVendorphone(String vendorphone) {
		this.vendorphone = vendorphone;
	}

	public String getVendoremail() {
		return vendoremail;
	}

	public void setVendoremail(String vendoremail) {
		this.vendoremail = vendoremail;
	}

	public String getReferredby() {
		return referredby;
	}

	public void setReferredby(String referredby) {
		this.referredby = referredby;
	}

	public String getPrimaryskills() {
		return primaryskills;
	}

	public void setPrimaryskills(String primaryskills) {
		this.primaryskills = primaryskills;
	}

	public String getSecondaryskills() {
		return secondaryskills;
	}

	public void setSecondaryskills(String secondaryskills) {
		this.secondaryskills = secondaryskills;
	}

	public String getDocsuploaded() {
		return docsuploaded;
	}

	public void setDocsuploaded(String docsuploaded) {
		this.docsuploaded = docsuploaded;
	}

	public List<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirements> requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return "Candidate [candidateid=" + candidateId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", phonenumber="
				+ phonenumber + ", emailaddress=" + emailaddress
				+ ", overallexperience=" + overallexperience
				+ ", relevantexperience=" + relevantexperience
				+ ", workingstatus=" + workingstatus + ", strengths="
				+ strengths + ", avaiabilityforinterview="
				+ avaiabilityforinterview + ", availabilitytojoin="
				+ availabilitytojoin + ", status=" + status + ", reason="
				+ reason + ", linkedinurl=" + linkedinurl + ", referrences="
				+ referrences + ", vendorname=" + vendorname
				+ ", vendorcontact=" + vendorcontact + ", vendorphone="
				+ vendorphone + ", vendoremail=" + vendoremail
				+ ", referredby=" + referredby + ", primaryskills="
				+ primaryskills + ", secondaryskills=" + secondaryskills
				+ ", docsuploaded=" + docsuploaded + ", requirements="
				+ requirements + "]";
	}

}
