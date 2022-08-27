package Utils;

import Records.ProductRecord;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ProductUtils {

    public static List<ProductRecord> getProductsFromWebElementsList(WebElementFacade productListWebElement, String itemSelector,
                                               String productNameSelector, String productDescriptionSelector,
                                               String productPriceSelector, String addToCartButtonSelector){

        List<WebElementFacade> productsElementsList = productListWebElement.thenFindAll(By.className(itemSelector));

        List<ProductRecord> productsRecordsList = new ArrayList<>();
        String productName;
        String productDescription;
        float productPrice;
        WebElementFacade addToCardButton = null;

        for ( WebElementFacade el: productsElementsList) {
            productName = el.findBy(By.className(productNameSelector)).getText();
            productDescription = el.findBy(By.className(productDescriptionSelector)).getText();
            productPrice = Float.parseFloat(el.findBy(By.className(productPriceSelector))
                    .getText().replace("$", ""));
            if(addToCartButtonSelector != null) addToCardButton = el.findBy(By.cssSelector(addToCartButtonSelector));
            productsRecordsList.add(new ProductRecord(productName, productDescription, productPrice, addToCardButton));
        }
        return productsRecordsList;
    }

    public static boolean compareTwoLists(List<ProductRecord> firstList, List<ProductRecord> secondList){
        boolean isProductFound;

        for (ProductRecord product : firstList) {
            isProductFound = false;
            for(ProductRecord innerProduct : secondList){
                if (product.name().equals(innerProduct.name()) && product.description().equals(innerProduct.description())
                        && product.price() == innerProduct.price()) {
                    isProductFound = true;
                    break;
                }
            }
            if(!isProductFound) return false;
        }
        return true;
    }
}
