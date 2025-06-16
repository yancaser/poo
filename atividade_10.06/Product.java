import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "product")
public class Product
{   
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String name;
    
    @DatabaseField
    public int barCode;
    
    @DatabaseField(dataType=DataType.DATE)
    public Date expiration;    
    
    public String printExpiration() {
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        return dateFor.format(expiration);
    }

//Start GetterSetterExtension Source Code

    
    public int getId(){
        return this.id;
    }

    
    public void setId(int id){
        this.id = id;
    }

    
    public String getName(){
        return this.name;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public int getBarCode(){
        return this.barCode;
    }
    
    
    public void setBarCode(int barCode){
        this.barCode = barCode;
    }

    
    public Date getExpiration(){
        return this.expiration;
    }

    
    public void setExpiration(Date expiration){
        this.expiration = expiration;
    }

//End GetterSetterExtension Source Code


}//End class
