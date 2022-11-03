package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramInstanciaESalvaBD {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(null,"carlos da Silva", "carlos@mail.com");
        Pessoa p2 = new Pessoa(null,"Ana Maria", "ana@mail.com");
        Pessoa p3 = new Pessoa(null,"Flavio Silva", "flavio@mail.com");

        //utilizado para instanciar objetos EntityManager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //utilizado para instanciar objetos EntityManager.a grosso modo conectar com o BD
        //serve para efetuar operações de acesso a dados (inserção, remoção, deleção, atualização) em entidades
        EntityManager em = emf.createEntityManager();

        //quando o JPA precisa faz uma operação que não é uma simples leitura do BD, ele precisa de uma tranasação
        //para iniciar a transação com o BD eu chamo .begin();
        em.getTransaction().begin();

        //persiste é quem pega o Objeto e salva no BD
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        //para confirmar as transações eu uso o .commit()
        em.getTransaction().commit();

        System.out.println("Finalizado!");

        em.close();


    }
}
