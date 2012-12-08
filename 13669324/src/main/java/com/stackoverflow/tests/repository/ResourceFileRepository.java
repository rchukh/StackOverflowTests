package com.stackoverflow.tests.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.stackoverflow.tests.domain.ResourceFile;

public interface ResourceFileRepository extends
	PagingAndSortingRepository<ResourceFile, Integer>,
	ResourceFileRepositoryCustom {
}
