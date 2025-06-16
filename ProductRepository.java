import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class ProductRepository
{
    private static Database database;
    private static Dao<Product, Integer> dao;
    private List<Product> loadedProducts;
    private Product loadedProduct; 
    
    public ProductRepository(Database database) {
        ProductRepository.setDatabase(database);
        loadedProducts = new ArrayList<Product>();
    }
    
    public static void setDatabase(Database database) {
        ProductRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Product.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Product.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Product create(Product product) {
        int nrows = 0;
        try {
            nrows = dao.create(product);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedProduct = product;
            loadedProducts.add(product);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }    

    public void update(Product product) {
      // TODO
    }

    public void delete(Product product) {
      // TODO
    }
    
    public Product loadFromId(int id) {
        try {
            this.loadedProduct = dao.queryForId(id);
            if (this.loadedProduct != null)
                this.loadedProducts.add(this.loadedProduct);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedProduct;
    }    
    
    public List<Product> loadAll() {
        try {
            this.loadedProducts =  dao.queryForAll();
            if (this.loadedProducts.size() != 0)
                this.loadedProduct = this.loadedProducts.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedProducts;
    }

    // getters and setters ommited...        
}