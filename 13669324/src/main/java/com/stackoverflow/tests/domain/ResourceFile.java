package com.stackoverflow.tests.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "resource_file")
public class ResourceFile implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "resource_file_id_generator", sequenceName = "resource_file_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_file_id_generator")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    public ResourceFile() {
    }

    @Override
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Override
    public boolean isNew() {
	return this.getId() == null;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (this.getClass() != obj.getClass()) {
	    return false;
	}
	ResourceFile other = (ResourceFile) obj;
	if (this.id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!this.id.equals(other.id)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ResourceFile [id=").append(this.id).append("]");
	return builder.toString();
    }

}