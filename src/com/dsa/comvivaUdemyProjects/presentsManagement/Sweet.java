package com.dsa.comvivaUdemyProjects.presentsManagement;

public abstract class Sweet {
    String name;
    double weight;
    double sugarWeight;
    double doughWeight;

    Sweet(String name, int weight, int sugarWeight ){
        this.name = name;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
    }
    Sweet(String name, int weight, int sugarWeight, double doughWeight ){
        this.name = name;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
        this.doughWeight = doughWeight;
    }
    Sweet(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setSugarWeight(double weight) {
        this.sugarWeight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setDoughWeight(double weight) {
        this.doughWeight = weight;
    }
}
