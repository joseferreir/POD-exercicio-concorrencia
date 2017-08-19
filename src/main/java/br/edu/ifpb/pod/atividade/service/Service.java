/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.atividade.service;

import br.edu.ifpb.pod.atividade.entyty.Dados;
import br.edu.ifpb.pod.atividade.repositorio.Repositorio;
import br.edu.ifpb.pod.atividade.repositorio.RepositorioDados;


/**
 *
 * @author jose2
 */
public class Service implements Runnable {

    private String who;
    private long createD__in;
    private int fim;

    public Service( String who, long createD__in, int fim) {
        this.who = who;
        this.createD__in = createD__in;
        this.fim = fim;
    }
    

    @Override
    public void run() {

        Repositorio repositorio = new RepositorioDados();
        for (int i = 0; i < fim; i++) {
             repositorio.add(new Dados(Sequencia.getSeq(), who, createD__in));
            
        }
       
    }
}
