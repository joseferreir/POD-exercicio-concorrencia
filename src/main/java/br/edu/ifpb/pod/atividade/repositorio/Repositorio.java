/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.atividade.repositorio;

/**
 *
 * @author jose2
 */
public interface Repositorio<T> {

    public void add(T obj);

    public T find(int id);

    public boolean isdadosrepitidos();
}
