package com.stackoverflow.tests.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.stackoverflow.tests.domain.FavoriteResourceFile;
import com.stackoverflow.tests.domain.FavoriteResourceFile_;
import com.stackoverflow.tests.domain.ResourceFile;
import com.stackoverflow.tests.domain.ResourceFile_;
import com.stackoverflow.tests.repository.ResourceFileRepositoryCustom;

public class ResourceFileRepositoryImpl implements
	ResourceFileRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    /**
     * Configure the entity manager to be used.
     * 
     * @param em
     *            the {@link EntityManager} to set.
     */
    public void setEntityManager(EntityManager em) {
	this.em = em;
    }

    @Override
    public List<ResourceFile> getResourceFile() {
	CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
	CriteriaQuery<ResourceFile> q = criteriaBuilder
		.createQuery(ResourceFile.class);
	Root<FavoriteResourceFile> root = q.from(FavoriteResourceFile.class);
	Join<FavoriteResourceFile, ResourceFile> join = root.join(
		FavoriteResourceFile_.resourceFile, JoinType.LEFT);

	q.select(join);
	q.groupBy(join.get(ResourceFile_.id));
	// q.orderBy(criteriaBuilder.desc(criteriaBuilder.count(root
	// .get(FavoriteResourceFile_.resourceFile))));
	q.orderBy(criteriaBuilder.desc(criteriaBuilder.count(join
		.get(ResourceFile_.id))));

	TypedQuery<ResourceFile> query = this.em.createQuery(q);
	return query.getResultList();
    }
}
