package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Products;
import es.logixs.main.App;
import es.logixs.repository.ProductsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepositoryMySQL implements ProductsRepository {
    @Autowired
    private DataBaseHelper dataBaseHelper;
    private final static String sqlInsert = "insert into products (id, userId, code, companyId, scientificName, name, category, originCountryIso, quality, descAndSpecs) values (?,?,?,?,?,?,?,?,?,?);";
    private final static String sqlDelete = "delete from products where id=?";
    private final static String sqlFindAll = "select * from products;";
    private final static String sqlFindOne = "select * from products  where id=?;";
    private static final Logger myLogger= LogManager.getLogger(App.class);


    @Override
    public Products insert(Products product) {
        myLogger.info("Insertando un producto" + product.toString());
        try (Connection connection = dataBaseHelper.getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlInsert);) {
            sentence.setString(1, product.getId());
            sentence.setString(2, product.getUserId());
            sentence.setString(3, product.getCode());
            sentence.setString(4, product.getCompanyId());
            sentence.setString(5, product.getScientificName());
            sentence.setString(6, product.getName());
            sentence.setString(7, product.getCategory());
            sentence.setString(8, product.getOriginCountryIso());
            sentence.setString(9, product.getQuality());
            sentence.setString(10, product.getDescAndSpecs());
            sentence.executeUpdate();
            myLogger.info("Producto insertado correctamente");
        } catch (SQLException e) {
            myLogger.error("Error al insertar un producto " + e.getMessage());
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public Products findOne(String id) {
        Products product = null;
        myLogger.info("Buscando un producto con id " + id);
        try (Connection connection = dataBaseHelper.getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlFindOne);) {
            sentence.setString(1, id);
            ResultSet result = sentence.executeQuery();
            if (result.next()) {
                product = new Products();
                product.setId(result.getString("id"));
                product.setUserId(result.getString("userId"));
                product.setCode(result.getString("code"));
                product.setCompanyId(result.getString("companyId"));
                product.setScientificName(result.getString("scientificName"));
                product.setName(result.getString("name"));
                product.setCategory(result.getString("category"));
                product.setOriginCountryIso(result.getString("originCountryIso"));
                product.setQuality(result.getString("quality"));
                product.setDescAndSpecs(result.getString("descAndSpecs"));
            }
            myLogger.info("Producto encontrado correctamente");
        } catch (SQLException e) {
            myLogger.error("Error al buscar un producto " + e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Products> findAll() {
        List<Products> products = new ArrayList<>();
        myLogger.info("Buscando todos los productos");
        try (Connection connection = dataBaseHelper.getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlFindAll);) {
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Products product = new Products();
                product.setId(result.getString("id"));
                product.setUserId(result.getString("userId"));
                product.setCode(result.getString("code"));
                product.setCompanyId(result.getString("companyId"));
                product.setScientificName(result.getString("scientificName"));
                product.setName(result.getString("name"));
                product.setCategory(result.getString("category"));
                product.setOriginCountryIso(result.getString("originCountryIso"));
                product.setQuality(result.getString("quality"));
                product.setDescAndSpecs(result.getString("descAndSpecs"));
                products.add(product);
                myLogger.info("Producto encontrado correctamente");
            }
        } catch (SQLException e) {
            myLogger.error("Error al buscar todos los productos " + e.getMessage());
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public void delete(String id) {
        myLogger.info("Borrando un producto con id " + id);
        try (Connection connection = dataBaseHelper.getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlDelete);) {
            sentence.setString(1, id);
            sentence.executeUpdate();
            myLogger.info("Producto borrado correctamente");
        } catch (SQLException e) {
            myLogger.error("Error al borrar un producto " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
