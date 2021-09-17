package backend;
import java.util.Date;
import java.util.List;

class Image {
    public String imageUrl;
    public Object fileType;
    public Object size;
}

class TasteClock {
    public String key;
    public int value;
}

public class Product {
    public String productId;
    public String productNumber;
    public String productNameBold;
    public Object productNameThin;
    public Object category;
    public String productNumberShort;
    public String producerName;
    public String supplierName;
    public boolean isKosher;
    public String bottleTextShort;
    public int restrictedParcelQuantity;
    public boolean isOrganic;
    public boolean isEthical;
    public Object ethicalLabel;
    public boolean isWebLaunch;
    public Date productLaunchDate;
    public boolean isCompletelyOutOfStock;
    public boolean isTemporaryOutOfStock;
    public double alcoholPercentage;
    public String volumeText;
    public double volume;
    public double price;
    public String country;
    public String originLevel1;
    public Object originLevel2;
    public String categoryLevel1;
    public String categoryLevel2;
    public String categoryLevel3;
    public Object categoryLevel4;
    public String customCategoryTitle;
    public String assortmentText;
    public String usage;
    public String taste;
    public List<String> tasteSymbols;
    public Object tasteClockGroupBitter;
    public Object tasteClockGroupSmokiness;
    public int tasteClockBitter;
    public int tasteClockFruitacid;
    public int tasteClockBody;
    public int tasteClockRoughness;
    public int tasteClockSweetness;
    public int tasteClockSmokiness;
    public int tasteClockCasque;
    public String assortment;
    public double recycleFee;
    public boolean isManufacturingCountry;
    public boolean isRegionalRestricted;
    public String packaging;
    public boolean isNews;
    public List<Image> images;
    public boolean isDiscontinued;
    public boolean isSupplierTemporaryNotAvailable;
    public int sugarContent;
    public Object sugarContentGramPer100ml;
    public List<String> seal;
    public String vintage;
    public List<String> grapes;
    public Object otherSelections;
    public List<TasteClock> tasteClocks;
    public String color;
    public Object dishPoints;
}
