import { Component, OnInit } from '@angular/core';
import { CalendarEvent } from 'angular-calendar';
import { Subject } from 'rxjs/Subject';
import { RecipeService } from '../../services/recipe.service';
import { FFSCalendarEvent } from '../../models/ffs-calendar-event';
import {
  isSameDay,
  isSameMonth
} from 'date-fns';

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
  events: Array<CalendarEvent> = [];

  constructor(private recipeService: RecipeService) {
  }

  ngOnInit(): void {
    this.recipeService.getEvents()
      .subscribe(events => {
        this.calendarEvents = events;
        for (const event of this.calendarEvents) {
          this.events.push({
            start: event.startTime,
            end: event.endTime,
            title: event.recipe.name,
            color: colors.red
          });
        }
        this.refresh.next();
      });

  }

  eventClicked(event: CalendarEvent): void {
  
  }

  dayClicked({date, events}: { date: Date; events: Array<CalendarEvent> }): void {
    if (isSameMonth(date, this.viewDate)) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
        this.viewDate = date;
      }
    }
  }


}
