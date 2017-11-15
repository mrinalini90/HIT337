package Product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-16T03:28:02")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Integer> itemid;
    public static volatile SingularAttribute<Item, String> itemdescription;
    public static volatile SingularAttribute<Item, Integer> sellerid;
    public static volatile SingularAttribute<Item, String> itemname;
    public static volatile SingularAttribute<Item, Boolean> itemstatus;
    public static volatile SingularAttribute<Item, Float> itemprice;
    public static volatile SingularAttribute<Item, Integer> itemquanity;

}