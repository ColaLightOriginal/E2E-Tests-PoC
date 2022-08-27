package Records;

import net.serenitybdd.core.pages.WebElementFacade;

public record ProductRecord(String name, String description, float price, WebElementFacade addToCardButton) {

    public boolean equals(String name, String description, float price){
        return this.name.equals(name) && this.description.equals(description) && this.price == price;
    }
}
