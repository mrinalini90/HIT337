package Product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-11T03:22:31")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Integer> itemid;
    public static volatile SingularAttribute<Item, String> itemdescription;
    public static volatile SingularAttribute<Item, int> sellerid;
    public static volatile SingularAttribute<Item, String> itemname;
    public static volatile SingularAttribute<Item, Boolean> itemstatus;
    public static volatile SingularAttribute<Item, Float> itemprice;
    public static volatile SingularAttribute<Item, Integer> itemquanity;

}