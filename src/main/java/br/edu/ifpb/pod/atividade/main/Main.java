/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.atividade.main;

import br.edu.ifpb.pod.atividade.entyty.Dados;
import br.edu.ifpb.pod.atividade.repositorio.Repositorio;
import br.edu.ifpb.pod.atividade.repositorio.RepositorioDados;
import br.edu.ifpb.pod.atividade.service.Sequencia;
import br.edu.ifpb.pod.atividade.service.Service;

/**
 *
 * @author jose2
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        long tempoInicial = System.currentTimeMillis();
//// 
//       
        executar();
        System.out.println("Threads  finalizadas!");
        long tempoFinal = System.currentTimeMillis();
        System.out.println("tempo de execução" +
                (tempoFinal - tempoInicial) / 1000);
        Service service = new Service();
        boolean idRepit = service.isdadosrepitidos(); 
        if (idRepit) {
            System.err.println("Há id repetido no banco de dados");
        }

    }

    private static void executar() throws InterruptedException {
        Thread t1 = new Thread(new Service("thred 1", 1, 100000));
        Thread t2 = new Thread(new Service("thred 2", 2, 100000));
        Thread t3 = new Thread(new Service("thred 3", 3, 100000));
        Thread t4 = new Thread(new Service("thred 4", 4, 100000));
        Thread t5 = new Thread(new Service("thred 5", 5, 100000));
        Thread t6 = new Thread(new Service("thred 6", 6, 100000));
        Thread t7 = new Thread(new Service("thred 3", 7, 100000));
        Thread t8 = new Thread(new Service("thred 3", 8, 100000));
        Thread t9 = new Thread(new Service("thred 3", 9, 100000));
        Thread t10 = new Thread(new Service("thred 3", 10, 100000));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        // faz com que a thread que roda o metodo aguarde o fim dessas
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
    }

}
