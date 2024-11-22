package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Crear EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        
        // Crear EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar transacción
            em.getTransaction().begin();

            // Crear un nuevo cliente
            Cliente cliente = new Cliente();
            cliente.setNombre("Javier Lopez");
            cliente.setEmail("j.lo@email.com");

            // Crear un pedido para el cliente
            Pedido pedido = new Pedido();
            pedido.setNumeroPedido("PED-001");
            pedido.setTotal(150.75);

            // Asociar el pedido al cliente
            cliente.addPedido(pedido);

            // Persistir el cliente (y en cascada, el pedido)
            em.persist(cliente);

            // Commit de la transacción
            em.getTransaction().commit();

            System.out.println("Cliente y pedido guardados exitosamente");

        } catch (Exception e) {
            // Rollback en caso de error
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}