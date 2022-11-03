package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramBuscarPessoa {
    public static void main(String[] args) {

        //utilizado para instanciar objetos EntityManager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //utilizado para instanciar objetos EntityManager.a grosso modo conectar com o BD
        //serve para efetuar operações de acesso a dados (inserção, remoção, deleção, atualização) em entidades
        EntityManager em = emf.createEntityManager();


        //buscar objeto pelo o ID

        Pessoa p = em.find(Pessoa.class,2 );

        System.out.println(p);
        System.out.println("Finalizado!");

        em.close();


    }
}
