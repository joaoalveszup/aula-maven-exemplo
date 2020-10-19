package br.com.zup.estrelas.exemplo.principal;

import br.com.zup.estrelas.exemplo.dao.CarroDAO;
import br.com.zup.estrelas.exemplo.pojo.Carro;

public class Principal {

    public static void main(String[] args) {

        CarroDAO carroDao = new CarroDAO();
        
        // Inserção com Hibernate e com JDBC
//        Carro carroTeste = new Carro();
//        carroTeste.setPlaca("EZD-7403");
//        carroTeste.setFabricante("Volks");
//        carroTeste.setNome("Polo");
//        carroTeste.setCor("Prata");
//        carroTeste.setVelMax(120F);
//        carroTeste.setPeso(1000F);
//        
//        long startTime = System.currentTimeMillis();
//        carroDao.insereCarro(carroTeste);
//        long endTime = System.currentTimeMillis();
//        long timeElapsed = endTime - startTime;
//        
//        System.out.printf("Tempo decorrido - JPA/Hibernate: %d\n", timeElapsed);
//        
//        carroTeste.setPlaca("EZD-7401");
//        
//        startTime = System.currentTimeMillis();
//        carroDao.insereCarroJDBC(carroTeste);
//        endTime = System.currentTimeMillis();
//        timeElapsed = endTime - startTime;
//        System.out.printf("Tempo decorrido - JDBC: %d\n", timeElapsed);

        // Consulta por chave
//        Carro carroRetornado = carroDao.consultaCarro("EZD-7403");
//        Carro carroNulo = carroDao.consultaCarro("EZD-7474");
//
//        System.out.println(carroRetornado);
//        System.out.println(carroNulo);

        // Remoção e Alteração
        carroDao.alterCorCarro("EZD-7403", "Vermelho");
        carroDao.removeCarro("EZD-7401");

    }

}
