import { Component } from '@angular/core';
import { CalendarEvent } from 'angular-calendar';

/**
 * View for Calendar
 */
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent {
  viewDate: Date = new Date();
  events: Array<CalendarEvent> = [];
}
