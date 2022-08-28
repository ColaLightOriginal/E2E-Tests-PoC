package StepDefinitions;

import Records.InformationFormRecord;
import Records.ProductRecord;
import Records.UserRecord;
import Steps.MenuSteps;
import Steps.SaleProcessSteps;
import Utils.ProductUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static Utils.ProductUtils.compareTwoLists;

public class SaleProcessStepDefinition {

    @Steps
    private SaleProcessSteps saleProcessSteps;
    @Steps
    private MenuSteps menuSteps;

    private InformationFormRecord informationFormRecord;
    private List<ProductRecord> chosenProducts = new ArrayList<>();

    @When("I add product {string} to cart")
    public void addProductsToCartByProductName(String productName) {
        this.chosenProducts.add(this.saleProcessSteps.addProductToCartByName(productName));
    }

    @When("I add number of {string} products to cart")
    public void addProductsToCartByNumber(String numberOfProducts){
        this.chosenProducts = this.saleProcessSteps.addProductsToCartByNumber(Integer.getInteger(numberOfProducts));
    }

    @Then("Product was added")
    public void productWasAdded() {
        int productsCount = this.chosenProducts.size();
        Assert.assertEquals(productsCount, this.menuSteps.getCartBadgeNumber());
    }

    @When("I go to my cart")
    public void goToMyCart() {
        this.menuSteps.clickCartButton();
    }

    @Then("I check products in my cart")
    public void validateProductsInCartWithChosenProducts() {
        List<ProductRecord> cartProducts = this.saleProcessSteps.getProductsFromCart();
        Assert.assertTrue(ProductUtils.compareTwoLists(this.chosenProducts, cartProducts));
    }

    @When("I go to checkout page")
    public void goToCheckoutPage(){
        this.saleProcessSteps.goToCheckoutPage();
    }

    @And("I fill my information data with {string}, {string} and {string}")
    public void fillCheckoutData(String firstName, String lastName, String postalCode) {
        this.informationFormRecord = new InformationFormRecord(firstName, lastName, postalCode);
        this.saleProcessSteps.fillCheckoutData(informationFormRecord);
    }

    @Then("I check data in information form")
    public void checkDataInInformationForm() {
       InformationFormRecord informationFormFilledRecord = this.saleProcessSteps.getInformationDataFilledRecord();
       Assert.assertEquals(informationFormRecord.firstName(), informationFormFilledRecord.firstName());
       Assert.assertEquals(informationFormRecord.lastName(), informationFormFilledRecord.lastName());
       Assert.assertEquals(informationFormRecord.postalCode(), informationFormFilledRecord.postalCode());
    }

    @When("I go to overview page")
    public void clickContinueButton(){
        this.saleProcessSteps.goToOverviewPage();
    }

    @When("I check product in overview page")
    public void validateProductsOnOverviewPageWithChosenProducts() {
        List<ProductRecord> overviewProducts = this.saleProcessSteps.getProductsFromOverview();
        Assert.assertTrue(compareTwoLists(this.chosenProducts, overviewProducts));
    }

    @When("I go to confirmation page")
    public void clickFinishButton() {
        this.saleProcessSteps.goToCompletePage();
    }

    @Then("I see information about order dispatchment")
    public void atCompletePage() {
        Assert.assertTrue(this.saleProcessSteps.atCompletePage());
    }
}
