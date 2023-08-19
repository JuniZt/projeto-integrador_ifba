/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author s
 */
public class CartaoCreditoDao {
    
    private final GerenciadorBD gerenciadorBd;
    
    public CartaoCreditoDao() {
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public void cadastrar(CartaoCreditoDto cartao, UsuarioDto usuario) throws Exception{
        
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                "INSERT INTO cartao_credito(numero, usuario_id, vencimento, limite) VALUES (?,?,?,?)"))
        {
            ps.setInt(1, cartao.getNumero());
            ps.setInt(2, usuario.getId());
            LocalDate data = LocalDate.of(2027,10,01);
            Date sqlDate = Date.valueOf(data);  
            ps.setDate(3, sqlDate);
            ps.setDouble(4, cartao.getLimite());
            ps.executeUpdate();
        }
    }
    
    public List<CartaoCreditoDto> listar() throws Exception{
        
        List<CartaoCreditoDto> listaDeCartoes = new ArrayList<>();
        
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT cartao_credito.id, cartao_credito.numero, cartao_credito.vencimento, cartao_credito.limite, Usuario.* "
                                + "FROM cartao_credito "
                                + "INNER JOIN Usuario ON cartao_credito.usuario_id=Usuario.id");
                ResultSet tabela = ps.executeQuery())
        {
            while(tabela.next()){
                
                CartaoCreditoDto cartao = new CartaoCreditoDto();
                cartao.setId(tabela.getInt("id"));
                cartao.setNumero(tabela.getInt("numero"));
                Date sqlDate = tabela.getDate("vencimento");
                cartao.setVencimento(sqlDate.toLocalDate());
                cartao.setLimite(tabela.getDouble("limite"));
                
                UsuarioDto usuario = new UsuarioDto();
                usuario.setId(tabela.getInt("Usuario.id"));
                usuario.setEmail(tabela.getString("Usuario.email"));
                usuario.setLogin(tabela.getString("Usuario.login"));
                usuario.setSenha(tabela.getString("Usuario.senha"));
                cartao.setUsuario(usuario);
                               
                listaDeCartoes.add(cartao);
                                
            }
              
        }
        
        return listaDeCartoes;
        
    }
}