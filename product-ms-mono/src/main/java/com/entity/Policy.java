package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Policy {

	@Id
	@GeneratedValue
    private long policy_id;
    private String policy_name;
    private String policy_description;
    private double standardPremium;
    private int coverageAmount; // In months, years, etc.
    private int term;
    private long insurance_id;
	public long getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(long policy_id) {
		this.policy_id = policy_id;
	}
	public String getPolicy_name() {
		return policy_name;
	}
	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}
	public String getPolicy_description() {
		return policy_description;
	}
	public void setPolicy_description(String policy_description) {
		this.policy_description = policy_description;
	}
	public double getStandardPremium() {
		return standardPremium;
	}
	public void setStandardPremium(double standardPremium) {
		this.standardPremium = standardPremium;
	}
	public int getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public long getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(long insurance_id) {
		this.insurance_id = insurance_id;
	}
	public Policy(long policy_id, String policy_name, String policy_description, double standardPremium,
			int coverageAmount, int term, long insurance_id) {
		super();
		this.policy_id = policy_id;
		this.policy_name = policy_name;
		this.policy_description = policy_description;
		this.standardPremium = standardPremium;
		this.coverageAmount = coverageAmount;
		this.term = term;
		this.insurance_id = insurance_id;
	}
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}