package com.mitrais.cdc.java.resources;

public class CarSale implements Sellable {

    private final String carName;
	private final double listPrice;
    private final double discount;

  public CarSale(String carName, double listPrice, double discount) {
	//TODO: complete this so it will set the properties when called 
	  this.carName=carName;
	  this.listPrice=listPrice;
	  this.discount=discount;	  	  
  }

  //TODO: make sure each attributes/properties has getter/setter
  /**
   * get carName value
   * @return String
   */
  public String getCarName() {
		return carName;
	}
  /**
   * get ListPrice value
   * @return double
   */
  public double getListPrice() {
		return listPrice;
	}
  /**
   * get Discount of car value
   * @return
   */
  public double getDiscount() {
		return discount;
	}
  
  
  
  @Override
  /** 
   * Will return finalCost based on price - discount percentage
   */
  public double getCost() {
	double finalCost = 0;
	//TODO: create calculation to calculate finalCost based on price and discount here
      /** The discount in percent. For example, if discount is 5, then the total cost is
       *  0.95 times the list price.
       */
	finalCost=(100-discount)/100*listPrice;
	return(finalCost);
  }
  /**
   * printout instance class values
   */
  @Override
  public String toString() {
	String toString = new String();	
	//TODO: modify this method to return sentence e.g. "This car name is blablabla, its price is blabla, with discount blabla"
	toString="This car name is "+carName+", its price is "+getCost()+", with discount "+discount;
	return toString;
  }
}
