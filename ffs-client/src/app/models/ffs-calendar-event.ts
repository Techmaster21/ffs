import { Recipe } from './recipe';
import { User } from './user';

export class FFSCalendarEvent {
  /**
   * represents an event in a calendar
   * @param date the date the event takes place
   * @param recipe the recipe selected for the event
   */
  constructor(
    public id = 0,
    public startTime: Date = new Date(),
    public endTime: Date = new Date(),
    public recipe = new Recipe(),
    public user = new User()
  ) {
  }
}
