package br.com.jpa;

import br.com.jpa.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager manager = factory.createEntityManager();
        createdAccount(manager);
        manager.close();
    }

    public static void createdAccount(final EntityManager manager) {
        Account account = Account.builder()
                                 .numberAccount(1)
                                 .agency(1)
                                 .owner("Fulano")
                                 .build();

        manager.getTransaction()
               .begin();
        manager.persist(account);
        manager.getTransaction()
               .commit();
    }
}

