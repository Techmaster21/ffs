import { Ingredient } from './ingredient';
import { Cuisine } from './cuisine';
import { FFSer } from './ffser';
import { Step } from './step';


export class Recipe {
  constructor(
    public name: string,
    public description: string,
    public ingredients: Ingredient[],
    public steps: Step[],
    public cuisine?: Cuisine,
    public prepTime?: string,
    public cookTime?: string,
    public ffser?: FFSer,
    public id?: number
  ) {}
}
