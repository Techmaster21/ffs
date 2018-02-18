import { Ingredient } from './ingredient';

export class Recipe {
  key: number;
  name: string;
  description: string;
  ingredients: Ingredient[];
  instructions: string[];
}
