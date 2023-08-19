/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class Validacao {
    
    private final GerenciadorBD gerenciadorBd;
    
    public Validacao(){
        
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public boolean validarUsuario(String login, String senha) throws Exception {
            
        try (Connection conn = gerenciadorBd.conectar();
                PreparedStatement statement = conn.prepareStatement(
                "SELECT id, email, login, senha FROM Usuario WHERE login = ? AND senha = ?"))
        
        {

            statement.setString(1, login);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Se houver um registro correspondente, o usuário é válido
            
        }
        
    }
    
    public boolean validarUsuarioPorEmail(String email, String senha) throws Exception {
            
        try (Connection conn = gerenciadorBd.conectar();
            PreparedStatement statement = conn.prepareStatement(
            "SELECT id, email, login, senha FROM Usuario WHERE email = ? AND senha = ?"))
        
        {
             
            statement.setString(1, email);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Se houver um registro correspondente, o usuário é válido
        
        }
    }
    
}
