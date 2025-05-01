package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDTO;
import com.example.demo.utill.DatabaseConnection;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    DatabaseConnection databaseConnection;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            final String sql = "INSERT INTO students (name, email, phone, address, city) VALUES (?, ?, ?, ?, ?)";
            connection = databaseConnection.getConnection();
            if (connection == null) {
                System.err.println("Database connection is null");
                return null;
            }
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getName());
            preparedStatement.setString(2, studentDTO.getEmail());
            preparedStatement.setString(3, studentDTO.getPhone());
            preparedStatement.setString(4, studentDTO.getAddress());
            preparedStatement.setString(5, studentDTO.getCity());
            
            preparedStatement.executeUpdate();
        }
            catch (SQLException e) {
            System.err.println("Error creating student: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return studentDTO;
    }


    // @Override
    // public StudentDTO findById(Integer id) {
    //     return null;
    // }

    // @Override
    // public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
    //     return null;
    // }

    // @Override
    // public StudentDTO deleteStudent(Integer id) {
    //     return null;
    // }


    @Override
    public List<StudentDTO> getStudent() {
        final List<StudentDTO> studentDTOs= new ArrayList<>();
        final String sql="SELECT * FROM students";
        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while (resultSet.next()) {
                final StudentDTO student = new StudentDTO(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getString("address"),
                    resultSet.getString("city")
                );
                studentDTOs.add(student);
        }
    }
        catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return studentDTOs;
    }
}
