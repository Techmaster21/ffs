import { Component, OnInit } from '@angular/core';
import { CalendarEvent } from 'angular-calendar';
import { Subject } from 'rxjs/Subject';
import { RecipeService } from '../../services/recipe.service';
import { FFSCalendarEvent } from '../../models/ffs-calendar-event';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  }
};
/**
 * View for Calendar
 */
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  activeDayIsOpen = false;
  viewDate: Date = new Date();
  view = 'month';
  refresh: Subject<any> = new Subject();
  calendarEvents: Array<FFSCalendarEvent> = [];

 events: Array<CalendarEvent> = [
    {
      start: new Date(),
      end: new Date(),
      title: 'A 3 day event',
      color: colors.red
    }
    ];

  constructor(private recipeService: RecipeService) {}

  ngOnInit(): void {
    this.recipeService.getEvents()
      .subscribe(events => {
        this.calendarEvents = events;
        console.log(this.calendarEvents);
      });

  }

}
