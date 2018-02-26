import { Ingredient } from './ingredient';
import { Cuisine } from './cuisine';
import { FFSer } from './ffser';
import { Step } from './step';


export class Recipe {
  name: string;
  cookTime?: string;
  cuisine?: Cuisine;
  ffser?: FFSer;
  ingredients: Ingredient[];
  prepTime?: string;
  description: string;
  steps: Step[];
  id?: number;
}
