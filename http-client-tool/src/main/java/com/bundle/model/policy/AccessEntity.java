package com.bundle.model.policy;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bundle.model.EntityType;
import com.bundle.model.Identifier;

@XmlRootElement(name = "AccessEntity")
public class AccessEntity extends Policy {

	private EntityType entityType;

	private List<Identifier> identifiers;

	private Identifier entityIdentifier;

	private Identifier secondaryIdentifier;

	public EntityType getEntityType() {
		return entityType;
	}

	@XmlElement(name = "EntityType")
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	@XmlElementWrapper(name = "Identifiers")
	@XmlElement(name = "Identifier")
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	public Identifier getEntityIdentifier() {
		return entityIdentifier;
	}

	@XmlElement(name = "EntityIdentifier")
	public void setEntityIdentifier(Identifier entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}

	public Identifier getSecondaryIdentifier() {
		return secondaryIdentifier;
	}

	@XmlElement(name = "SecondaryIdentifier")
	public void setSecondaryIdentifier(Identifier secondaryIdentifier) {
		this.secondaryIdentifier = secondaryIdentifier;
	}

}
