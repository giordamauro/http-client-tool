package com.bundle.model.policy;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bundle.model.Add;
import com.bundle.model.AssignTo;
import com.bundle.model.AssignVariable;
import com.bundle.model.CopySet;
import com.bundle.model.Property;
import com.bundle.model.Remove;

@XmlRootElement(name = "AssignMessage")
public class AssignMessage extends Policy {

	private AssignTo assignTo;

	private boolean ignoreUnresolvedVariables;

	private List<AssignVariable> assignVariables;

	private List<Property> properties;

	private CopySet copy;

	private Remove remove;

	private Add add;

	private CopySet set;

	public AssignTo getAssignTo() {
		return assignTo;
	}

	@XmlElement(name = "AssignTo")
	public void setAssignTo(AssignTo assignTo) {
		this.assignTo = assignTo;
	}

	public boolean isIgnoreUnresolvedVariables() {
		return ignoreUnresolvedVariables;
	}

	@XmlElement(name = "IgnoreUnresolvedVariables")
	public void setIgnoreUnresolvedVariables(boolean ignoreUnresolvedVariables) {
		this.ignoreUnresolvedVariables = ignoreUnresolvedVariables;
	}

	public List<Property> getProperties() {
		return properties;
	}

	@XmlElementWrapper(name = "Properties")
	@XmlElement(name = "Property")
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public CopySet getCopy() {
		return copy;
	}

	@XmlElement(name = "Copy")
	public void setCopy(CopySet copy) {
		this.copy = copy;
	}

	public Remove getRemove() {
		return remove;
	}

	@XmlElement(name = "Remove")
	public void setRemove(Remove remove) {
		this.remove = remove;
	}

	public Add getAdd() {
		return add;
	}

	@XmlElement(name = "Add")
	public void setAdd(Add add) {
		this.add = add;
	}

	public CopySet getSet() {
		return set;
	}

	@XmlElement(name = "Set")
	public void setSet(CopySet set) {
		this.set = set;
	}

	public List<AssignVariable> getAssignVariables() {
		return assignVariables;
	}

	@XmlElement(name = "AssignVariable")
	public void setAssignVariables(List<AssignVariable> assignVariables) {
		this.assignVariables = assignVariables;
	}
}
