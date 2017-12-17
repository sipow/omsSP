package com.ubs.simonpowers.oms.datasource;

import org.springframework.stereotype.Repository;

import com.ubs.simonpowers.oms.domain.User;

@Repository
public class UserRepository extends InMemoryRepository<User> {}