package Steps;

import Pages.ProductsPage;
import Pages.SaleProcessPages.CheckoutInformationPage;
import Pages.SaleProcessPages.CompletePage;
import Pages.SaleProcessPages.OverviewPage;
import Pages.SaleProcessPages.YourCartPage;
import Records.InformationFormRecord;
import Records.ProductRecord;
import Utils.ProductUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class SaleProcessSteps {


    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    @Step
    public ProductRecord addProductToCartByName(String productName){
        List<ProductRecord> productsRecords = ProductUtils.getProductsFromWebElementsList(
                this.productsPage.getProductsListElement(), this.productsPage.getProductItemClassSelector(),
                this.productsPage.getProductNameClassSelector(), this.productsPage.getProductDescriptionClassSelector(),
                this.productsPage.getProductPriceClassSelector(), this.productsPage.getProductAddToCardButtonClassSelector());

        ProductRecord product = productsRecords.stream().
                filter(el -> el.name().equals(productName)).findFirst().get();
        product.addToCardButton().click();
        return product;
    }

    @Step
    public List<ProductRecord> addProductsToCartByNumber(int numberOfProducts){
        List<ProductRecord> resultProductRecords = new ArrayList<>();

        List<ProductRecord> productsRecords = ProductUtils.getProductsFromWebElementsList(
                this.productsPage.getProductsListElement(), this.productsPage.getProductItemClassSelector(),
                this.productsPage.getProductNameClassSelector(), this.productsPage.getProductDescriptionClassSelector(),
                this.productsPage.getProductPriceClassSelector(), this.productsPage.getProductAddToCardButtonClassSelector());

        WebElementFacade addToCartButton;
        ProductRecord actualProduct;
        int iterator = 0;

        while(numberOfProducts > 0){
            actualProduct = productsRecords.get(iterator);
            addToCartButton = actualProduct.addToCardButton();

            if(!addToCartButton.isVisible()) continue;
            addToCartButton.click();
            resultProductRecords.add(actualProduct);
            numberOfProducts--;
        }
        return resultProductRecords;
    }

    @Step
    public List<ProductRecord> getProductsFromCart(){
        return ProductUtils.getProductsFromWebElementsList(
                this.yourCartPage.getYourCartProductsList(), this.yourCartPage.getCartItemClassSelector(),
                this.yourCartPage.getCartNameClassSelector(), this.yourCartPage.getCartDescriptionClassSelector(),
                this.yourCartPage.getCartPriceClassSelector(), this.yourCartPage.getCarttAddToCardButtonClassSelector());
    }

    @Step
    public List<ProductRecord> getProductsFromOverview(){
        return ProductUtils.getProductsFromWebElementsList(
                this.yourCartPage.getYourCartProductsList(), this.yourCartPage.getCartItemClassSelector(),
                this.yourCartPage.getCartNameClassSelector(), this.yourCartPage.getCartDescriptionClassSelector(),
                this.yourCartPage.getCartPriceClassSelector(), null);
    }

    @Step
    public void goToCheckoutPage(){
        this.yourCartPage.getCheckoutButton().click();
    }

    @Step
    public void fillCheckoutData(InformationFormRecord informationFormRecord){
        this.checkoutInformationPage.getFirstNameInputField().sendKeys(informationFormRecord.firstName());
        this.checkoutInformationPage.getLastNameInputField().sendKeys(informationFormRecord.lastName());
        this.checkoutInformationPage.getPostalCodeInputField().sendKeys(informationFormRecord.postalCode());
    }

    @Step
    public InformationFormRecord getInformationDataFilledRecord(){
        return new InformationFormRecord(
                this.checkoutInformationPage.getFirstNameInputField().getValue(),
                this.checkoutInformationPage.getLastNameInputField().getValue(),
                this.checkoutInformationPage.getPostalCodeInputField().getValue()
        );
    }

    @Step
    public void goToOverviewPage(){
        this.checkoutInformationPage.getContinueButton().click();
    }

    @Step
    public void goToCompletePage(){
        this.overviewPage.getFinishButton().click();
    }

    @Step
    public boolean atCompletePage(){
        return this.completePage.at(this.completePage.getPonyExpressLogo());
    }
}
