package edu.niu.cs.caleb.program2;

/**
 * Created by z1731660 on 1/26/2017.
 */
public class ShipItem {
    //instance vars
    private Integer weight;
    private Double baseCost, addedCost, totalCost;

    //constants

    static final Double BASE_AMOUNT = 3.00;
    static final Double ADDED_AMOUNT = .50;
    static final Double EXTRA_OUNCES = 4.0;
    static final Integer BASE_WEIGHT = 16;

    public ShipItem()
    {
        weight = 0;
            baseCost = BASE_AMOUNT;
            addedCost = 0.0;
            totalCost = 0.0;
    }
    public void setWeight(Integer newWeight)
    {
        weight = newWeight;
        computeCost();
    }

    public void computeCost()
    {
        addedCost = 0.0;
        baseCost = BASE_AMOUNT;

        if(weight <= 0)
            baseCost = 0.00;
        else if(weight > BASE_WEIGHT)
            addedCost = Math.ceil((weight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED_AMOUNT;
        totalCost = baseCost + addedCost;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public Double getAddedCost() {
        return addedCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}//end of ShipItem
