package service;



import model.Order;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: check this endpointInterface
@WebService(endpointInterface = "dk.via.sdj3.assignment1.service.OrderMessageService", serviceName = "OrderMessageService") public class OrderMessageServiceImpl
    implements OrderMessageService
{
  @Override public void create(Order order)
  {
    try (Connection connection = DataBaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO \"Order\".OrderBase(id,description,amount,delivered) VALUES (?,?,?,?)"))
    {
      preparedStatement.setInt(1, order.getId());
      preparedStatement.setString(2, order.getDescription());
      preparedStatement.setFloat(3, order.getAmount());
      preparedStatement.setBoolean(4, order.isDelivered());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

    @Override public Order read ( int id)
    {
      try (Connection connection = DataBaseConnector.getInstance()
          .getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement(
              "SELECT * FROM \"Order\".OrderBase WHERE id = '" + id +"'"))
      {
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return new Order(resultSet.getInt("id"),resultSet.getString("description"),resultSet.getFloat("amount"),resultSet.getBoolean("delivered"));
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      return null;
    }

    @Override public void update (Order order, int id)
    {
      try (Connection connection = DataBaseConnector.getInstance()
          .getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement(
              "UPDATE \"Order\".OrderBase SET id = ?, description = ?, amount = ?, delivered = ? WHERE id = ?"))
      {
        preparedStatement.setInt(1, order.getId());
        preparedStatement.setString(2, order.getDescription());
        preparedStatement.setFloat(3, order.getAmount());
        preparedStatement.setBoolean(4, order.isDelivered());
        preparedStatement.setInt(5,id);

        preparedStatement.execute();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }

    @Override public void delete (Order order)
    {
      try (Connection connection = DataBaseConnector.getInstance()
          .getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement(
              "DELETE FROM \"Order\".OrderBase WHERE id = ?"))
      {
        preparedStatement.setInt(1, order.getId());

        preparedStatement.execute();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
