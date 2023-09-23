package org.myLibrary.data.dao;

import org.myLibrary.business.models.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO implements DAO<Publisher> {
    private final Connection connection;

    public PublisherDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Publisher get(int id) {
        final String query = "SELECT * FROM publisher WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Publisher publisher = new Publisher();
                    publisher.setId(resultSet.getInt("id"));
                    publisher.setName(resultSet.getString("name"));
                    return publisher;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Publisher> getByName(String name) {
        final String query = "SELECT * FROM publisher WHERE name = ?;";
        List<Publisher> publishers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Publisher publisher = new Publisher();
                    publisher.setId(resultSet.getInt("id"));
                    publisher.setName(resultSet.getString("name"));
                    publishers.add(publisher);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public List<Publisher> getAll() {
        final String query = "SELECT * FROM publisher;";
        List<Publisher> publishers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(resultSet.getInt("id"));
                publisher.setName(resultSet.getString("name"));
                publishers.add(publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public void save(Publisher publisher) {
        final String query = "INSERT INTO publisher (name) VALUES (?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Publisher publisher, String[] params) {
        final String query = "UPDATE publisher SET name = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, params[0]);
            preparedStatement.setInt(2, publisher.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Publisher publisher) {
        final String query = "DELETE FROM publisher WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, publisher.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
