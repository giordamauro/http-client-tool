package com.bundle.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "IPRules")
public class IPRules {

	private String noRuleMatchAction;

	private List<MatchRule> matchRules;

	public String getNoRuleMatchAction() {
		return noRuleMatchAction;
	}

	@XmlAttribute
	public void setNoRuleMatchAction(String noRuleMatchAction) {
		this.noRuleMatchAction = noRuleMatchAction;
	}

	public List<MatchRule> getMatchRules() {
		return matchRules;
	}

	@XmlElement(name = "MatchRule")
	public void setMatchRules(List<MatchRule> matchRules) {
		this.matchRules = matchRules;
	}

}
