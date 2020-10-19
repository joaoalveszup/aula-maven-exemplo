package br.com.zup.estrelas.exemplo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zup.estrelas.exemplo.pojo.Carro;

public class CarroDAO {

    EntityManager manager;
    // Connection conn;

    public CarroDAO() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("carros");
        this.manager = managerFactory.createEntityManager();
        // this.conn = new ConnectionFactory().fabricaConexao();
        // Pode ser feito assim:
        // this.manager =
        // Persistence.createEntityManagerFactory("carros").createEntityManager();
    }

    public void insereCarro(Carro carro) {

        manager.getTransaction().begin();
        manager.persist(carro);
        manager.getTransaction().commit();

    }

    public Carro consultaCarro(String placa) {

        Carro carroConsultado = manager.find(Carro.class, placa);

        return carroConsultado;
    }

    public void alteraCarro(Carro carroAlterado) {

        Carro carroConsultado = manager.find(Carro.class, carroAlterado.getPlaca());

        if (carroConsultado == null) {
            return;
        }

        carroConsultado.setCor(carroAlterado.getCor());
        carroConsultado.setFabricante(carroAlterado.getFabricante());

        manager.getTransaction().begin();
        manager.merge(carroConsultado);
        manager.getTransaction().commit();
    }

    public void alterCorCarro(String placa, String cor) {

        Carro carroConsultado = manager.find(Carro.class, placa);
        carroConsultado.setCor(cor);

        manager.getTransaction().begin();
        manager.merge(carroConsultado);
        manager.getTransaction().commit();
    }

    public void removeCarro(String placa) {

        Carro carroRemocao = manager.find(Carro.class, placa);

        manager.getTransaction().begin();
        manager.remove(carroRemocao);
        manager.getTransaction().commit();
    }

    public void insereCarroJDBC(Carro carro) {

//        String sql = "insert into carro (placa, cor, fabricante, vel_max, peso, nome)"
//                + " values (?, ?, ?, ?, ?, ?)";
//
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, carro.getPlaca());
//            stmt.setString(2, carro.getCor());
//            stmt.setString(3, carro.getFabricante());
//            stmt.setFloat(4, carro.getVelMax());
//            stmt.setFloat(5, carro.getPeso());
//            stmt.setString(6, carro.getNome());
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            // Não vamos tratar você pq não é o foco hoje.
//        }

    }

    public List<Carro> listaCarros() {

        Query query = manager.createQuery("select c from Carro as c");

        List<Carro> carros = query.getResultList();
        return carros;
    }

    public List<Carro> listaCarrosPorFabricante(String fabricante) {

        Query query = manager.createQuery("select c from Carro as c " 
        + "where c.fabricante = :fabricante");

        query.setParameter("fabricante", fabricante);

        List<Carro> carros = query.getResultList();
        return carros;
    }

}
