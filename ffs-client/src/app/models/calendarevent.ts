import { Recipe } from './recipe';

export class Calendarevent {
  /**
   * represents an event in a calendar
   * @param date the date the event takes place
   * @param recipe the recipe selected for the event
   */
  constructor(
    public date = new Date(),
    public recipe = new Recipe()
  ) {}
}
