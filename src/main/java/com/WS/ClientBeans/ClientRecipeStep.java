/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.RecipeStep;

/**
 *
 * @author Eric
 */
public class ClientRecipeStep {
    
    private String step;

    public ClientRecipeStep() {
    }
   
    public ClientRecipeStep(RecipeStep step) {
        this.step = step.getStep();
    }

    public ClientRecipeStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
    
    
}
