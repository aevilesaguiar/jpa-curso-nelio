package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramEntidadeMonitorada {
    public static void main(String[] args) {

        //utilizado para instanciar objetos EntityManager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //utilizado para instanciar objetos EntityManager.a grosso modo conectar com o BD
        //serve para efetuar operações de acesso a dados (inserção, remoção, deleção, atualização) em entidades
        EntityManager em = emf.createEntityManager();

        //Objeto detach JPA não remove, apenas objetos monitorados

      //  Pessoa p = new Pessoa(2,null,null);

        //remover uma pessoa do BD
        //em.remove(p);

        //ex de Objeto monitorado
        Pessoa p = em.find(Pessoa.class,2 );


        System.out.println(p);

        em.getTransaction().begin();

        em.remove(p);

        em.getTransaction().commit();

        System.out.println("Finalizado!");

        em.close();
        emf.close();


    }
}
