/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;

import java.time.LocalDate;

/**
 *
 * @author s
 */ 
public class CartaoCreditoDto {
    
    private Integer id;
    
    private Integer numero;
    
    private UsuarioDto usuario;
    
    private LocalDate vencimento;
    
    private Double limite;

    public CartaoCreditoDto() {
    }

    public CartaoCreditoDto(Integer id, Integer numero, UsuarioDto usuario, Double limite) {
        this.id = id;
        this.numero = numero;
        this.usuario = usuario;
        this.limite = limite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
    
    
}
