package DAO;

import model.Storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageRepository extends Repository{


    void create(Storage storage){
        String sql = "INSERT INTO storage(id_product, quantity)" +
                "VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = createdConnection.prepareStatement(sql);
            preparedStatement.setLong(1, storage.getIdProduct());
            preparedStatement.setInt(2, storage.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void update(Storage storage){
        String sql = "UPDATE storage SET quantity = ? WHERE id_product = ?";

        try {
            PreparedStatement preparedStatement = createdConnection.prepareStatement(sql);
            preparedStatement.setInt(1, storage.getQuantity());
            preparedStatement.setLong(2, storage.getIdProduct());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void delete(Long id){
        String sql = "DELETE FROM storage WHERE id_product = ?";

        try {
            PreparedStatement preparedStatement = createdConnection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    Storage getById(Long id){
        String query = "SELECT FROM storage WHERE id_product = ?";
        Storage storage = new Storage();

        try{
            PreparedStatement preparedStatement = createdConnection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                storage.setIdProduct(resultSet.getLong(1));
                storage.setQuantity(resultSet.getInt(2));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return storage;
    }

}
