package com.stackoverflow.tests.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "favorite_resource_file")
public class FavoriteResourceFile implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "resource_file_id", nullable = false)
    private ResourceFile resourceFile;

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
	result = prime
		* result
		+ ((this.resourceFile == null) ? 0 : this.resourceFile
			.hashCode());
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
	FavoriteResourceFile other = (FavoriteResourceFile) obj;
	if (this.id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!this.id.equals(other.id)) {
	    return false;
	}
	if (this.resourceFile == null) {
	    if (other.resourceFile != null) {
		return false;
	    }
	} else if (!this.resourceFile.equals(other.resourceFile)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("FavoriteResourceFile [id=").append(this.id)
		.append(", resourceFile=").append(this.resourceFile)
		.append("]");
	return builder.toString();
    }

}