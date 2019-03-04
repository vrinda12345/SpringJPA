package com.cg.banking.daoservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
@Component("accountDAO")
public class AccountDAOImpl implements AccountDAO {
@Autowired
	private EntityManagerFactory entityManagerFactory ;
	
	@Override
	public Account save(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}

	@Override
	public Account update(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}

	@Override
	public Account findOne(long accountNo) {
		return entityManagerFactory.createEntityManager().find(Account.class, accountNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAll() {
		Query query =  entityManagerFactory.createEntityManager().createQuery("from Account a", Account.class);
		return query.getResultList();
	}
}
