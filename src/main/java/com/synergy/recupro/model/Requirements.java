package com.synergy.recupro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "requirements")
public class Requirements extends AuditModel {
	
    @Id
    @GeneratedValue(generator = "req_generator")
    @SequenceGenerator(
            name = "req_generator",
            sequenceName = "req_sequence",
            initialValue = 1000
    )
    private Long id;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String rate;
    
    @Column(columnDefinition = "text")
    private String primary_skills;
    @Column(columnDefinition = "text")
    private String secondary_skills;
    @Column(columnDefinition = "text")
    private String seniority_level;
    @Column(columnDefinition = "text")
    private String type;
    @Column(columnDefinition = "text")
    private String pay_rate;
    @Column(columnDefinition = "text")
    private String candidate_availability;
    @Column(columnDefinition = "text")
    private String exp_required;
    @Column(columnDefinition = "text")
    private String recruiter_name;
    @Column(columnDefinition = "text")
    private String account_manager;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Accounts accounts;
    @ManyToMany(mappedBy="requirements")
    @JsonIgnoreProperties("requirements")
    private List<Candidate> candidates ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPrimary_skills() {
		return primary_skills;
	}
	public void setPrimary_skills(String primary_skills) {
		this.primary_skills = primary_skills;
	}
	public String getSecondary_skills() {
		return secondary_skills;
	}
	public void setSecondary_skills(String secondary_skills) {
		this.secondary_skills = secondary_skills;
	}
	public String getSeniority_level() {
		return seniority_level;
	}
	public void setSeniority_level(String seniority_level) {
		this.seniority_level = seniority_level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPay_rate() {
		return pay_rate;
	}
	public void setPay_rate(String pay_rate) {
		this.pay_rate = pay_rate;
	}
	public String getCandidate_availability() {
		return candidate_availability;
	}
	public void setCandidate_availability(String candidate_availability) {
		this.candidate_availability = candidate_availability;
	}
	public String getExp_required() {
		return exp_required;
	}
	public void setExp_required(String exp_required) {
		this.exp_required = exp_required;
	}
	public String getRecruiter_name() {
		return recruiter_name;
	}
	public void setRecruiter_name(String recruiter_name) {
		this.recruiter_name = recruiter_name;
	}
	public String getAccount_manager() {
		return account_manager;
	}
	public void setAccount_manager(String account_manager) {
		this.account_manager = account_manager;
	}
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
}
