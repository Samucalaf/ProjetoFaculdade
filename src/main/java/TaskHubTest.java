import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Usuario;

public class TaskHubTest {
    private static EntityManagerFactory entityManagerFactory;
    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("PU");

        EntityManager em = entityManagerFactory.createEntityManager();
        Usuario Usuario;
        try {
            Usuario = new Usuario(1,
                    "Samuel",
                    "SamuelLafuente@email",
                    "12345");
        } finally {
            em.close();
            entityManagerFactory.close();
        }

        em.getTransaction().begin();
        em.persist(Usuario);
        em.getTransaction().commit();
    }
}
